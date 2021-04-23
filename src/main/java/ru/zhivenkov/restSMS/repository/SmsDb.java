package ru.zhivenkov.restSMS.repository;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "sms")
public class SmsDb {

    @Id
    @Column(name="id")
    @SequenceGenerator(name = "smsIdSeq", sequenceName = "sms_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "smsIdSeq")
    private Integer id;

    @Column(name = "value")
    private String value;

    @Column(name = "creator_id")
    private Integer creatorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
}
