package com.muhardin.endy.training.jee6.tokospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhardin.endy.training.jee6.tokospring.entity.Pembelian;

public interface PembelianDao extends JpaRepository<Pembelian, String> {
    
}
