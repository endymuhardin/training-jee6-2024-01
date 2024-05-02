package com.muhardin.endy.training.jee6.controller.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.muhardin.endy.training.jee6.dao.PelangganDao;
import com.muhardin.endy.training.jee6.entity.Pelanggan;

@Path("/api/pelanggan")
public class PelangganApi {

    @EJB private PelangganDao pelangganDao;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Pelanggan> semuaPelanggan(){
        Integer start = 0;
        Integer rows = 10;
        return pelangganDao.cariPelanggan(start, rows);
    }
}
