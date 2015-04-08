package net.ctct.mysvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Random;

@RestController
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/")
    @ResponseBody
    String consume() {

        List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCER");
        System.out.println("Got instances: " + instances.size());
        if (instances.size() == 0)
            return "NaN";

        Random randomGenerator = new Random(System.currentTimeMillis());
        ServiceInstance instance = instances.get(randomGenerator.nextInt(instances.size()));

        URI producerUri = URI.create("http://" + instance.getHost() + ":" + instance.getPort());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProducerResponse> response = restTemplate.getForEntity(producerUri, ProducerResponse.class);

        return String.format("{\"value\": %s}", response.getBody().value);
    }

}

