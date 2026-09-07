package com.likelion.springhw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HI {
    @GetMapping("/hi")
    public String hi() {
        return "난 기요미얌";
    }
}
