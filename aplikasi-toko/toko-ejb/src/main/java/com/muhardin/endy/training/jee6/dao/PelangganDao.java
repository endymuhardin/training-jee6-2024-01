package com.muhardin.endy.training.jee6.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.muhardin.endy.training.jee6.entity.Pelanggan;

@Stateless
public class PelangganDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Pelanggan save(Pelanggan p){
        if(p.getId() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        return p;
    }

    public void delete(Pelanggan p){
        entityManager.remove(entityManager.contains(p) ? p : entityManager.merge(p));
    }

    public Pelanggan findById(String id){
        return entityManager.find(Pelanggan.class, id);
    }

    public List<Pelanggan> cariPelanggan(Integer start, Integer rows){
        return entityManager.createQuery("select p from Pelanggan p order by p.nama")
        .setFirstResult(start)
        .setMaxResults(rows)
        .getResultList();
    }

    public List<Pelanggan> cariPelangganByNama(String nama, Integer start, Integer rows){
        return entityManager.createQuery("select p from Pelanggan p where p.nama like :nama order by p.nama")
        .setParameter("nama", nama)
        .setFirstResult(start)
        .setMaxResults(rows)
        .getResultList();
    }

    public Pelanggan cariByEmail(String email){
        return (Pelanggan) entityManager.createQuery("select p from Pelanggan p where p.email = :email order by p.nama")
        .setParameter("email", email)
        .getSingleResult();
    }
}
