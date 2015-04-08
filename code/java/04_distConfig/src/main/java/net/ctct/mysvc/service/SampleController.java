package net.ctct.mysvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class SampleController {

    @Value("${greeting: Fun}")
    String greeting;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return String.format("%s, World!", greeting);
    }

}
