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

import com.muhardin.endy.training.jee6.dao.ProdukDao;
import com.muhardin.endy.training.jee6.entity.Produk;

@Path("/api/produk")
public class ProdukApi {
    @EJB private ProdukDao produkDao;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Produk> semuaProduk(@DefaultValue("0") @QueryParam("start") Integer start, 
                                            @DefaultValue("10")@QueryParam("rows") Integer rows){
        return produkDao.cariProduk(start, rows);
    }

    @POST @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Produk simpan(@Valid Produk p){
        return produkDao.simpan(p);
    }
}
