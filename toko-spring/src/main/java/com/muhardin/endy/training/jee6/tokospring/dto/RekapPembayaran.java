package com.muhardin.endy.training.jee6.tokospring.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RekapPembayaran {
    private String namaPelanggan;

    private LocalDateTime waktuPembelian;
    
    private LocalDateTime waktuPembayaran;

    public RekapPembayaran(String nama, LocalDateTime waktuBeli, LocalDateTime waktuBayar){
        this.namaPelanggan = nama;
        this.waktuPembelian = waktuBeli;
        this.waktuPembayaran = waktuBayar;
    }
}
