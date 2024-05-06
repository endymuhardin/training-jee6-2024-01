package com.muhardin.endy.training.jee6.controller.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
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

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    @GET @Path("/list")
    @Produces("application/json")
    public List<Pembayaran> cariPembayaranByWaktuTransaksi(
                                @QueryParam("from") String strFrom, 
                                @QueryParam("to") String strTo,
                                @DefaultValue("0") @QueryParam("start") Integer start, 
                                @DefaultValue("10") @QueryParam("rows") Integer rows){
        LocalDateTime from = LocalDate.parse(strFrom, FORMATTER).atStartOfDay();
        LocalDateTime to = LocalDate.parse(strTo, FORMATTER).atStartOfDay().plusDays(1);
        return pembayaranDao.daftarPembayaranByWaktuPembayaran(from, to, start, rows);
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
