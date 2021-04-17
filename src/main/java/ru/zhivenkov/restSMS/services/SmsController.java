package ru.zhivenkov.restSMS.services;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SmsController {
    @RequestMapping("/")
    public String index(){
        return "Start page for SMS Controller";
    }
}
