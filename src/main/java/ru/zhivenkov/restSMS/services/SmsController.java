package ru.zhivenkov.restSMS.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zhivenkov.restSMS.repository.Sms;
import ru.zhivenkov.restSMS.repository.SmsDAO;
import org.springframework.http.MediaType;


import java.util.List;

@RestController
public class SmsController {

    public final String sharedKey = "SHARED_KEY";

    public static final String SUCCESS_STATUS = "success";
    public static final String ERROR_STATUS = "error";
    public static final int CODE_SUCCESS = 100;
    public static final int AUTH_FAILURE = 102;

    @Autowired
    private SmsDAO smsDAO;


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
                                @RequestBody Sms requestSMS){

        final BaseResponse response;

        if (sharedKey.equalsIgnoreCase(key)){
            int smsId = requestSMS.getSmsId();
            String smsValue = requestSMS.getSmsValue();

            // process for SMS service
            //
            response = new BaseResponse(SUCCESS_STATUS,CODE_SUCCESS);
        }
        else{
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }

        return response;
    }

    @GetMapping(value="/smses",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<Sms> getSmses(){
        return smsDAO.getAllSmses();
    }

    @GetMapping(value = "/smses/{smsId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Sms getSms(@PathVariable("smsId") Integer smsId){
        return  smsDAO.getSms(smsId);
    }

    @PostMapping(value = "/smses",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Sms addSms(@RequestBody Sms sms){
        System.out.println("(Service Side) Creating new sms: " + sms.getSmsId());
        return smsDAO.addSms(sms);
    }

    @PutMapping(value = "/smses",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Sms updateSms(@RequestBody Sms sms){
        System.out.println("(Service Side) Editing sms: " + sms.getSmsId());
        return smsDAO.updateSms(sms);
    }

    @DeleteMapping(value = "/smses/{smsId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void deleteSms(@PathVariable("smsId") Integer smsId){
        smsDAO.deleteSms(smsId);
    }



}
