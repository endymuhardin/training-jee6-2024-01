package com.muhardin.endy.training.jee6.tokospring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "pembayaran_gopay")
public class PembayaranGopay extends Pembayaran {
    @Column(name = "nomor_handphone")
    private String nomorHandphone;
}
