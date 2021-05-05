package ru.zhivenkov.restSMS.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.zhivenkov.restSMS.repository.SmsDb;
import ru.zhivenkov.restSMS.repository.SmsDbRepository;
import ru.zhivenkov.restSMS.repository.SmsRepository;
import ru.zhivenkov.restSMS.service.SmsDbService;
import ru.zhivenkov.restSMS.service.SmsService;

import java.util.List;

@RestController
public class SmsDbController implements SmsService {

    private final SmsRepository smsRepository;
    private final SmsDbRepository smsDbRepository;

    private  final SmsDbService smsDbService;

    public SmsDbController(SmsRepository smsRepository, SmsDbRepository smsDbRepository, SmsDbService smsDbService) {
        this.smsRepository = smsRepository;
        this.smsDbRepository = smsDbRepository;
        this.smsDbService = smsDbService;
    }

    @Override
    @PostMapping(value = "/smsdbes",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void create(@RequestBody SmsDb smsDb) {
        System.out.println("(Service Side) Insert new smsDb: " + smsDb.getId());
        if (! smsRepository.existsById(smsDb.getId())) {
            smsRepository.save(smsDb);
        }

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
        return smsRepository.findById(smsId).orElse(null);
    }


    @PutMapping(value = "/smsdbes",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public boolean update(@RequestBody SmsDb smsDb) {
        if (smsRepository.existsById(smsDb.getId())) {
            //smsDb.setId(smsDb.getId());
            smsRepository.save(smsDb);
            return true;
        }

        return false;
    }

    @Override
    @DeleteMapping(value = "/smsdbes/{smsId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public boolean delete(@PathVariable("smsId") int id) {
        if (smsRepository.existsById(id)) {
            smsRepository.deleteById(id);
            return true;
        }
        return false;
    }

/*
    @GetMapping(value = "/smsfind/{word}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<SmsDb> findByWord(@PathVariable("word") String word) {
        // список новостей в которых встречается ключевое слово
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ru.zhivenkov.restSMS.jpa.hibernate");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();


    }
*/

    @GetMapping(value = "/smsfindbyauthor/{authorId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<SmsDb> findByAuthor(@PathVariable("authorId") int authorId) {
        // список СМС по автору
        return smsDbRepository.findSmsByAuthorId(authorId);
    }



    @GetMapping(value="/smsdbes_jooq",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<SmsDb> readAllJooq() {
        return smsDbService.getSmsDb();
    }



}
