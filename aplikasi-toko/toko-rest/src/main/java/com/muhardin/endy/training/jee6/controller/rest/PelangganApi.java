package com.muhardin.endy.training.jee6.controller.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.muhardin.endy.training.jee6.dao.PelangganDao;
import com.muhardin.endy.training.jee6.entity.Pelanggan;

@Path("/api/pelanggan")
public class PelangganApi {

    @EJB private PelangganDao pelangganDao;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Pelanggan> semuaPelanggan(@DefaultValue("0") @QueryParam("start") Integer start, 
                                            @DefaultValue("10")@QueryParam("rows") Integer rows){
        return pelangganDao.cariPelanggan(start, rows);
    }
}
