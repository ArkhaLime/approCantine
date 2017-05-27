# approCantine
Projet JavaEE7-Maven pour gestion de l'approvisionnement d'une cantine.

Fait dans le cadre du cours sur JavaEE lors de ma formation en LP Génie Logiciel.

## Prérequis

Avant de lancer l'application sur votre serveur (Tomcat ou autre), pensez à créer la base de données associée. Le script se trouve dans le dossier "approCantine/sql". Pensez également à modifier les identifiants et l'URL pour accédez à la base de données dans la classe "MysqlDbConnection".

## Test de l'application

Connectez-vous avec votre navigateur préféré à l'adresse http://localhost:8080/approCantine/ , si votre serveur tourne en localhost.
Trois identifiant sont disponibles. Chaque utilisateur à accès à la même chose car les rôles ne sont pas implémentés.
- `chef.cuito@cantine.fr` -> `chef`
- `cuisto.1@cantine.fr`   -> `cuisto1`
- `gest.stock@cantine.fr` -> `gest`

Une fois connecté, deux menus déroulants sont disponibles, un pour la gestion des produit et un pour la création et la visualisation des menus.
