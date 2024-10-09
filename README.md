# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.3/maven-plugin/build-image.html)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.sql.jdbc)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.



##### Projet 1: Plateforme des choix

Le but de ce projet est de créer un site qui permet de proposer et d’enregistrer des choix (comme,
par exemple, doodle). Cependant, dans le modèle utilisé les choix sont exclusifs.

Au centre du système d’information se trouve le concept du projet qui regroupe un nombre de choix
(exclusifs). L’information correspondante se trouve dans les tables projet et choix. Plusieurs utilisateurs se
regroupent en groupes dont la cardinalité est précisée dans le champ tailleGroupe de la table projets. Cette
information est stockée dans la table association. Le regroupement est possible uniquement avec les autres
utilisateurs n’appartenant à aucun groupe dans le cadre du même projet (l’association correspondante
se trouve dans la table groupes). Il est possible d’entrer dans un groupe de 2 façons différentes : soit le
membre d’un groupe demande à un utilisateur (libre) de participer au groupe, soit l’utilisateur demande
à un groupe d’en faire partie. Dans les deux cas, une confirmation de l’autre partie est nécessaire afin que
l’enregistrement ait lieu. L’ information concernant les demandes se trouve dans la table demandes. Pour
les projets dont la taille du groupe est 1, chaque groupe correspond automatiquement à un utilisateur.
Ensuite, le groupe (plus précisément n’importe quel son membre) peut effectuer uniquement un seul
choix par projet (enregistré dans la table affectation). Pendant la durée de validité du projet ce choix
peut être replacé par un autre choix (disponible).
Le responsable crée et gère les projets, ainsi que les choix correspondants. Il peut également visualiser
la liste des choix qui ont été effectués.
Le site doit permettre d’effectuer les opérations suivantes :

**- Pour les administrateurs :**<br>
 - Gestion des projets : liste, ajout, modification, suppression.<br><br>

 - Gestion des choix pour chaque projet : liste, ajout, modification, suppression.<br><br>

 -  Gestion des affectations au projet : liste, ajout, modification, suppression.<br><br>

**- Pour les utilisateurs :**<br>
 -  Gestion du profil : inscription, modification du mot de passe.<br><br>

 -  Groupes : création, liste, suppression, demande d’association, réponse aux demandes d’association.<br><br>

 -  Choix : effectuer, changer ou supprimer un choix.<br><br>


### Base  de donnée relationnelle 

* user (uid,name,firstname,login,password,role)
* project (pid,title,description,sizeGroup,startDate,endDate)
* choice(cid,name,pid)
* association (gid,uid)
* request (gid,uid,source) : Représente une demande faite par un utilisateur pour rejoindre un groupe.
* group (gid,pid)
* assignment (gid,cid) : Représente l'affectation d'un groupe à un choix.


### Relation entre les entités 

* User ↔ Association ↔ Groupe : Un utilisateur peut appartenir à plusieurs groupes via la table association.

* User ↔ Demande ↔ Groupe : Un utilisateur peut faire des demandes pour plusieurs groupes.

* Projet ↔ Choix : Un projet peut avoir plusieurs choix (relation OneToMany).

* Groupe ↔ Projet : Un projet peut avoir plusieurs groupes.

* Choix ↔ Affectation ↔ Groupe : Un groupe peut être affecté à plusieurs choix, et un choix peut être associé à plusieurs groupes via la table affectation.


### Resumé des relations clés

* OneToMany :<br><br>

  * Un projet peut avoir plusieurs choix (Projet ↔ Choix).<br><br>
  
  * Un projet peut avoir plusieurs groupes (Projet ↔ Groupe).<br><br>
  
  * Un groupe peut avoir plusieurs affectations (Groupe ↔ Affectation).<br><br>
  
  * Un utilisateur peut faire plusieurs demandes (User ↔ Demande).<br><br>

* ManyToOne :<br><br>

  * Un choix est lié à un projet (Choix ↔ Projet).<br><br>
  
  * Un groupe est lié à un projet (Groupe ↔ Projet).
  
  
* ManyToMany via table de jointure :<br><br>
  
  * Les relations entre User et Groupe sont gérées via la table de jointure Association.


## License

MIT

**Free Software, Hell Yeah!**