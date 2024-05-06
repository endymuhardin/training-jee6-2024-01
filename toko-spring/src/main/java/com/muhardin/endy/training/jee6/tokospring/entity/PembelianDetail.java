package com.muhardin.endy.training.jee6.tokospring.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity @Data
@Table(name = "pembelian_detail")
public class PembelianDetail {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_produk")
    private Produk produk;

    @NotNull @Min(1)
    private Integer jumlah;

    public BigDecimal getSubtotal(){
        return produk.getHarga().multiply(new BigDecimal(jumlah));
    }
}
