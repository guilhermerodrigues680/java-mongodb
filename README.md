# Java e Mongo

### Artigos

[mongodb.github.io/mongo-java-driver/4.1/driver/getting-started/quick-start/](https://mongodb.github.io/mongo-java-driver/4.1/driver/getting-started/quick-start)

[docs.mongodb.com/manual/reference/mongo-shell](https://docs.mongodb.com/manual/reference/mongo-shell/)

### Comandos uteis

```shell script
# Abrir mongodb shell no docker
docker-compose exec mongo mongo
```

````shell script
# Mongo shell
use admin
db.auth('root', 'senha')
show dbs
show collections
help
db.help()
db.collections.find()

````