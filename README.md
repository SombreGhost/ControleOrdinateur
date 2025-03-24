# ControleOrdinateur

✅ README.md — Projet Client/Serveur Java
Nom du projet : Contrôle distant d’un ordinateur (RCE - Remote Command Execution)
Auteur(s) : Amadou Sall GUEYE, Zeynabou BA, Adja Sira DOUMBIYA
Technologie : Java Standard Edition (Java SE)

📚 Description du projet
Ce projet implémente une application client/serveur permettant à un client distant d’envoyer des commandes à un serveur et d’en recevoir le résultat.
➡️ Le serveur écoute les connexions des clients et exécute les commandes système qu’il reçoit.
➡️ Le client se connecte au serveur, envoie une commande et reçoit le résultat de l'exécution.

C'est une solution de contrôle distant simplifiée, réalisée dans le cadre d'un projet universitaire en Programmation Orientée Objet (POO).

⚙️ Fonctionnalités
Connexion TCP/IP entre client et serveur.

Exécution de commandes systèmes distantes.

Affichage du résultat ou d’un message d’erreur.

Déconnexion propre du client.

Possibilité de gérer plusieurs clients connectés en parallèle (multi-threading sur le serveur).

🛠️ Technologies utilisées
Java SE 8+

Sockets TCP

Multi-threading

ProcessBuilder pour l’exécution de commandes système

Communication via flux de caractères (BufferedReader, PrintWriter)

🖥️ Architecture
lua
Copy
Edit
+-------------+          TCP/IP         +---------------+
|   Client    |  <------------------->  |    Serveur    |
| Interface   |                        | Écoute socket  |
| Commande    |                        | Exécution CMD  |
| Résultat    |                        | Renvoi résultat|
+-------------+                        +---------------+
🚀 Installation & Lancement
1. Prérequis
JDK 8 ou supérieur

Deux machines OU une machine locale avec deux terminaux (client + serveur)

2. Lancement du serveur
Compile le serveur :

bash
Copy
Edit
javac Server.java
Lance le serveur (par défaut sur le port 5000) :

bash
Copy
Edit
java Server
3. Lancement du client
Compile le client :

bash
Copy
Edit
javac Client.java
Lance le client et renseigne l'IP du serveur :

bash
Copy
Edit
java Client
➡️ Exemple : tape 127.0.0.1 pour un test local, ou l'adresse IP d'une VM sur le réseau.

✅ Comment utiliser
Le client demande une commande à exécuter.
➤ Exemple : dir (Windows) ou ls (Linux).

Le serveur exécute cette commande et retourne le résultat.

Tape exit pour fermer la connexion.

🔒 Remarques sur la sécurité
Ce projet est à but pédagogique. En conditions réelles, il faut :

Ajouter de l’authentification (login/mot de passe).

Sécuriser les communications (SSL/TLS).

Limiter les commandes à exécuter.

👨‍💻 Auteurs
Amadou Sall GUEYE

Collaborateurs 

Adja Sira DOUMBIYA
Zeynabou BA
