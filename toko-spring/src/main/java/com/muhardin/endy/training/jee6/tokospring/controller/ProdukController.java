package com.muhardin.endy.training.jee6.tokospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhardin.endy.training.jee6.tokospring.dao.ProdukDao;
import com.muhardin.endy.training.jee6.tokospring.entity.Produk;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {

    @Autowired private ProdukDao produkDao;

    @GetMapping("/")
    public Page<Produk> dataProduk(Pageable page){
        return produkDao.findAll(page);
    }
}
