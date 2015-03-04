package net.ctct.mysvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @Value("${greeting}")
    String greeting;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return String.format("%s, World!", greeting);
    }

}
