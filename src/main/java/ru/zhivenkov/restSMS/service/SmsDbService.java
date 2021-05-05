package ru.zhivenkov.restSMS.service;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zhivenkov.restSMS.repository.SmsDb;

import java.util.List;

@Service
public class SmsDbService {

    @Autowired
    DSLContext context;

    public List<SmsDb> getSmsDb(){
        return context
                .selectFrom("sms")
                .fetchInto(SmsDb.class);
    }

}
