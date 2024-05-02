create table produk (
    id varchar(36),
    kode varchar(50) not null,
    nama varchar(100) not null,
    harga decimal (19,2) not null,
    primary key (id)
);

create table pelanggan (
    id varchar(36),
    nama varchar(255) not null,
    email varchar(100) not null,
    primary key (id),
    unique(email)
);

create table pembelian (
    id varchar(36),
    id_pelanggan varchar(36),
    waktu_transaksi datetime not null,
    primary key (id),
    foreign key (id_pelanggan) references pelanggan(id)
);

create table pembelian_detail (
    id varchar(36),
    id_pembelian varchar(36),
    id_produk varchar(36) not null,
    jumlah integer not null,
    primary key (id),
    foreign key (id_pembelian) references pembelian(id),
    foreign key (id_produk) references produk(id)
);

create table pembayaran (
    id varchar(36),
    id_pembelian varchar(36) not null,
    waktu_transaksi datetime not null,
    primary key (id),
    foreign key (id_pembelian) references pembelian(id)
);

create table pembayaran_virtual_account (
    id varchar(36),
    bank varchar(50) not null,
    nomor_rekening varchar(100) not null,
    primary key (id), 
    foreign key (id) references pembayaran(id)
);

create table pembayaran_gopay (
    id varchar(36),
    nomor_handphone varchar(100) not null,
    primary key (id),
    foreign key (id) references pembayaran(id)
);