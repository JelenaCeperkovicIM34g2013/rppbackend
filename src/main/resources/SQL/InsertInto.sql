insert into proizvodjac(id, naziv, adresa, kontakt)
values (nextval('proizvodjac_seq'), 'Adidas', 'Milutina Milankovica 11a', '(011) 2854 900');

insert into proizvodjac(id, naziv, adresa, kontakt)
values (nextval('proizvodjac_seq'), 'Nike', 'Milana Stojanovica 15', '(011) 2785 021');

insert into proizvodjac(id, naziv, adresa, kontakt)
values (nextval('proizvodjac_seq'), 'Puma', 'Vladimira Ribnikara 13', '(011) 6789 901');

insert into proizvodjac(id, naziv, adresa, kontakt)
values (nextval('proizvodjac_seq'), 'Hummel', 'Narodnih Heroja 8', '(011) 2156 200');

insert into proizvodjac(id, naziv, adresa, kontakt)
values (nextval('proizvodjac_seq'), 'Esprite', 'Novosadska 102', '(011) 2873 011');

insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Majica-kratak rukav', 1);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Patike', 1);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Duks', 1);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Majica-dug rukav', 2);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Cizme', 2);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Patike', 2);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Majica-kratak rukav', 3);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Patike', 3);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Duks', 3);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Majica-kratak rukav', 4);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Majica-dug rukav', 4);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Cizme', 4);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Majica-kratak rukav', 5);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Patike', 5);
insert into proizvod(id, naziv, proizvodjac)
values(nextval('proizvod_seq'), 'Duks', 5);

insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('02.07.2019.','dd.mm.yyyy'), 'Kes');
insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('11.07.2018.','dd.mm.yyyy'), 'Kartica');
insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('02.08.2018.','dd.mm.yyyy'), 'Kes');
insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('12.07.2019.','dd.mm.yyyy'), 'Kes');
insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('08.09.2019.','dd.mm.yyyy'), 'Kartica');
insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('02.07.2019.','dd.mm.yyyy'), 'Kes');
insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('12.11.2019.','dd.mm.yyyy'), 'Kartica');
insert into racun(id, datum, nacin_placanja)
values(nextval('racun_seq'), to_date('03.03.2019.','dd.mm.yyyy'), 'Kes');

insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 2, 'kom', 10000, 1, 7);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 2, 2, 'kom', 8600, 1, 3);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 1, 'kom', 15000, 2, 9);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 2, 'kom', 7400, 3, 1);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 2, 2, 'kom', 11800, 3, 2);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 3, 'kom', 5200, 4, 3);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 2, 3, 'kom', 10000, 4, 4);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 3, 3, 'kom', 11000, 4, 5);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 1, 'kom', 12200, 5, 8);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 2, 'kom', 13000, 6, 12);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 2, 2, 'kom', 11000, 6, 15);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 2, 'kom', 12000, 7, 11);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 2, 2, 'kom', 10050, 7, 13);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 1, 2, 'kom', 18000, 8, 6);
insert into stavka_racuna(id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
values(nextval('stavka_racuna_seq'), 2, 2, 'kom', 20000, 8, 14);