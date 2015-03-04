package net.ctct.mysvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @Configuration
// @EnableAutoConfiguration
// @ComponentScan
// Equivalent:
@SpringBootApplication
//@EnableConfigServer
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        app.run(args);
    }

}
