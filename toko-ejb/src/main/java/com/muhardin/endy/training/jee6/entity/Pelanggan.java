package com.muhardin.endy.training.jee6.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class Pelanggan {

    @Id
    private String id;
    private String nama;
    private String email;
    
    
}