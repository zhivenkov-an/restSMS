package ru.zhivenkov.restSMS.services;

import ru.zhivenkov.restSMS.repository.SmsDb;

import java.util.List;

public interface SmsService{
    /**
     * Создает новое CMC
     * @param smsDb - СМС для создания
     */
    void create(SmsDb smsDb);

    /**
     * Возвращает список всех имеющихся СМС
     * @return список СМС
     */
    List<SmsDb> readAll();

    /**
     * Возвращает СМС по его ID
     * @param id - ID СМС
     * @return - объект СМС с заданным ID
     */
    SmsDb read(int id);

    /**
     * Обновляет СМС с заданным ID,
     * в соответствии с переданным клиентом
     * @param smsDb - СМС в соответсвии с которым нужно обновить данные
     * @param id - id СМС которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(SmsDb smsDb, int id);

    /**
     * Удаляет СМС с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}
