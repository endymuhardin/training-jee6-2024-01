package com.muhardin.endy.training.jee6.tokospring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name = "pembayaran_virtual_account")
public class PembayaranVirtualAccount extends Pembayaran {
    private String bank;
    @Column(name = "nomor_rekening")
    private String nomorRekening;
}
