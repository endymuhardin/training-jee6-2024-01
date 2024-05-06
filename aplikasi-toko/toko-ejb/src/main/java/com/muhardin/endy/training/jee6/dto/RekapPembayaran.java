package com.muhardin.endy.training.jee6.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Data;

@Data
public class RekapPembayaran {
    private String namaPelanggan;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime waktuPembelian;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime waktuPembayaran;

    public RekapPembayaran(String nama, LocalDateTime waktuBeli, LocalDateTime waktuBayar){
        this.namaPelanggan = nama;
        this.waktuPembelian = waktuBeli;
        this.waktuPembayaran = waktuBayar;
    }
}
