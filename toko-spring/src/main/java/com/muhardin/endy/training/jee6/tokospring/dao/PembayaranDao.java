package com.muhardin.endy.training.jee6.tokospring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.muhardin.endy.training.jee6.tokospring.dto.RekapPembayaran;
import com.muhardin.endy.training.jee6.tokospring.entity.Pembayaran;

public interface PembayaranDao extends JpaRepository<Pembayaran, String> {
    
    @Query(value = Pembayaran.SQL_REKAP_PEMBAYARAN, nativeQuery = true)
    public List<RekapPembayaran> rekapPembayaran();
}
