package ru.zhivenkov.restSMS.services;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.zhivenkov.restSMS.repository.SmsDb;
import ru.zhivenkov.restSMS.repository.SmsRepository;

import java.util.List;

@RestController
public class SmsDbController implements SmsService{

    private final SmsRepository smsRepository;

    public SmsDbController(SmsRepository smsRepository) {
        this.smsRepository = smsRepository;
    }

    @Override
    public void create(SmsDb smsDb) {
        smsRepository.save(smsDb);
    }

    @Override
    @GetMapping(value="/smsdbes",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<SmsDb> readAll() {
        return smsRepository.findAll();
    }

    @Override
    @GetMapping(value = "/smsdbes/{smsId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public SmsDb read(@PathVariable("smsId") int smsId) {
        return smsRepository.findById(smsId).get();
    }

    @Override
    public boolean update(SmsDb smsDb, int id) {
        if (smsRepository.existsById(id)) {
            smsDb.setId(id);
            smsRepository.save(smsDb);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (smsRepository.existsById(id)) {
            smsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
