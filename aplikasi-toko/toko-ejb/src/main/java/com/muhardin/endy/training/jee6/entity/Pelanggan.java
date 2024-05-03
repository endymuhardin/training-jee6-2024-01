package com.muhardin.endy.training.jee6.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity @Data
@Table(name = "pelanggan")
public class Pelanggan {

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    private String nama;

    @NotNull
    private String email;
    
    // optional, tidak mempengaruhi skema database
    //@OneToMany(mappedBy = "pelanggan")
    //private List<Pembelian> daftarPembelian;
}