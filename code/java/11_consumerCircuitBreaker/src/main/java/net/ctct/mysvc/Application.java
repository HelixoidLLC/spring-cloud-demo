package net.ctct.mysvc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
//@EnableCircuitBreaker
//@EnableFeignClients
public class Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class)
                .web(true)
                .showBanner(false)
                .run(args);
    }

}
