package net.ctct.mysvc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// @Configuration
// @EnableAutoConfiguration
// @ComponentScan
// Equivalent:
@SpringBootApplication
//@EnableConfigServer
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(Application.class);
//        app.setShowBanner(false);
//        app.run(args);

        new SpringApplicationBuilder(Application.class)
                .web(true)
                .showBanner(false)
                .run(args);
    }

}
