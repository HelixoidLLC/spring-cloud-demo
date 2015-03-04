package net.ctct.mysvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
class Greeter {
    @Value("${greeting}")
    String greeting;
}