package com.muhardin.endy.training.jee6.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity @Data
public class Pembelian {
    @Id
    private String id;
    private LocalDateTime waktuTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan")
    private Pelanggan pelanggan;

    @OneToOne(mappedBy = "pembelian")
    private Pelanggan pembayaran;

    @OneToMany(mappedBy = "pembelian", 
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PembelianDetail> daftarPembelianDetail 
        = new ArrayList<PembelianDetail>();
}
