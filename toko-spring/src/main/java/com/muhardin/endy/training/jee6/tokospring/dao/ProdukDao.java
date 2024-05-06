package com.muhardin.endy.training.jee6.tokospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhardin.endy.training.jee6.tokospring.entity.Produk;

public interface ProdukDao extends JpaRepository<Produk, String> {

}
