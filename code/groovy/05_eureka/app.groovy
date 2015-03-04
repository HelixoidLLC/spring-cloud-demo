@Grab('org.springframework.cloud:spring-cloud-starter-eureka-server:1.0.0.BUILD-SNAPSHOT')
//@GrabExclude("ch.qos.logback:logback-classic")

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
class Eureka {
}
