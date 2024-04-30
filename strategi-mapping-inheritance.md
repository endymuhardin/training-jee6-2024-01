# Berbagai strategi mapping inheritance #

Studi kasus : class `Pembayaran` memiliki dua subclass yaitu `VirtualAccount` dan `Gopay`

* Class Pembayaran

```java
public class Pembayaran {
    private String id;
    private Pembelian pembelian;
    private LocalDateTime waktuTransaksi;
    private BigDecimal nilai;
    private String nomorReferensi;
}
```

* Virtual Account


```java
public class VirtualAccount extends Pembayaran {
    private String bank;
    private String nomorRekening;
}
```

* Gopay

```java
public class Gopay extends Pembayaran {
    private String nomorHandphone;
}
```

## Strategi 1 : Single Table ##

* Skema database

```sql
create table pembayaran (
    id varchar(36), 
    id_pembelian varchar(36) not null,
    waktu_transaksi datetime not null,
    nilai decimal(19,2) not null,
    referensi varchar(36) not null,
    jenis_pembayaran varchar(20) not null,
    bank varchar(100), 
    nomor_rekening varchar(50), 
    nomor_handphone varchar(50),
    primary key (id),
    foreign key (id_pembelian) references pembelian(id)
);
```

* Query mencari pembayaran VA yang banknya BCA

    * Kode program Java 

       ```java
       List<PembayaranVA> daftarPembayaran = 
        em.query("select p from PembayaranVA where p.bank = ? ", "BCA");
       ```
    
    * SQL yang dihasilkan

        ```sql
        select * from pembayaran where jenis_pembayaran = 'virtual_account' and bank = 'BCA'
        ```
    
* Query mencari pembayaran bulan tertentu

    * Kode program Java 

       ```java
       List<Pembayaran> daftarPembayaranBulanIni = 
        em.query("select p from Pembayaran where p.waktuTransaksi between ? and ?", "2024-04-01", "2024-05-01");
       ```
    
    * SQL yang dihasilkan

        ```sql
        select * from pembayaran where waktu_transaksi between '2024-01-01' and '2024-05-01'
        ```

## Strategi 2 : Tabel per Class ##

* Skema database

```sql
create table pembayaran (
    id varchar(36), 
    id_pembelian varchar(36) not null,
    waktu_transaksi datetime not null,
    nilai decimal(19,2) not null,
    referensi varchar(36) not null,
    bank varchar(100), 
    nomor_rekening varchar(50), 
    nomor_handphone varchar(50),
    primary key (id),
    foreign key (id_pembelian) references pembelian(id)
);

create table virtual_account (
    id varchar(36), 
    bank varchar(100) not null, 
    nomor_rekening varchar(50) not null, 
    primary key (id)
);

create table gopay (
    id varchar(36), 
    nomor_handphone varchar(50) not null, 
    primary key (id)
);
```

* Query mencari pembayaran VA yang banknya BCA

    * Kode program Java 

       ```java
       List<PembayaranVA> daftarPembayaran = 
        em.query("select p from PembayaranVA where p.bank = ? ", "BCA");
       ```
    
    * SQL yang dihasilkan

        ```sql
        select va.*, p.* from virtual_account va where va.bank = 'BCA' 
        inner join pembayaran p on p.id = va.id;
        ```
    
* Query mencari pembayaran bulan tertentu

    * Kode program Java 

       ```java
       List<Pembayaran> daftarPembayaranBulanIni = 
        em.query("select p from Pembayaran where p.waktuTransaksi between ? and ?", "2024-04-01", "2024-05-01");
       ```
    
    * SQL yang dihasilkan

        ```sql
        select * from pembayaran p where p.waktu_transaksi between x and y 
        inner join virtual_account va on p.id = va.id 
        inner join gopay gp on p.id = gp.id
        ```

## Strategi 3 : Tabel per Subclass ##

* Skema database

```sql
create table virtual_account (
    id varchar(36), 
    id_pembelian varchar(36) not null,
    waktu_transaksi datetime not null,
    nilai decimal(19,2) not null,
    referensi varchar(36) not null,
    bank varchar(100), 
    nomor_rekening varchar(50), 
    primary key (id),
    foreign key (id_pembelian) references pembelian(id)
);

create table gopay (
    id varchar(36), 
    id_pembelian varchar(36) not null,
    waktu_transaksi datetime not null,
    nilai decimal(19,2) not null,
    referensi varchar(36) not null,
    nomor_handphone varchar(50),
    primary key (id),
    foreign key (id_pembelian) references pembelian(id)
);
```

* Query mencari pembayaran VA yang banknya BCA

    * Kode program Java 

       ```java
       List<PembayaranVA> daftarPembayaran = 
        em.query("select p from PembayaranVA where p.bank = ? ", "BCA");
       ```
    
    * SQL yang dihasilkan

        ```sql
        select * from virtual_account where bank = 'BCA'
        ```
    
* Query mencari pembayaran bulan tertentu

    * Kode program Java 

       ```java
       List<Pembayaran> daftarPembayaranBulanIni = 
        em.query("select p from Pembayaran where p.waktuTransaksi between ? and ?", "2024-04-01", "2024-05-01");
       ```
    
    * SQL yang dihasilkan

        ```sql
        select * from virtual_account where waktu_transaksi between '2024-01-01' and '2024-05-01';
        select * from gopay where waktu_transaksi between '2024-01-01' and '2024-05-01';
        ```