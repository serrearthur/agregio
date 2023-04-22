# Test technique Agregio

###Stack technique :
* java 17
* springboot 3
* postgres
* gradle
* docker-compose pour la base de donnée

###Lancement des tests
Pour compiler et executer les tests, lancer la commande suivante
```
./gradlew build
```

###Execution en local

Tout d'abord, lancer le conteneur gérant la base de donnée
```
docker-compose -f ./scripts/database/docker-compose.yaml up -d
```

Ensuite, lancer l'application via le wrapper gradle
```
./gradlew bootRun --args='--spring.profiles.active=local'
```