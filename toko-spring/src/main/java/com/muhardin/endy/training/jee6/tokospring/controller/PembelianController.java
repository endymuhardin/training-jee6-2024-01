package com.muhardin.endy.training.jee6.tokospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.muhardin.endy.training.jee6.tokospring.dao.PembelianDao;
import com.muhardin.endy.training.jee6.tokospring.entity.Pembelian;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/pembelian")
public class PembelianController {

    @Autowired private PembelianDao pembelianDao;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void simpan(@RequestBody @Valid Pembelian p){
        pembelianDao.save(p);
    }

    @GetMapping("/{id}")
    public Pembelian findById(@PathVariable String id){
        return pembelianDao.findById(id).get();
    }
}
