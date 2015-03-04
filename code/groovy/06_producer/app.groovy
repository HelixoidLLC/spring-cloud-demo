
@Grab("org.springframework.cloud:spring-cloud-starter-eureka:1.0.0.BUILD-SNAPSHOT")

import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@RestController
@Log
public class Application {

  int counter = 0

  @RequestMapping(value = "/", produces = "application/json")
  String produce() {
    counter++
    log.info("Produced a value: ${counter}")

    "{\"value\": ${counter}}"
  }
}
