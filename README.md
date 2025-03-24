Bien sûr ! Voici un **README** clair et simple pour vous 3, en mode projet étudiant. Il est structuré pour que votre prof comprenne direct ce que vous avez fait, et que ça colle à ce qu'il attend.

---

# 🖥️ **Projet de Contrôle à Distance d'un Ordinateur**
## Réalisé par :
- Amadou Sall GUEYE  
- Zeynabou BA  
- Adja Sira DOUMBIYA

---

## 🔥 **Description du projet**
Ce projet consiste à développer une application client-serveur en Java, permettant **l'exécution de commandes distantes** sur un ordinateur serveur depuis un ordinateur client.  
Le **client** envoie des commandes, et le **serveur** les exécute localement puis retourne le résultat.

L'objectif est de **contrôler à distance** un poste via une connexion réseau TCP/IP tout en garantissant la simplicité d'utilisation et la robustesse.

---

## ⚙️ **Fonctionnalités principales**

✅ Connexion **client-serveur** par socket (Java)  
✅ **Envoi de commandes** depuis le client  
✅ **Exécution locale** des commandes sur le serveur  
✅ **Retour du résultat** ou des erreurs au client  
✅ Gestion des **commandes invalides**  
✅ Support des **commandes sur Windows et Linux**  
✅ Saisie dynamique de l'**adresse IP** du serveur  
✅ Fermeture propre de la connexion avec la commande `exit`

---

## 📂 **Structure des fichiers**

```
/src
  ├── Server.java   # Code du serveur
  └── Client.java   # Code du client
```

---

## 🚀 **Prérequis pour exécuter le projet**
- Java Development Kit (JDK) 8 ou supérieur  
- Deux machines (ou une machine + VM) sur le même réseau  
- (Facultatif) Pare-feu configuré pour autoriser le port 5000 si distant

---

## 🛠️ **Installation et exécution**

### 1. Compiler les programmes
Dans un terminal, placez-vous dans le dossier contenant les fichiers `.java` :  
```bash
javac Server.java
javac Client.java
```

### 2. Lancer le serveur
Sur la machine serveur (ou VM) :  
```bash
java Server
```

### 3. Lancer le client
Sur la machine cliente :  
```bash
java Client
```

- Vous devrez **entrer l'adresse IP** du serveur (ex : `192.168.1.10`)
- Puis, taper des commandes système (exemple : `ls` sous Linux ou `dir` sous Windows)

---

## 📝 **Utilisation**

- Tapez vos commandes dans le **client**.  
  Exemples :  
  - `dir` (Windows)  
  - `ls -l` (Linux/MacOS)  
  - `ipconfig` ou `ifconfig`  
  - `whoami`  
- Pour **quitter proprement**, tapez la commande :  
  ```
  exit
  ```

---

## ✅ **Tests effectués**

| **Test**                    | **Résultat attendu**                  | **Résultat** |
|-----------------------------|---------------------------------------|--------------|
| Connexion client-serveur     | OK, connexion établie                | ✅ OK |
| Exécution commande `dir`     | Liste des fichiers                   | ✅ OK |
| Exécution commande invalide  | Message d'erreur affiché au client   | ✅ OK |
| Longues sorties (`ps aux`)   | Affichage complet sur le client      | ✅ OK |
| Fermeture propre (`exit`)    | Déconnexion sans erreurs             | ✅ OK |

---

## 🛡️ **Sécurité**
- Limitation aux **commandes shell** : uniquement via le terminal système.
- Le serveur **n'exécute rien automatiquement**, il attend les commandes du client.
- Gestion des erreurs d'exécution et des commandes non valides.

---

## 📚 **Auteurs**
- Amadou Sall GUEYE  
- Zeynabou BA  
- Adja Sira DOUMBIYA  

Filière : Master 1 - Génie Logiciel  
Université Cheikh Anta Diop de Dakar (UCAD)  
École Supérieure Polytechnique

---

## 📅 **Date de rendu**  
23 mars 2025

---

## ⚡ **Améliorations futures (perspectives)**
- Interface graphique (GUI) pour rendre le contrôle plus user-friendly  
- Authentification sécurisée des clients  
- Journalisation des commandes et résultats  
- Gestion de multiples clients simultanés avec file d’attente  

---

👉 **Contactez-nous si vous avez besoin de refaire le monde en Java !**

---

Dis-moi si tu veux rajouter un logo UCAD ou une page de garde !
