package com.muhardin.endy.training.jee6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data
@Table(name = "pembayaran_virtual_account")
public class PembayaranVirtualAccount extends Pembayaran {
    private String bank;
    @Column(name = "nomor_rekening")
    private String nomorRekening;
}
