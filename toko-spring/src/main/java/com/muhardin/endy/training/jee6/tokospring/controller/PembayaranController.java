package com.muhardin.endy.training.jee6.tokospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhardin.endy.training.jee6.tokospring.dao.PembayaranDao;
import com.muhardin.endy.training.jee6.tokospring.dto.RekapPembayaran;

@RestController
@RequestMapping("/api/pembayaran")
public class PembayaranController {

    @Autowired private PembayaranDao pembayaranDao;

    @GetMapping("/rekap")
    public List<RekapPembayaran> rekapPembayaran(){
        return pembayaranDao.rekapPembayaran();
    }
}
