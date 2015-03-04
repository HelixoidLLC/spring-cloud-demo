package net.ctct.mysvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    ProducerClient client;

    @RequestMapping("/")
    @ResponseBody
    String consume() {

        ProducerResponse response = client.getProducerResponse();

        return "{\"value\": " + response.value + "}";
    }

}

