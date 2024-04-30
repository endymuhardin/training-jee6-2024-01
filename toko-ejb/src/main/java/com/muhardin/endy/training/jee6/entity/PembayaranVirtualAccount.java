package com.muhardin.endy.training.jee6.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity @Data
public class PembayaranVirtualAccount extends Pembayaran {
    private String bank;
    private String nomorRekening;
}
