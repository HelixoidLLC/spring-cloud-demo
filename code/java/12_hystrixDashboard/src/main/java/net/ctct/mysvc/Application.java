package net.ctct.mysvc;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
@SpringBootApplication
@EnableHystrixDashboard
public class Application {
    public static void main(String[] args) {
       new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }
}
