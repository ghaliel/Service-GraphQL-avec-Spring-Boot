# 🏦 Service GraphQL Banking avec Spring Boot

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen)
![GraphQL](https://img.shields.io/badge/GraphQL-Enabled-e10098)
![H2](https://img.shields.io/badge/Database-H2-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)

Un service bancaire moderne développé avec **Spring Boot** et **GraphQL** permettant la gestion des comptes bancaires et leurs transactions.

## 📋 Table des matières

- [Fonctionnalités](#-fonctionnalités)
- [Technologies utilisées](#-technologies-utilisées)
- [Prérequis](#-prérequis)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Utilisation](#-utilisation)
- [Schéma GraphQL](#-schéma-graphql)
- [Exemples de requêtes](#-exemples-de-requêtes)
- [Captures d'écran](#-captures-décran)
- [Structure du projet](#-structure-du-projet)
- [Auteur](#-auteur)

## ✨ Fonctionnalités

- ✅ Gestion des comptes bancaires (COURANT, EPARGNE)
- ✅ Gestion des transactions (DEPOT, RETRAIT)
- ✅ Calcul automatique du solde
- ✅ Statistiques globales sur les comptes
- ✅ API GraphQL complète
- ✅ Interface de test GraphQL intégrée
- ✅ Base de données H2 en mémoire
- ✅ Données de test pré-chargées

## 🛠 Technologies utilisées

- **Java 17**
- **Spring Boot 3.4.0**
- **Spring Data JPA**
- **Spring GraphQL**
- **H2 Database**
- **Lombok**
- **Maven**

## 📦 Prérequis

- Java 17 ou supérieur
- Maven 3.6+
- Git

## 🚀 Installation

### 1. Cloner le repository

```bash
git clone https://github.com/ghaliel/Service-GraphQL-avec-Spring-Boot.git
cd Service-GraphQL-avec-Spring-Boot
```

### 2. Compiler le projet

```bash
mvn clean install
```

### 3. Lancer l'application

```bash
mvn spring-boot:run
```

L'application sera disponible sur **http://localhost:8082**

## ⚙️ Configuration

Le fichier `application.properties` contient la configuration de l'application :

```properties
# Configuration du serveur
server.port=8082

# Configuration H2
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:banque

# Configuration GraphQL
spring.graphql.graphiql.enabled=true
spring.graphql.path=/graphql
```

## 💻 Utilisation

### Accès aux interfaces

| Interface | URL | Description |
|-----------|-----|-------------|
| **Interface de test GraphQL** | http://localhost:8082/ | Interface personnalisée avec exemples |
| **Console H2** | http://localhost:8082/h2-console | Interface de la base de données |

### Connexion à H2 Console

- **JDBC URL:** `jdbc:h2:mem:banque`
- **Username:** `sa`
- **Password:** *(laisser vide)*

## 📊 Schéma GraphQL

### Types principaux

```graphql
enum TypeCompte {
    COURANT
    EPARGNE
}

type Compte {
    id: ID
    solde: Float
    dateCreation: String
    type: TypeCompte
}

type SoldeStats {
    count: Int
    sum: Float
    average: Float
}
```

### Queries disponibles

```graphql
type Query {
    allComptes: [Compte]
    compteById(id: ID): Compte
    totalSolde: SoldeStats
}
```

### Mutations disponibles

```graphql
type Mutation {
    saveCompte(compte: CompteRequest): Compte
}

input CompteRequest {
    solde: Float
    dateCreation: String
    type: TypeCompte
}
```

## 📝 Exemples de requêtes

### 1. Récupérer tous les comptes

```graphql
query {
  allComptes {
    id
    solde
    dateCreation
    type
  }
}
```

**Réponse exemple:**
```json
{
  "data": {
    "allComptes": [
      {
        "id": "1",
        "solde": 8271.79,
        "dateCreation": "2025-12-01",
        "type": "EPARGNE"
      },
      {
        "id": "2",
        "solde": 3672.76,
        "dateCreation": "2025-12-01",
        "type": "COURANT"
      },
      {
        "id": "3",
        "solde": 422.17,
        "dateCreation": "2025-12-01",
        "type": "EPARGNE"
      }
    ]
  }
}
```

### 2. Récupérer un compte par ID

```graphql
query {
  compteById(id: 1) {
    id
    solde
    dateCreation
    type
  }
}
```

**Réponse exemple:**
```json
{
  "data": {
    "compteById": {
      "id": "1",
      "solde": 8271.79,
      "dateCreation": "2025-12-01",
      "type": "EPARGNE"
    }
  }
}
```

### 3. Obtenir les statistiques globales

```graphql
query {
  totalSolde {
    count
    sum
    average
  }
}
```

**Réponse exemple:**
```json
{
  "data": {
    "totalSolde": {
      "count": 3,
      "sum": 12366.72,
      "average": 4122.24
    }
  }
}
```

### 4. Créer un nouveau compte

```graphql
mutation {
  saveCompte(compte: {
    solde: 2500.0,
    dateCreation: "2024-12-01",
    type: EPARGNE
  }) {
    id
    solde
    type
  }
}
```

**Réponse exemple:**
```json
{
  "data": {
    "saveCompte": {
      "id": "4",
      "solde": 2500.0,
      "type": "EPARGNE"
    }
  }
}
```

## 📸 Captures d'écran

### 1. Statistiques globales - Query `totalSolde`
<img width="1484" height="958" alt="Screenshot 2025-12-01 193454" src="https://github.com/user-attachments/assets/fa89e658-d075-491d-b466-c21faa452427" />
*Affichage du nombre total de comptes, somme et moyenne des soldes*

### 2. Récupération d'un compte par ID
<img width="1477" height="750" alt="Screenshot 2025-12-01 193502" src="https://github.com/user-attachments/assets/3f554144-b882-4dee-b5ba-b9a41da0ff87" />
*Requête pour récupérer un compte spécifique avec son ID*

### 3. Liste de tous les comptes
<img width="1438" height="759" alt="Screenshot 2025-12-01 193507" src="https://github.com/user-attachments/assets/ddfdeb9f-6720-4975-b98a-a229438abeff" />
*Affichage de tous les comptes bancaires enregistrés*

### 4. Création d'un nouveau compte
<img width="1550" height="731" alt="Screenshot 2025-12-01 193721" src="https://github.com/user-attachments/assets/cacc5795-e179-45b1-aeb5-dd8d895aed6b" />
*Mutation pour créer un nouveau compte bancaire*

## 📁 Structure du projet

```
banque-service/
├── src/
│   ├── main/
│   │   ├── java/com/exemple/banqueservice/
│   │   │   ├── Controller/
│   │   │   │   └── CompteControllerGraphQL.java
│   │   │   ├── DTO/
│   │   │   │   └── CompteRequest.java
│   │   │   ├── Entity/
│   │   │   │   ├── Compte.java
│   │   │   │   ├── Transaction.java
│   │   │   │   └── TypeCompte.java
│   │   │   ├── Repository/
│   │   │   │   ├── CompteRepository.java
│   │   │   │   └── TransactionRepository.java
│   │   │   └── BanqueServiceApplication.java
│   │   └── resources/
│   │       ├── graphql/
│   │       │   └── schema.graphqls
│   │       ├── static/
│   │       │   └── index.html
│   │       └── application.properties
│   └── test/
├── screenshots/
│   ├── screenshot1.png
│   ├── screenshot2.png
│   ├── screenshot3.png
│   └── screenshot4.png
├── pom.xml
└── README.md
```

## 🎯 Données de test

Au démarrage, l'application charge automatiquement 3 comptes de test avec des soldes aléatoires :

| Type | Plage de solde |
|------|----------------|
| COURANT | 1000.0 - 5000.0 |
| EPARGNE | 500.0 - 10000.0 |

## 🧪 Tests

Pour exécuter les tests :

```bash
mvn test
```

## 🤝 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :

1. Fork le projet
2. Créer une branche (`git checkout -b feature/AmazingFeature`)
3. Commit vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

## 👤 Auteur

**Ghaliel**

- GitHub: [@ghaliel](https://github.com/ghaliel)

---

⭐ Si ce projet vous a été utile, n'hésitez pas à lui donner une étoile !
