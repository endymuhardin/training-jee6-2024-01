package com.muhardin.endy.training.jee6.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity @Data
@Table(name = "pembayaran")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pembayaran {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;

    @Column(name = "waktu_transaksi")
    private LocalDateTime waktuTransaksi;
    private BigDecimal nilai;

    @Column(name = "nomor_referensi")
    private String nomorReferensi;
}
