package io.bank.service.Account.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class Account {
    @Id
    private long id;
    private String name;
    private String type;
    private String userId;
}
