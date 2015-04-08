package net.ctct.mysvc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
//                .properties("spring.config.name=configserver")
                .showBanner(false)
                .run(args);
    }

}
