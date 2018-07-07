package com.lava.lavafaq.service.impl;

import com.lava.lavafaq.service.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
