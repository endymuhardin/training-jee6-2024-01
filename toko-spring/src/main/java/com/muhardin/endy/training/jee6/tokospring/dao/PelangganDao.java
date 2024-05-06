package com.muhardin.endy.training.jee6.tokospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhardin.endy.training.jee6.tokospring.entity.Pelanggan;

public interface PelangganDao 
        extends JpaRepository<Pelanggan, String> {
    
}
