package net.ctct.mysvc.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProducerClient {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getProducerFallback")
    public ProducerResponse getProducerResponse() {
        return restTemplate.getForObject("http://producer", ProducerResponse.class);
    }

    public ProducerResponse getProducerFallback() {
        ProducerResponse producerResponse = new ProducerResponse();
        producerResponse.value = 42;
        return producerResponse;
    }
}