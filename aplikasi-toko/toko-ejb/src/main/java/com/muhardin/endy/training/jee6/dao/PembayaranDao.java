package com.muhardin.endy.training.jee6.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.muhardin.endy.training.jee6.entity.Pembayaran;

@Stateless
public class PembayaranDao {
    @PersistenceContext private EntityManager entityManager;

    public Pembayaran simpan(Pembayaran p) {
        if(p.getId() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        return p;
    }
}
