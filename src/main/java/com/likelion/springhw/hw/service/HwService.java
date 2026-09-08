package com.likelion.springhw.hw.service;

import com.likelion.springhw.hw.repository.HwRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class HwService {

    private final HwRepository hwRepository;

    // 생성자
    public HwService(HwRepository hwRepository) {
        this.hwRepository = hwRepository;
    }

    // myname
    public String myname(String name){
        String result = "제 이름은 " + name + "입니다.";

        return result;
    }

    //greet
    public String greet(String name, int hour) {
        String greeting;

        if(hour <= 5) {
            greeting = "아직 안 주무셨어요?";
        } else if (hour < 12) {
            greeting = "좋은 아침이에요";
        } else if (hour < 18) {
            greeting = "좋은 오후예요";
        } else {
            greeting = "좋은 저녁이에요";
        }

        String result = greeting + ", " + name + "님!";
        hwRepository.save(result);

        return result;
    }

    //messages
    public List<String> getAllMessages() {
        return hwRepository.findAll();
    }

    //messages/count
    public int getNumMessages() {
        return hwRepository.countMessages();
    }

    public int divide(int a, int b) {
        return a/b;
    }

}
