package net.ctct.mysvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@RestController
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    LoadBalancerClient loadBalancer;

    @Autowired
    ProducerClient client;

    @RequestMapping("/")
    @ResponseBody
    String consume() {

        ProducerResponse response = client.getValue();

        return "{\"value\": " + response.getValue() + "}";
    }

}

