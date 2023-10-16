package com.simulator.logsimulator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @PostMapping("/main")
    public String main() {
        return "main";
    }
}
