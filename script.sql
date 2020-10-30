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
CREATE TABLE naissance(
    id INTEGER PRIMARY KEY,
    nom VARCHAR(25),
    prenom VARCHAR(10),
    sexe VARCHAR(1), 
    idP INTEGER,
    idM INTEGER,
    lieu VARCHAR(10),
    dateNaissance VARCHAR(10),
    FOREIGN KEY (idP) REFERENCES personne(id),
    FOREIGN KEY (idM) REFERENCES personne(id)
);
CREATE VIEW personne2 AS SELECT personne.id,personne.nom,personne.prenom FROM personne;
CREATE VIEW all_naissance AS
SELECT naissance.id, naissance.nom, naissance.prenom, naissance.sexe,
personne.id as idP, personne.nom as nomP, personne.prenom as prenomP, personne2.id as idM, personne2.nom as nomM ,personne2.prenom as prenomM, naissance.lieu, naissance.dateNaissance
FROM naissance
JOIN personne  ON naissance.idP = personne.id
JOIN personne2  ON naissance.idM = personne2.id;

INSERT INTO personne VALUES(1,'Randria','Wendy','F');
INSERT INTO personne VALUES(2,'Rakoto','Alice','F');
INSERT INTO personne VALUES(3,'Rasoa','Annie','F');
INSERT INTO personne VALUES(4,'Randria','Josephine','F');
INSERT INTO personne VALUES(5,'Rakoto','Georgette','F');
INSERT INTO personne VALUES(6,'Rasoa','Caroline','F');
INSERT INTO personne VALUES(7,'Randria','Idealy','F');
INSERT INTO personne VALUES(8,'Rakoto','Carina','F');
INSERT INTO personne VALUES(9,'Rasoa','Celina','F');
INSERT INTO personne VALUES(10,'Randria','Jenny','F');
INSERT INTO personne VALUES(11,'Rakoto','Karl','M');
INSERT INTO personne VALUES(12,'Rasoa','Louis','M');
INSERT INTO personne VALUES(13,'Randria','Georges','M');
INSERT INTO personne VALUES(14,'Rakoto','Duval','M');
INSERT INTO personne VALUES(15,'Rasoa','Andy','M');
INSERT INTO personne VALUES(16,'Randria','Henri','M');
INSERT INTO personne VALUES(17,'Rakoto','Claude','M');
INSERT INTO personne VALUES(18,'Rasoa','Aurelien','M');
INSERT INTO personne VALUES(19,'Randria','Jules','M');
INSERT INTO personne VALUES(20,'Rakoto','Aro','M');

INSERT INTO Naissance VALUES(1,'Rakotobe','Antonio','M',10,1,'Ambanidia','10-01-2002');
INSERT INTO Naissance VALUES(2,'Rakotokely','Andry','M' ,11,2,'Ambanidia','10-02-2002');
INSERT INTO Naissance VALUES(3,'Randriandria','Lucie','F',12,3,'Ambanidia','10-03-2002');
INSERT INTO Naissance VALUES(4,'Rasoabe','Sarah','F',13,5,'Ambanidia','10-04-2002');
INSERT INTO Naissance VALUES(5,'Rasoakely','M','Johan',14,6,'Ambanidia','10-05-2002');
INSERT INTO Naissance VALUES(6,'Randriabe','Jerry','M',15,7,'Ambanidia','10-06-2002');
INSERT INTO Naissance VALUES(7,'Randriakely','Cady','F',16,8,'Ambanidia','10-07-2002');
INSERT INTO Naissance VALUES(8,'Coco','Claire','F',17,9,'Ambanidia','10-09-2002');
INSERT INTO Naissance VALUES(9,'Andria','Charles','M',18,10,'Ambanidia','10-10-2002');
INSERT INTO Naissance VALUES(10,'Andriabe','Junior','M',19,1,'Ambanidia','10-11-2002');

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
