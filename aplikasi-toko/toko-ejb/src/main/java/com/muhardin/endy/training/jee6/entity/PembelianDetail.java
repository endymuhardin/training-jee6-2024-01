package com.muhardin.endy.training.jee6.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
