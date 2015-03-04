package net.ctct.mysvc;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
class DiscoveryClientExample implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DiscoveryClientExample.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... strings) throws Exception {
        for(ServiceInstance s: discoveryClient.getInstances("PRODUCER")) {
            logger.info("Detected PRODUCER@ " + ToStringBuilder.reflectionToString(s));
        }
    }
}
