package com.muhardin.endy.training.jee6.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data
@Table(name = "pelanggan")
public class Pelanggan {

    @Id
    private String id;
    private String nama;
    private String email;
    
    // optional, tidak mempengaruhi skema database
    //@OneToMany(mappedBy = "pelanggan")
    //private List<Pembelian> daftarPembelian;
}