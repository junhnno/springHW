package com.likelion.springhw.hw.controller;

import com.likelion.springhw.hw.service.HwService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HwController {
    private final HwService hwService;

    public HwController(HwService hwService) {
        this.hwService = hwService;
    }

    @GetMapping("/my-name")
    public String myname(@RequestParam(defaultValue = "황준호") String name) {
        return hwService.myname(name);
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name, @RequestParam int hour) {
        return hwService.greet(name, hour);
    }

    @GetMapping("/messages")
    public List<String> messages() {
        return hwService.getAllMessages();
    }
}
