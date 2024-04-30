package com.muhardin.endy.training.jee6.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity @Data
public class Pembayaran {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;

    private LocalDateTime waktuTransaksi;
}
