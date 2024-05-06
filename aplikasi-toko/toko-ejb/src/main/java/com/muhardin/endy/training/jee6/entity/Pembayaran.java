package com.muhardin.endy.training.jee6.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.muhardin.endy.training.jee6.dto.RekapPembayaran;

import lombok.Data;

@Entity @Data
@Table(name = "pembayaran")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedNativeQuery(
    name = "RekapPembayaran",
    query = Pembayaran.SQL_REKAP_PEMBAYARAN,
    resultSetMapping = "RekapPembayaranMapping"
)
@SqlResultSetMapping(
    name = "RekapPembayaranMapping",
    classes = @ConstructorResult(
        targetClass = RekapPembayaran.class,
        columns = {
            @ColumnResult(name = "nama", type = String.class),
            @ColumnResult(name = "waktu_beli", type = LocalDateTime.class),
            @ColumnResult(name = "waktu_bayar", type = LocalDateTime.class)
        }
    )
)
public abstract class Pembayaran {

    public static final String SQL_REKAP_PEMBAYARAN 
            = "select p.nama, beli.waktu_transaksi as waktu_beli, bayar.waktu_transaksi as waktu_bayar " + 
                "from pembelian beli " + 
                "inner join pelanggan p on beli.id_pelanggan = p.id " + 
                "inner join pembayaran bayar on bayar.id_pembelian = beli.id " + 
                "order by beli.waktu_transaksi ";

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "id_pembelian")
    private Pembelian pembelian;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "waktu_transaksi")
    private LocalDateTime waktuTransaksi;
    private BigDecimal nilai;

    @Column(name = "nomor_referensi")
    private String nomorReferensi;
}
