package com.muhardin.endy.training.jee6.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.muhardin.endy.training.jee6.entity.Pembelian;
import com.muhardin.endy.training.jee6.entity.PembelianDetail;

@Stateless
public class PembelianDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Pembelian simpan(Pembelian p){

        // set relasi di objek java antara pembelian detail ke pembelian
        for(PembelianDetail pd : p.getDaftarPembelianDetail()) {
            pd.setPembelian(p);
        }

        if(p.getId() == null){
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
        return p;
    }

    @SuppressWarnings("unchecked")
    public List<Pembelian> cariByEmailPelanggan(String email, Integer start, Integer rows){
        List<Pembelian> hasil = entityManager.createQuery("select p from Pembelian p left join fetch p.pembayaran where p.pelanggan.email = :email order by p.waktuTransaksi")
        .setParameter("email", email)
        .setFirstResult(start)
        .setMaxResults(rows)
        .getResultList();

        // inisialisasi proxy
        /*
        for (Pembelian pembelian : hasil) {
            pembelian.getDaftarPembelianDetail().size();
        }
        */
        return hasil;
    }

    @SuppressWarnings("unchecked")
    public List<Pembelian> cariPembelianBelumDibayar(Integer start, Integer rows){
        return entityManager.createQuery("select p from Pembelian p where p.pembayaran is null order by p.waktuTransaksi")
        .setFirstResult(start)
        .setMaxResults(rows)
        .getResultList();
    }

    public void hapus(String id) {
        Pembelian p = entityManager.find(Pembelian.class, id);
        if(p != null) {
            System.out.println("Menghapus pembelian dengan id "+p.getId());
            entityManager.remove(p);
        }
    }

}
