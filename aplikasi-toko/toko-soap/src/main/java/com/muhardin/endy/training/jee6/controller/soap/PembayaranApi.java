package com.muhardin.endy.training.jee6.controller.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.muhardin.endy.training.jee6.dao.PembayaranDao;
import com.muhardin.endy.training.jee6.dto.RekapPembayaran;

@WebService
public class PembayaranApi {
    @EJB private PembayaranDao pembayaranDao;

    @WebMethod
    public List<RekapPembayaran> tampilkanRekapPembayaran(){
        return pembayaranDao.rekapPembayaran();
    }
}
