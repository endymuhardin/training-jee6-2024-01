package com.muhardin.endy.training.jee6.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity @Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pembayaran {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;
    private LocalDateTime waktuTransaksi;
    private BigDecimal nilai;
    private String nomorReferensi;
}
