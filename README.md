📌 Projet FizzBuzz API

📝 Description

Ce projet est une API REST qui implémente la logique du jeu FizzBuzz. L'API prend cinq paramètres en entrée et retourne une liste de nombres où :

Les multiples de int1 sont remplacés par str1

Les multiples de int2 sont remplacés par str2

Les multiples de int1 et int2 sont remplacés par str1str2

De plus, un endpoint statistique permet de connaître la requête la plus fréquente.

✅ Fonctionnalités

📌 Endpoint principal : Génère la séquence FizzBuzz avec des valeurs personnalisées.

📊 Endpoint statistique : Retourne les paramètres de la requête la plus utilisée.

⚡ Application prête pour la production : Utilisation de Spring Boot et Docker.

🔄 Stockage temporaire des requêtes : Utilisation d'une structure en mémoire pour les statistiques.

🚀 Prérequis

Java 17

Maven

Docker (si exécution dans un conteneur)

🏗️ Installation et Exécution

1️⃣ Exécution en local (sans Docker)

1️⃣ Cloner le projet :

git clone <URL_DU_REPO>
cd fizzbuzz

2️⃣ Compiler et exécuter l'application :

mvn clean package -DskipTests
java -jar target/fizzbuzz-0.0.1-SNAPSHOT.jar

3️⃣ Tester l'API :

curl "http://localhost:8080/api/fizzbuzz?int1=3&int2=5&limit=15&str1=Fizz&str2=Buzz"

2️⃣ Exécution avec Docker

1️⃣ Construire l'image Docker :

docker build -t fizzbuzz-api .

2️⃣ Lancer le conteneur :

docker run -p 8080:8080 fizzbuzz-api

3️⃣ Tester l'API :

curl "http://localhost:8080/api/fizzbuzz?int1=3&int2=5&limit=15&str1=Fizz&str2=Buzz"

🔗 Endpoints de l'API

📌 1. Génération de la séquence FizzBuzz

GET /api/fizzbuzz

Paramètres :

Paramètre

Type

Description

int1

int

Premier entier pour les multiples remplacés par str1

int2

int

Deuxième entier pour les multiples remplacés par str2

limit

int

Nombre maximal jusqu'où générer la séquence

str1

String

Texte à afficher pour int1

str2

String

Texte à afficher pour int2

Exemple d'appel :

GET http://localhost:8080/api/fizzbuzz?int1=3&int2=5&limit=15&str1=Fizz&str2=Buzz

Réponse attendue :

["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

📊 2. Statistiques des requêtes les plus utilisées

GET /api/statistics

Exemple d'appel :

GET http://localhost:8080/api/statistics

Réponse attendue :

{
"parameters": "3,5,15,Fizz,Buzz",
"hits": 10
}

🛠️ Améliorations Possibles

🔄 Stocker les statistiques dans une base de données plutôt qu'en mémoire.

📈 Ajouter un système de monitoring avec Spring Boot Actuator.

🔍 Ajouter plus de tests unitaires et d'intégration.

📄 Licence

Ce projet est sous licence MIT. Vous êtes libre de le modifier et l'utiliser.