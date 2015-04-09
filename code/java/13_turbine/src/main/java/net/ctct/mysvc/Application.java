package net.ctct.mysvc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
//@EnableTurbineAmqp
@EnableTurbine
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
       new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
