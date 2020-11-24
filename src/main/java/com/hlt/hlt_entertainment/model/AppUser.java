package com.hlt.hlt_entertainment.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class AppUser {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String userName;

private String password;

private String rePassword;

private String phoneNumber;
}
