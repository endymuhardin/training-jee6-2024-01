package com.muhardin.endy.training.jee6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data
@Table(name = "pembayaran_gopay")
public class PembayaranGopay extends Pembayaran {
    @Column(name = "nomor_handphone")
    private String nomorHandphone;
}
