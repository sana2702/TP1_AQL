# AQL-TP
# TP1 
![img_2.png](img_2.png)
# TP2
Exercice   : Test d’état et test d’interactions
Classe testée : Calculatrice

Ce que j’ai fait :

Créé un mock de Calculatrice.

Stub de la méthode additionner(2, 3) pour qu’elle renvoie 5.

Vérifié :

que la méthode a été appelée avec les bons arguments,

qu’aucune autre interaction n’a eu lieu,

l’état après l'appel (même si la classe n’a pas exposé getState(), j'ai noté ce point).

Type de tests :

Test d’état : Vérifie le résultat retourné.

Test d’interactions : Vérifie si la méthode additionner a été appelée correctement.

Exercice 2 : Mock d’un service externe (API)
Classe testée : UserService

Ce que j’ai fait :

Créé un mock de UtilisateurApi.

Configuré le comportement avec when(...).thenReturn(...).

Vérifié que la méthode creerUtilisateur() a bien été appelée.

Exercice 3 : Scénarios avancés avec des mockups
Scénarios testés :

Exception lors de la création : testé la levée de ServiceException.

Erreur de validation : vérifié qu’en cas d’erreur, la méthode API n’est jamais appelée.

Retour d’un identifiant unique : simulé le retour d’un ID utilisateur et vérifié que l’utilisateur reçoit bien l’ID.

Capture d’arguments : utilisé ArgumentCaptor pour vérifier que les bons arguments sont passés à creerUtilisateur().

Exercice 4 : Jeu du 7 (Mock des dés et banque)
Objectif : Tester un jeu avec des dés et une banque.

Ce que j’ai fait :

Mocké Banque, Joueur, De.

Testé les scénarios :

Joueur insolvable.

Joueur gagne (lancers font 7) → vérifié que la banque crédite.

Joueur perd (pas 7).

La banque devient insolvable et le jeu ferme.
