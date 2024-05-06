package com.muhardin.endy.training.jee6.controller.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.muhardin.endy.training.jee6.dao.PembayaranDao;
import com.muhardin.endy.training.jee6.dto.RekapPembayaran;
import com.muhardin.endy.training.jee6.entity.PembayaranVirtualAccount;

@WebService
public class PembayaranApi {
    @EJB private PembayaranDao pembayaranDao;

    @WebMethod
    public void simpanPembayaranVirtualAccount(PembayaranVirtualAccount va){
        pembayaranDao.simpan(va);
    }

    @WebMethod
    public List<RekapPembayaran> tampilkanRekapPembayaran(){
        return pembayaranDao.rekapPembayaran();
    }
}
