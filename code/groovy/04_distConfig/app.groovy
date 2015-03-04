@Grab("org.springframework.cloud:spring-cloud-starter-bus-amqp:1.0.0.BUILD-SNAPSHOT")

import org.springframework.cloud.context.config.annotation.RefreshScope

@Configuration
@EnableAutoConfiguration
@RestController
class BasicConfig {

  @Autowired
  Greeter greeter

  @RequestMapping("/")
  String home() {
    "${greeter.greeting} World!"
  }
}

@Component
@RefreshScope
class Greeter {

  @Value('${greeting}')
  String greeting

}
