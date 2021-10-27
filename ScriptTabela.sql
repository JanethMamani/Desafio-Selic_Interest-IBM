CREATE database tabelataxas;

use tabelataxas;

CREATE TABLE taxas(
Id int(11) NOT NULL AUTO_INCREMENT,
Data datetime NOT NULL,
Valor double NOT NULL,
  PRIMARY KEY (Id)
  );