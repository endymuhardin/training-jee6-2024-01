package com.muhardin.endy.training.jee6.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.muhardin.endy.training.jee6.entity.Produk;

@Stateless
public class ProdukDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Produk simpan(Produk p){
        if(p.getId() == null){
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        return p;
    }

    @SuppressWarnings("unchecked")
    public List<Produk> cariProduk(Integer start, Integer rows) {
        return entityManager.createQuery("select p from Produk p order by p.kode")
        .setFirstResult(start)
        .setMaxResults(rows)
        .getResultList();
    }
}
