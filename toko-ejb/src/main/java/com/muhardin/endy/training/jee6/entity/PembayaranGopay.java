package com.muhardin.endy.training.jee6.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity @Data
public class PembayaranGopay extends Pembayaran {
    private String nomorHandphone;
}
