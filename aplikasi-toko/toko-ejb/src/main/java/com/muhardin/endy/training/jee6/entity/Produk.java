package com.muhardin.endy.training.jee6.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity @Data
@Table(name = "produk")
public class Produk {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull @Size(min = 3)
    private String kode;
    @NotNull @Size(min = 3)
    private String nama;
    private BigDecimal harga;
}
