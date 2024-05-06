package com.muhardin.endy.training.jee6.tokospring.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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