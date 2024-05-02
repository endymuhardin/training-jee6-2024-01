package com.muhardin.endy.training.jee6.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data
@Table(name = "pembelian_detail")
public class PembelianDetail {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;
    
    @ManyToOne
    @JoinColumn(name = "id_produk")
    private Produk produk;

    private Integer jumlah;
}
