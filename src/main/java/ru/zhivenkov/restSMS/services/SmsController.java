package ru.zhivenkov.restSMS.services;
import org.springframework.web.bind.annotation.*;

@RestController
public class SmsController {

    public final String sharedKey = "SHARED_KEY";

    public static final String SUCCESS_STATUS = "success";
    public static final String ERROR_STATUS = "error";
    public static final int CODE_SUCCESS = 100;
    public static final int AUTH_FAILUER = 102;


    @RequestMapping("/")
    public String index(){
        return "Start page for SMS Controller";
    }

    @GetMapping
    public BaseResponse showStatus(){
        return new BaseResponse(SUCCESS_STATUS,1);
    }


    @PostMapping("/sendsms")
    public BaseResponse sendSms(@RequestParam(value = "key") String key,
                                @RequestBody SmsRequest requestSMS){

        final BaseResponse response;

        if (sharedKey.equalsIgnoreCase(key)){
            int smsId = requestSMS.getSmsId();
            String smsValue = requestSMS.getSmsValue();

            // process for SMS service
            //
            response = new BaseResponse(SUCCESS_STATUS,CODE_SUCCESS);
        }
        else{
            response = new BaseResponse(ERROR_STATUS,AUTH_FAILUER);
        }

        return response;
    }



}
