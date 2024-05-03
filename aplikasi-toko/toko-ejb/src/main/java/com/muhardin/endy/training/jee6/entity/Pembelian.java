package com.muhardin.endy.training.jee6.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity @Data
@Table(name = "pembelian")
public class Pembelian {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "waktu_transaksi")
    private LocalDateTime waktuTransaksi = LocalDateTime.now();

    @NotNull
    @ManyToOne  // defaultnya eager fetch : langsung dijoin. Hanya satu layer
    @JoinColumn(name = "id_pelanggan")
    private Pelanggan pelanggan;

    @OneToOne(mappedBy = "pembelian") // defaultnya eager fetch : langsung dijoin
    private Pembayaran pembayaran;

    @JsonManagedReference
    @OneToMany(mappedBy = "pembelian", // dimapping ke variabel pembelian di sisi seberang
    fetch = FetchType.EAGER, // langsung load tiap kali query pembelian, defaultnya lazy loading
    cascade = CascadeType.ALL, 
    orphanRemoval = true)
    private List<PembelianDetail> daftarPembelianDetail 
        = new ArrayList<PembelianDetail>();
}
