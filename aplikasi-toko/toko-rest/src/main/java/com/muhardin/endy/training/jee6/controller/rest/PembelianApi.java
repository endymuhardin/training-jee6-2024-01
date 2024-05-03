package com.muhardin.endy.training.jee6.controller.rest;

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

import com.muhardin.endy.training.jee6.dao.PembelianDao;
import com.muhardin.endy.training.jee6.entity.Pembelian;
import com.muhardin.endy.training.jee6.entity.PembelianDetail;
import com.muhardin.endy.training.jee6.entity.Produk;

@Path("/api/pembelian")
public class PembelianApi {

    @EJB private PembelianDao pembelianDao;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Pembelian> semuaProduk(@QueryParam("email") String email,
                                            @DefaultValue("0") @QueryParam("start") Integer start, 
                                            @DefaultValue("10")@QueryParam("rows") Integer rows){
        return pembelianDao.cariByEmailPelanggan(email, start, rows);
    }

    @POST @Path("/")
    @Consumes("application/json")
    public void simpan(@Valid Pembelian p){
        pembelianDao.simpan(p);
    }
}
