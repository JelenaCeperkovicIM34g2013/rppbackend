DROP TABLE IF EXISTS proizvod CASCADE;
DROP TABLE IF EXISTS proizvodjac CASCADE;
DROP TABLE IF EXISTS racun CASCADE;
DROP TABLE IF EXISTS stavka_racuna CASCADE;

DROP SEQUENCE IF EXISTS proizvod_seq;
DROP SEQUENCE IF EXISTS proizvodjac_seq;
DROP SEQUENCE IF EXISTS racun_seq;
DROP SEQUENCE IF EXISTS stavka_racuna_seq;

create table proizvodjac(
id integer not null,
naziv varchar(50) not null,
adresa varchar(200) not null,
kontakt varchar(100) not null); 

create table proizvod(
id integer not null,
naziv varchar(50) not null,
proizvodjac integer not null);

create table stavka_racuna(
id integer not null,
redni_broj integer not null,
kolicina numeric not null,
jedinica_mere varchar(50),
cena numeric not null,
racun integer not null,
proizvod integer not null);

create table racun(
id integer not null,
datum date not null,
nacin_placanja varchar(200) not null);

alter table proizvodjac add constraint pk_proizvodjac primary key(id);
alter table proizvod add constraint pk_proizvod primary key(id);
alter table racun add constraint pk_racun primary key(id);
alter table stavka_racuna add constraint pk_stavka_racuna primary key(id);

alter table proizvod add constraint fk_proizvod_proizvodjac foreign key(proizvodjac) references proizvodjac(id);
alter table stavka_racuna add constraint fk_stavka_racuna_proizvod foreign key(proizvod) references proizvod(id);
alter table stavka_racuna add constraint fk_stavka_racuna_racun foreign key(racun) references racun(id);

create index idpk_proizvodjac on proizvodjac(id);
create index idpk_proizvod on proizvod(id);
create index idpk_racun on racun(id);
create index idpk_stavka_racuna on stavka_racuna(id);

create index idfk_proizvod_proizvodjac on proizvod(proizvodjac);
create index idfk_stavka_racuna_proizvod on stavka_racuna(proizvod);
create index idfk_stavka_racuna_racun on stavka_racuna(racun);

CREATE SEQUENCE proizvod_seq
INCREMENT 1;
CREATE SEQUENCE proizvodjac_seq
INCREMENT 1;
CREATE SEQUENCE racun_seq
INCREMENT 1;
CREATE SEQUENCE stavka_racuna_seq
INCREMENT 1;
