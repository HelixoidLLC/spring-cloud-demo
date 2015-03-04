@Grab("org.springframework.cloud:spring-cloud-starter-bus-amqp:1.0.0.RC3")
@Grab("org.springframework.cloud:spring-cloud-config-server:1.0.0.RC3")
@Grab("org.springframework.cloud:spring-cloud-config-client:1.0.0.RC3")

import org.springframework.cloud.config.server.EnableConfigServer

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
class ConfigServer {
}
