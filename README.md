# l2s4-projet-2021

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

Une fois cela réalisé supprimer ces premières lignes et remplissez les noms des membres de votre équipe.

# Equipe

- Lampe Thibault
- Mansour Lilia
- Boughanime Youba
- KOURIAT Mohamed
- Fahmi Youness

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1 : Modélisation des personnages

### Atteinte des objectifs

- Nous avons réalisé une première version d'un UML complet incluant la classe personnage, deux classes filles (une pour chaque jeu), ainsi qu'une classe joueur et ses classes filles respectives.

### Difficultés restant à résoudre

- Jusqu'à lors, nous n'avons pas rencontré de problème.

## Livrable 2 : Modélisation du plateau

### Atteinte des objectifs

- Nous avons poursuivi la modélisation UML, les premiers jets sur les classes 'Tuiles' se sont vues modifiées pour faciliter l'utilisation ainsi que pour des potentiels ajouts de fonctionnalités.

### Difficultés restant à résoudre

- À cause de l'ajout tardif de deux nouveaux membres au groupe, l'agencement du travail s'est vu perturbé. Certains membres du groupe sont devenus passifs en attendant les directives des deux membres proactifs.

## Livrable 3 : Modélisation des actions

### Atteinte des objectifs

- Nous avons modélisé une représentation quasi complète des actions utilisables par le joueur. Cette représentation est sous la forme d'une interface 'Actions' liée à plusieurs classes représentant toutes les actions possibles par un joueur. Chacune de ces classes possède leur propre constructeur, ainsi qu'une méthode permettant l'action a effectué.

### Difficultés restant à résoudre

- La modélisation peut poser quelques problèmes, notamment à l'utilisation. Les membres passifs sont devenus fantomatiques.

## Livrable 4 : Modélisation complète

### Atteinte des objectifs

- Ayant travaillé sur une modélisation complète dès le départ, ce livrable était notre but d'origine. Nous avons ajouté une classe 'Jeu' ainsi que deux classes filles représentant les deux jeux du projet.

### Difficultés restant à résoudre

- Terminer l'implémentation des classes.

# Journal de bord

## Semaine 1

- Pour cette première séance, nous avons commencé par faire connaissance. Savoir si certains d'entre nous avaient déjà eu une expérience dans ce genre de projet est primordiale, notamment pour avoir un aperçu de la future organisation des rôles et du travail que chacun pourra fournir.

***

- **Organisation temporaire** :
	- Lampe Thibault (chef de projet)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Lecture et analyse du projet, brainstorming sur les classes à modéliser.
	- *En autonomie* : Représentations UML servant de base pour la création d'un UML plus complet.

## Semaine 2

- Pour cette seconde semaine, nous nous sommes concertés suite à notre modélisation en autonomie. Une représentation UML plus complète est ressortie suite à cette mis en commun.

***

- **Organisation temporaire** :
	- Lampe Thibault (chef de projet)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Regroupement des UML, création d'un UML complet pour le rendu du livrable 1.
	- *En autonomie* : Modifications et ajouts au sein de l'UML principal pour création d'un UML regroupant les classes personnages, joueurs et les classes 'Tuile' et 'Plateau'.

## Semaine 3

- Intégration de deux nouveaux membres au sein de l'équipe, mise en place d'une organisation de travail, mise en commun pour la représentation du plateau et des tuiles.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Mise en commun des UML pour modélisation des classes 'Plateau', 'Tuile' et ses classes filles (Désert, Forêt, Montagne, Plaine, Ocean).
	- *En autonomie* : Début de l'implémentation des classes 'Joueur', 'Personnage', 'Tuile', 'Plateau' ainsi que leurs classes filles.

## Semaine 4

- Correction de l'UML pour la représentation des 'Tuile', et réorganisation du travail du à la passivité de certains membres du groupe.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Modification de l'agencement des classes 'Tuile' pour le livrable 2.
	- *Lampe Thibault* : Rédaction du README, correction de l'UML et implémentation des classes 'Plateau', 'Tuile' et ses classes filles.
	- *KOURIAT Mohamed* : Implémentation de la classe 'Joueur' et ses classes filles, ainsi que la classe 'Personnage' et ses classes filles.
	- *Mansour Lilia* : Brainstorming en groupe réduit pour la modélisation des actions.
	- *Boughanime Youba* : Brainstorming en groupe réduit pour la modélisation des actions.
	- *Fahmi Youness* : Brainstorming en groupe réduit pour la modélisation des actions.

## Semaine 5

- Recherche d'une modélisation pour les actions, modification de l'UML pour l'adapter à notre première version de modélisation des classes 'Action'.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Création d'une première version d'une représentation des classes 'Action'.
	- *Lampe Thibault* : Rédaction du README; poursuite de l'implémentation de la classe 'Plateau', ajout de certaines docstrings oubliées, représentation de l'interface 'Action' et des classes liées à l'interface.
	- *KOURIAT Mohamed* : Poursuite de l'implémentation des classes 'Joueur', 'Personnage' et de leurs classes filles.
	- *Mansour Lilia* : Recherche d'une meilleure représentation pour les classes 'Action'.
	- *Boughanime Youba* : Recherche d'une meilleure représentation pour les classes 'Action'.
	- *Fahmi Youness* : Recherche d'une meilleure représentation pour les classes 'Action'.

## Semaine 6

- Modification de la représentation UML pour les classes et l'interface 'Action'.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Modification de la représentation des classes 'Action' pour le livrable 3.
	- *Lampe Thibault* : Rédaction du README; poursuite de l'implémentation.
	- *KOURIAT Mohamed* : Poursuite de l'implémentation.

## Semaine 7

- Ajout des classes 'Action' à l'UML principal et ajout de certains attributs dans la classe 'Joueur' et retrait de certaines méthodes.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Modification des UML.
	- *Lampe Thibault* : Rédaction du README; recherche pour un affichage graphique (non-implémenté).
	- *KOURIAT Mohamed* : Poursuite de l'implémentation.

## Semaine 8

- Ajout d'une classe 'Jeu' dans la représentation UML.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Modification de l'UML principal pour ajouter les classes de 'Jeu'.
	- *Lampe Thibault* : Rédaction du README; début de l'implémentation des 'Action'.
	- *KOURIAT Mohamed* : Début de l'implémentation des 'Action'.

## Semaine 9

- Rectification de l'UML, et continuité de l'implémentation.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Vérification si l'UML complet correspond au cahier des charges.
	- *Lampe Thibault* : Rédaction du README; poursuite de l'implémentation des 'Action'.
	- *KOURIAT Mohamed* : Poursuite de l'implémentation des 'Action'.

## Semaine 10

- Mise au point des UML, fin du regroupement, et implémentations des dernières classes.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Finitions de l'UML pour le livrable 4.
	- *Lampe Thibault* : Rédaction du README; poursuite de l'implémentation des 'Action'.
	- *KOURIAT Mohamed* : Reprise de l'implémentation des classes 'Joueur' selon les modifications de l'UML.

## Semaine 11

- Restructuration du travail restant. La majorité de la séance s'est déroulée en autonomie.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *En groupe* : Tentative de restructuration du travail.
	- *Lampe Thibault* : Vérification des implémentations de classes, poursuite de l'implémentation de 'Action'.
	- *KOURIAT Mohamed* : Finition des classes 'Joueur'.
	- *Mansour Lilia* : Rédaction du Readme.
	- *Fahmi Youness* : Complétion des classes 'Personnage'.

## Semaine 12

- Autonomie.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *Lampe Thibault* : Début du regroupement des classes, pour l'implémentation de 'Jeu'.
	- *KOURIAT Mohamed* : Poursuite des classes 'Action'.
	- *Mansour Lilia* : Rédaction du Readme.
	- *Fahmi Youness* : Complétion des classes 'Personnage'.

## Semaine 13

- Autonomie.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *Lampe Thibault* : Rédaction du Readme, poursuite de l'implémentation des classes 'Jeu' et des 'Action'.
	- *KOURIAT Mohamed* : Préparation de la présentation pour la soutenance.
	- *Mansour Lilia* : Rédaction du Readme.

## Semaine 13

- Autonomie.

***

- **Organisation** :
	- Lampe Thibault (chef de projet)
	- KOURIAT Mohamed (communication)
	- Mansour Lilia (développeur)
	- Boughanime Youba (développeur)
	- Fahmi Youness (développeur)

***

- **Organisation du travail** :
	- *Lampe Thibault* : Rédaction du Readme, poursuite de l'implémentation des classes 'Jeu' et des 'Action'.
	- *KOURIAT Mohamed* : Continuité de la préparation pour la soutenance.