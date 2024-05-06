package com.muhardin.endy.training.jee6.controller.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.muhardin.endy.training.jee6.dao.PembayaranDao;
import com.muhardin.endy.training.jee6.dao.PembelianDao;
import com.muhardin.endy.training.jee6.dto.RekapPembayaran;
import com.muhardin.endy.training.jee6.entity.Pembayaran;
import com.muhardin.endy.training.jee6.entity.PembayaranGopay;
import com.muhardin.endy.training.jee6.entity.PembayaranVirtualAccount;
import com.muhardin.endy.training.jee6.entity.Pembelian;

@Path("/api/pembayaran")
public class PembayaranApi {
@EJB private PembayaranDao pembayaranDao;
@EJB private PembelianDao pembelianDao;

    @GET
    @Path("/")
    @Produces("application/json")
    public Pembayaran cariPembayaranByIdPembelian(@QueryParam("idPembelian") String id){
        Pembelian p = pembelianDao.cariById(id);
        if(p != null) {
            return pembayaranDao.cariByPembelian(p);
        }
        return null;
    }

    @POST @Path("/virtual_account/")
    @Produces("application/json")
    @Consumes("application/json")
    public Pembayaran simpanPembayaranVa(@Valid PembayaranVirtualAccount p){
        return pembayaranDao.simpan(p);
    }

    @POST @Path("/gopay/")
    @Produces("application/json")
    @Consumes("application/json")
    public Pembayaran simpanPembayaranGopay(@Valid PembayaranGopay p){
        return pembayaranDao.simpan(p);
    }

    @GET @Path("/rekap")
    @Produces("application/json")
    public List<RekapPembayaran> rekapPembayaran(){
        return pembayaranDao.rekapPembayaran();
    }
}
