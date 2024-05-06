package com.muhardin.endy.training.jee6.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.muhardin.endy.training.jee6.dto.RekapPembayaran;
import com.muhardin.endy.training.jee6.entity.Pembayaran;
import com.muhardin.endy.training.jee6.entity.Pembelian;

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

    public Pembayaran cariByPembelian(Pembelian p) {
        return (Pembayaran) entityManager.createQuery("select pb from Pembayaran pb where pb.pembelian = :pembelian")
        .setParameter("pembelian", p)
        .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<RekapPembayaran> rekapPembayaran(){
        return entityManager.createNamedQuery("RekapPembayaran")
        .getResultList();
    }


}
