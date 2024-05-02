package com.muhardin.endy.training.jee6.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data
@Table(name = "pembelian")
public class Pembelian {
    @Id
    private String id;

    @Column(name = "waktu_transaksi")
    private LocalDateTime waktuTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan")
    private Pelanggan pelanggan;

    @OneToOne(mappedBy = "pembelian")
    private Pembayaran pembayaran;

    @OneToMany(mappedBy = "pembelian", // dimapping ke variabel pembelian di sisi seberang
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PembelianDetail> daftarPembelianDetail 
        = new ArrayList<PembelianDetail>();
}
