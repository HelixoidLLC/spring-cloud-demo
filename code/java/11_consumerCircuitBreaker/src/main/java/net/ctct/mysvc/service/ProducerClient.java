package net.ctct.mysvc.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
public class ProducerClient {

//    @Autowired
//    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getProducerFallback")
    public ProducerResponse getProducerResponse() {
        return new ProducerResponse();
//        return restTemplate.getForObject("http://producer", ProducerResponse.class);
    }

    public ProducerResponse getProducerFallback() {
        ProducerResponse producerResponse = new ProducerResponse();
        producerResponse.value = 42;
        return producerResponse;
    }
}