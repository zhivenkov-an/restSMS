package ru.zhivenkov.restSMS.services;

public class SmsRequest {
    private int smsId;
    private String smsValue;

    public int getSmsId() {
        return smsId;
    }

    public void setSmsId(int smsId) {
        this.smsId = smsId;
    }

    public String getSmsValue() {
        return smsValue;
    }

    public void setSmsValue(String smsValue) {
        this.smsValue = smsValue;
    }



}
