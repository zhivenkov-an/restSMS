package ru.zhivenkov.restSMS.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<SmsDb, Integer> {
}
