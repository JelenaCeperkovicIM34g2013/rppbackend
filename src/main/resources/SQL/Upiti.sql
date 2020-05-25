select *
from proizvodjac;

--izlistati proizvode sa id=5
select *
from proizvod 
where id=5;

--izlistati sve proizvode gde je id proizvodjaca=2
select *
from proizvod
where proizvodjac=2;

--izlistati proizvode ciji naziv pocinje slovom m
select * 
from proizvod
where naziv like 'M%';

--izlistati proizvode sa nazivima proizvodjaca
select p.*, pr.naziv
from proizvod p, proizvodjac pr
where pr.id=p.proizvodjac;

--izlistati datume placanja racuna sa stavkama racuna kreirane pre 20.01.2020.
select r.datum, sr.*
from racun r, stavka_racuna sr
where r.id=sr.racun
and r.datum < to_date('20.01.2020','dd.mm.yyyy.');

--izlistati sve stavke racuna gde je naziv proizvoda duks
select sr.*
from stavka_racuna sr, proizvod p
where p.id=sr.racun
and p.naziv like 'Duks';

--izlistati racun i stavke_racuna kreirane 02.07.2019. i prikazati na sledeci nacin 
select r.id as "ID racuna", to_char(r.datum,'dd.mm.yyyy.') as "Datum placanja", r.nacin_placanja as "Placeno", pr.naziv as "Naziv proizvoda", p.naziv as "Naziv proizvodjaca"  
from proizvodjac p, proizvod pr, racun r, stavka_racuna sr
where p.id=pr.proizvodjac
and r.id=sr.racun
and sr.proizvod=p.id
and r.datum = to_date('02.07.2019','dd.mm.yyyy.');