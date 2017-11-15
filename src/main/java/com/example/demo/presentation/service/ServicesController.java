package com.example.demo.presentation.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wagner on 12/11/17
 */


@RestController
public class ServicesController {
    @RequestMapping(value = "/publicservice")
    public String getOpenService() {
        return "Public Service";
    }

    @RequestMapping(value = "/privateservice")
    public String getPrivate(){
        return "Private Service";
    }
}
