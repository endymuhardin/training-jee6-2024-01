package com.muhardin.endy.training.jee6.tokospring.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

    @JsonManagedReference
    @OneToOne(mappedBy = "pembelian") // defaultnya eager fetch : langsung dijoin
    private Pembayaran pembayaran;

    @JsonManagedReference
    @OneToMany(mappedBy = "pembelian", // dimapping ke variabel pembelian di sisi seberang
    fetch = FetchType.EAGER, // langsung load tiap kali query pembelian, defaultnya lazy loading
    cascade = CascadeType.ALL, 
    orphanRemoval = true)
    private List<PembelianDetail> daftarPembelianDetail 
        = new ArrayList<PembelianDetail>();

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for(PembelianDetail pd : getDaftarPembelianDetail()){
            total = total.add(pd.getSubtotal());
        }
        return total;
    }
}
