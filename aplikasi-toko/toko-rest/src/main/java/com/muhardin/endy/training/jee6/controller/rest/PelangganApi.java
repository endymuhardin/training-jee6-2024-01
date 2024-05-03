package com.muhardin.endy.training.jee6.controller.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    @POST @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Pelanggan simpan(@Valid Pelanggan p){
        return pelangganDao.save(p);
    }

    @PUT @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Pelanggan update(@PathParam("id") String id, @Valid Pelanggan px){
        Pelanggan p = pelangganDao.findById(id);
        if(p != null) {
            p.setEmail(px.getEmail());
            p.setNama(px.getNama());
            pelangganDao.save(p);
        }
        return p;
    }

    @DELETE @Path("/{id}")
    public void delete(@PathParam("id") String id){
        Pelanggan p = pelangganDao.findById(id);
        if(p != null) {
            pelangganDao.delete(p);
        }
    }
}
