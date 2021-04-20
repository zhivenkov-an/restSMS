package ru.zhivenkov.restSMS.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SmsDAO {
    public static final Map<Integer, Sms> smsMap = new HashMap<Integer, Sms>();
    static {
        initSmses();
    }

    private static void initSmses() {
        Sms sms1 = new Sms(1, "First SMS");
        Sms sms2 = new Sms(2, "Second SMS");
        Sms sms3 = new Sms(3, "Third SMS");

        smsMap.put(sms1.getSmsId(),sms1);
        smsMap.put(sms2.getSmsId(),sms2);
        smsMap.put(sms3.getSmsId(),sms3);
    }

    public Sms getSms(Integer smsId){
        return smsMap.get(smsId);
    }

    public Sms addSms(Sms newSms){
        smsMap.put(newSms.getSmsId(),newSms);
        return newSms;
    }

    public Sms updateSms(Sms newSms){
        smsMap.put(newSms.getSmsId(),newSms);
        return newSms;
    }

    public void deleteSms(Integer smsId){
        smsMap.remove(smsId);
    }

    public List<Sms> getAllSmses(){
        Collection<Sms> colSms = smsMap.values();
        List<Sms> listSms = new ArrayList<>();
        listSms.addAll(colSms);
        return  listSms;
    }

}
