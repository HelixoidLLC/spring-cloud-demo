package net.ctct.mysvc.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
//@EnableCircuitBreaker
//@EnableHystrix
public class ProducerClient {

//    @Autowired
//    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getProducerFallback")
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
//            })
    ProducerResponse getProducerResponse() {
        return new ProducerResponse();
//        return restTemplate.getForObject("http://producer", ProducerResponse.class);
    }

    ProducerResponse getProducerFallback() {
        ProducerResponse producerResponse = new ProducerResponse();
        producerResponse.value = 42;
        return producerResponse;
    }
}