<h1>PAS A JOUR // EN COURS DE REDACTION </h1>

Ce projet est une API REST développée avec Spring Boot, permettant la gestion des utilisateurs et d'un catalogue d'animaux via des opérations CRUD sécurisées par un système d'authentification JWT.

- Backend : Spring Boot, Maven
- Base de données : PostgreSQL
- Sécurité : JWT (JSON Web Tokens)
 <br>
 
## Authentification

### ![POST](https://img.shields.io/badge/POST-blue) S'inscrire
- Crée un nouvel utilisateur avec les informations fournies.
- **URL** : `/auth/register`
- **Body** :
  ```json
  {
      "name": "caroline",
      "password": "caroline",
      "email": "caroline@mail.com",
      "roles": "ROLE_ADMIN || ROLE_USER"
  }

### ![POST](https://img.shields.io/badge/POST-blue) Generer Token
- Génère un token JWT pour l'utilisateur afin de s'authentifier aux endpoints sécurisés.
- **URL** : `/auth/login`
- **Body** :
  ```json
  {
    "username": "caro@mail.com",
    "password": "caro"
  }
<br>

## Crud Animal

### ![GET](https://img.shields.io/badge/GET-brightgreen) Indexer
- Récupère la liste de tous les animaux.
- **URL** : `/api/animal/all`

 
### ![GET](https://img.shields.io/badge/GET-brightgreen) Afficher
- Récupère les détails d'un animal spécifique par son ID.
- Necessite Bearer Token
- **URL** : `/api/animal/{id}`

### ![POST](https://img.shields.io/badge/POST-blue) Créér
- Crée un nouvel animal avec le nom fourni.
- - Necessite Bearer Token
- **URL** : `/api/animal/{id}`
- **Body** :
  ```json
  {
    "name": "chat"
  }

### ![PUT](https://img.shields.io/badge/PUT-orange) Editer
- Modifie l'animal existant par son ID.
- Necessite Bearer Token
- **URL** : `/api/animal/{id}/edit`
- **Body** :
  ```json
  {
    "name": "castor"
  }

### ![DELETE](https://img.shields.io/badge/DELETE-red) Supprimer
- Supprime un animal spécifique par son ID.
- Necessite Bearer Token
- **URL** : `/api/animal/{id}/delete`

