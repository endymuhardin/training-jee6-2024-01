package com.muhardin.endy.training.jee6.tokospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.muhardin.endy.training.jee6.tokospring.dao.PelangganDao;
import com.muhardin.endy.training.jee6.tokospring.entity.Pelanggan;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    @Autowired private PelangganDao pelangganDao;

    @GetMapping("/")
    public Page<Pelanggan> findPelanggan(Pageable page){
        return pelangganDao.findAll(page);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Pelanggan simpan(@RequestBody @Valid Pelanggan p) {
        return pelangganDao.save(p);
    }
}
