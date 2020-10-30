    create user commune identified by 123456;

grant dba to commune;

create table logi (
    id INTEGER PRIMARY KEY,
    login VARCHAR(10),
    mdp VARCHAR(20)
);

create table personne (
    id INTEGER primary key,
    nom VARCHAR(15),
    prenom varchar(10),
    sexe INTEGER
);

create table mariage (
    id INTEGER PRIMARY KEY,
    idPersonne1 INTEGER CONSTRAINT fk_personne1 REFERENCES personne,
    idPersonne2 INTEGER CONSTRAINT fk_personne2 REFERENCES personne,
    dateMariage DATE,
    nomFamille VARCHAR(10)
);


create sequence SQ_logi;
create sequence SQ_commune;
create sequence SQ_mariage;
create sequence SQ_personne;


insert into logi values (SQ_logi.nextval,'commune1','123456');
insert into logi values (SQ_logi.nextval,'commune2','123456');
insert into logi values (SQ_logi.nextval,'commune3','123456');

insert into commune values(SQ_commune.nextval,'commune1');
insert into commune values(SQ_commune.nextval,'commune2');
insert into commune values(SQ_commune.nextval,'commune3');


insert into personne values (SQ_personne.nextval,'Rakoto','Jean','1');
insert into personne values (SQ_personne.nextval,'Rasolo','Tony','1');
insert into personne values (SQ_personne.nextval,'Razafy','Toky','1');
insert into personne values (SQ_personne.nextval,'Ralay','Hery','1');
insert into personne values (SQ_personne.nextval,'Rasoa','Jeanne','0');
insert into personne values (SQ_personne.nextval,'Rajeanne','Nomena','0');
insert into personne values (SQ_personne.nextval,'Rasolange','Onja','0');
insert into personne values (SQ_personne.nextval,'Rasoa2','Ravaka','0');

commit;