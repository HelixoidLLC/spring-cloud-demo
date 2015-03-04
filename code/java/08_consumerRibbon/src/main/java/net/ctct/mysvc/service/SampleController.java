package net.ctct.mysvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    LoadBalancerClient loadBalancer;

    @RequestMapping("/")
    @ResponseBody
    String consume() {

        ServiceInstance instance = loadBalancer.choose("PRODUCER");

        URI producerUri = URI.create("http://" + instance.getHost() + ":" + instance.getPort());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProducerResponse> response = restTemplate.getForEntity(producerUri, ProducerResponse.class);

        return String.format("{\"value\": %s}", response.getBody().value);
    }

}

