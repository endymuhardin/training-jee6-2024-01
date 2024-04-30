package com.muhardin.endy.training.jee6.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class Produk {
    @Id
    private String id;
    private String kode;
    private String nama;
    private BigDecimal harga;
}
