package ru.zhivenkov.restSMS.repository;

public class Sms {
    private Integer smsId;
    private String smsValue;

    public Sms(int smsId, String smsValue) {
        this.smsId = smsId;
        this.smsValue = smsValue;
    }

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
