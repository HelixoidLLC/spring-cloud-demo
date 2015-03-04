package net.ctct.mysvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

//    @Value("${greeting}")
    //String greeting = "Hello";

    @Autowired
    Greeter greeter;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return String.format("%s, World!", greeter.greeting);
    }

}
