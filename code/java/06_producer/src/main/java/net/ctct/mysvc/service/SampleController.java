package net.ctct.mysvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    int counter = 0;

    @RequestMapping(value = "/", produces = "application/json")
    @ResponseBody
    String produce() {
        counter++;
        logger.info("Produced a value: " + counter);

        return String.format("{\"value\": %s}", counter);
    }

}
