-- UNIVERSITE

-- UNIVERSITE
INSERT INTO universite (nom, acronyme, creation, presidence) VALUES ('Université de Montpellier', 'UM', 2015, 'P. Augé');
INSERT INTO universite (nom, acronyme, creation, presidence) VALUES ('Université Paul Valéry', 'UM3', 1970, 'A. Fraïsse');
-- CAMPUS

INSERT INTO campus (nomC, ville, fk_universite, latitude, longitude) VALUES ('Triolet', 'Montpellier', 'Université de Montpellier', 43.6320, 3.8620);
INSERT INTO campus (nomC, ville, fk_universite, latitude, longitude) VALUES ('St Priest', 'Montpellier', 'Université de Montpellier', 43.6360, 3.8400);
INSERT INTO campus (nomC, ville, fk_universite, latitude, longitude) VALUES ('Pharmacie', 'Montpellier', 'Université de Montpellier', 43.6340, 3.8580);
INSERT INTO campus (nomC, ville, fk_universite, latitude, longitude) VALUES ('Richter', 'Montpellier', 'Université de Montpellier', 43.6050, 3.8900);
INSERT INTO campus (nomC, ville, fk_universite, latitude, longitude) VALUES ('Route de Mende', 'Montpellier', 'Université Paul Valéry', 43.6322, 3.8692);
INSERT INTO campus (nomC, ville, fk_universite, latitude, longitude) VALUES ('Carémeau', 'Nîmes', 'Université de Montpellier', 43.8212688, 4.3201956);

-- BATIMENT UM

INSERT INTO batiment (codeb, anneec, campus) VALUES ('triolet_b36',2019,'Triolet');
INSERT INTO batiment (codeb, anneec, campus) VALUES ('triolet_b16',1966,'Triolet');
INSERT INTO batiment (codeb, anneec, campus) VALUES ('triolet_b05',1964,'Triolet');
INSERT INTO batiment (codeb, anneec, campus) VALUES ('stPriest_b02',1982,'St Priest');

-- BATIMENT UPV

INSERT INTO batiment (codeb, anneec, campus) VALUES
                                                 ('UPV_A', 1966, 'Route de Mende'),
                                                 ('UPV_H', 1966, 'Route de Mende'),
                                                 ('UPV_J', 1966, 'Route de Mende'),
                                                 ('UPV_S', 1966, 'Route de Mende');

-- BATIMENT PHARMACIE

INSERT INTO batiment (codeb, anneec, campus) VALUES
                                                 ('PHARMA_A', 1980, 'Pharmacie'),
                                                 ('PHARMA_B', 1980, 'Pharmacie'),
                                                 ('PHARMA_C', 1980, 'Pharmacie'),
                                                 ('PHARMA_D', 1980, 'Pharmacie'),
                                                 ('PHARMA_E', 1980, 'Pharmacie'),
                                                 ('PHARMA_G', 1980, 'Pharmacie'),
                                                 ('PHARMA_I', 1980, 'Pharmacie'),
                                                 ('PHARMA_J', 1980, 'Pharmacie'),
                                                 ('PHARMA_BU', 1980, 'Pharmacie');

-- SALLE UM

INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('A36.03',120,'amphi','oui','rdc','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('A36.02',120,'amphi','oui','rdc','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('A36.01',120,'amphi','oui','rdc','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD36.202',40,'numerique','oui','2','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD36.203',40,'numerique','oui','2','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD36.204',40,'numerique','oui','2','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('SC36.04',80,'sc','oui','1','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD36.101',40,'td','oui','1','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD36.302',40,'td','oui','3','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD36.402',40,'td','oui','4','triolet_b36');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('SC16.03',120,'amphi','oui','rdc','triolet_b16');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD16.02',18,'td','oui','rdc','triolet_b16');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TPDeptInfo',40,'numerique','oui','rdc','triolet_b16');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TPBio',40,'tp','oui','rdc','triolet_b16');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('SC16.05',48,'sc','oui','rdc','triolet_b16');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('A5.02',275,'amphi','oui','1','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.125',20,'numerique','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.126',31,'numerique','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.210',40,'numerique','oui','1','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.201',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.202',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.203',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.204',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.205',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.206',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.207',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.208',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('TD5.209',40,'td','oui','rdc','triolet_b05');
INSERT INTO salle (nums, capacite, types, acces, etage, batiment) VALUES ('A_JJMoreau',114,'amphi','oui','1','stPriest_b02');

-- SALLE UPV

INSERT INTO salle (nums, acces, capacite, etage, types, batiment) VALUES
('Amphi 1', 'oui', 250, 'RDC', 'amphi', 'UPV_A'),
('Amphi 2', 'oui', 250, 'RDC', 'amphi', 'UPV_A'),
('Amphi 3', 'oui', 250, 'RDC', 'amphi', 'UPV_A'),
('Amphi 4', 'oui', 180, 'RDC', 'amphi', 'UPV_H'),
('Amphi 5', 'oui', 350, '1', 'amphi', 'UPV_J'),
('Amphi 6', 'oui', 350, '1', 'amphi', 'UPV_J'),
('Amphi 7', 'oui', 350, '1', 'amphi', 'UPV_J'),
('BUG', 'oui', 40, '1', 'td', 'UPV_S'),
('BUs1', 'oui', 35, '1', 'td', 'UPV_S'),
('BUs2', 'oui', 35, '1', 'td', 'UPV_S');

-- SALLE PHARMACIE

INSERT INTO salle (nums, acces, capacite, etage, types, batiment) VALUES
                                                                      ('Amphi A', 'oui', 150, 'RDC', 'amphi', 'PHARMA_A'),
                                                                      ('Amphi C', 'oui', 100, 'RDC', 'amphi', 'PHARMA_A'),
                                                                      ('Amphi D', 'oui', 100, 'RDC', 'amphi', 'PHARMA_A'),
                                                                      ('Amphi B', 'oui', 200, '1', 'amphi', 'PHARMA_B'), -- Noté 1er étage sur le plan
                                                                      ('Amphi J', 'oui', 250, 'RDC', 'amphi', 'PHARMA_J');

INSERT INTO salle (nums, acces, capacite, etage, types, batiment) VALUES
                                                                      ('TP Planchon', 'oui', 30, 'RDC', 'tp', 'PHARMA_D'),
                                                                      ('TP Hollande', 'oui', 30, 'RDC', 'tp', 'PHARMA_D'),
                                                                      ('G-0-TP 1', 'oui', 25, 'RDC', 'tp', 'PHARMA_G'),
                                                                      ('G-0-TP 2', 'oui', 25, 'RDC', 'tp', 'PHARMA_G'),
                                                                      ('G-0-TP Galénique', 'oui', 40, 'RDC', 'tp', 'PHARMA_G');

INSERT INTO salle (nums, acces, capacite, etage, types, batiment) VALUES
                                                                      ('G-0-Info 1', 'oui', 20, 'RDC', 'numerique', 'PHARMA_G'),
                                                                      ('G-1-Info 2', 'oui', 20, '1', 'numerique', 'PHARMA_G'),
                                                                      ('I-2-Info 1', 'oui', 25, '2', 'numerique', 'PHARMA_I'),
                                                                      ('I-2-Info 2', 'oui', 25, '2', 'numerique', 'PHARMA_I'),
                                                                      ('BU-0-Info 1', 'oui', 15, 'RDC', 'numerique', 'PHARMA_BU');

INSERT INTO salle (nums, acces, capacite, etage, types, batiment) VALUES
                                                                      ('Gal-0-01', 'oui', 35, 'RDC', 'td', 'PHARMA_D'),
                                                                      ('Gal-0-02', 'oui', 35, 'RDC', 'td', 'PHARMA_D'),
                                                                      ('Gal-0-03', 'oui', 35, 'RDC', 'td', 'PHARMA_D'),
                                                                      ('I-1-01', 'oui', 30, '1', 'td', 'PHARMA_I'),
                                                                      ('I-1-02', 'oui', 30, '1', 'td', 'PHARMA_I'),
                                                                      ('I-3-12', 'oui', 30, '3', 'td', 'PHARMA_I'),
                                                                      ('C-1-01', 'non', 40, '1', 'td', 'PHARMA_C');

INSERT INTO salle (nums, acces, capacite, etage, types, batiment) VALUES
                                                                      ('Salle des Actes', 'non', 50, '1', 'sc', 'PHARMA_A'),
                                                                      ('Salle du Conseil', 'non', 50, '1', 'sc', 'PHARMA_A'),
                                                                      ('Pharmacie Expérimentale', 'oui', 20, 'RDC', 'tp', 'PHARMA_D');

-- COMPOSANTE
INSERT INTO composante (acronyme, nom, responsable) VALUES ('FDS','Faculte des Sciences','JM. Marin');
INSERT INTO composante (acronyme, nom, responsable) VALUES ('IAE','Ecole Universitaire de Management','E Houze');
INSERT INTO composante (acronyme, nom, responsable) VALUES ('Polytech','Polytech Montpellier','L. Torres');

INSERT INTO composante (acronyme, nom, responsable) VALUES
                                                        ('UFR 1', 'Lettres, arts, philosophie, psychanalyse', 'Corinne SAMINADAYAR-PERRIN'),
                                                        ('UFR 2', 'Langues et cultures étrangères et régionales', 'Claire Omhovere'),
                                                        ('UFR 3', 'Sciences humaines et de l environnement', 'Eric PERRIN-SAMINADAYAR'),
                                                        ('UFR 4', 'Sciences sociales, des organisations et des institutions', 'Catherine MARTY PEYROUX'),
                                                        ('UFR 5', 'Sciences du sujet et de la société', 'Arielle SYSSAU-VACCARELLA'),
                                                        ('UFR 6', 'Éducation et sciences pour les LLASHS', 'Catherine TROTTIER'),
                                                        ('ITIC', 'Institut des technosciences de l information', 'Lise VERLAET');

-- EXPLOITE
INSERT INTO exploite (team, building) VALUES ('FDS','triolet_b16');
INSERT INTO exploite (team, building) VALUES ('IAE','triolet_b16');
INSERT INTO exploite (team, building) VALUES ('FDS','triolet_b36');
INSERT INTO exploite (team, building) VALUES ('IAE','triolet_b05');

INSERT INTO exploite (team, building) VALUES
                                          ('UFR 1', 'UPV_H'),
                                          ('UFR 4', 'UPV_A'),
                                          ('ITIC', 'UPV_J');

-- USER
INSERT INTO users (username, password, role, fk_universite, fk_campus) VALUES
                                                                           ('albert.camus', '{noop}password123', 'ADMIN', 'Université de Montpellier', 'Pharmacie'),
                                                                           ('alexandre.pouchkine', '{noop}password888', 'ADMIN', 'Université de Montpellier', 'Triolet'),
                                                                           ('franz.kafka', '{noop}password468', 'ADMIN', 'Université Paul Valéry', 'Route de Mende'),
                                                                           ('marcel.proust', '{noop}password456', 'ENSEIGNANT', 'Université Paul Valéry', 'Route de Mende'),
                                                                           ('claude.levi-strauss', '{noop}password111', 'ENSEIGNANT', 'Université Paul Valéry', 'Route de Mende'),
                                                                           ('emile.durkheim', '{noop}password333', 'ENSEIGNANT', 'Université de Montpellier', 'Triolet'),
                                                                           ('marie.curie', '{noop}password222', 'ENSEIGNANT', 'Université de Montpellier', 'Pharmacie'),
                                                                           ('sylvia.plath', '{noop}password789', 'ETUDIANT', 'Université de Montpellier', 'Triolet'),
                                                                           ('jean-paul.sartre','{noop}password246', 'ETUDIANT','Université Paul Valéry', 'Route de Mende'),
                                                                           ('carl.jung','{noop}password666', 'ETUDIANT','Université Paul Valéry', 'Route de Mende'),
                                                                           ('stefan.zweig', '{noop}password444', 'ETUDIANT', 'Université de Montpellier', 'Triolet'),
                                                                           ('erving.goffman', '{noop}password555', 'ETUDIANT', 'Université de Montpellier', 'Triolet'),
                                                                           ('simone.de-beauvoir', '{noop}password777', 'ETUDIANT', 'Université de Montpellier', 'Pharmacie');

COMMIT;