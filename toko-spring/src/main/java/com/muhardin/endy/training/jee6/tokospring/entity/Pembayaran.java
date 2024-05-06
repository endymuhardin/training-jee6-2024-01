package com.muhardin.endy.training.jee6.tokospring.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "pembayaran")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pembayaran {

    public static final String SQL_REKAP_PEMBAYARAN 
            = "select p.nama, beli.waktu_transaksi as waktu_beli, bayar.waktu_transaksi as waktu_bayar " + 
                "from pembelian beli " + 
                "inner join pelanggan p on beli.id_pelanggan = p.id " + 
                "inner join pembayaran bayar on bayar.id_pembelian = beli.id " + 
                "order by beli.waktu_transaksi ";

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;

    @Column(name = "waktu_transaksi")
    private LocalDateTime waktuTransaksi;
    private BigDecimal nilai;

    @Column(name = "nomor_referensi")
    private String nomorReferensi;
}
