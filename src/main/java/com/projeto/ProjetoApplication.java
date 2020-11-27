package com.projeto;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.client.*;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class ProjetoApplication {

	private static Logger log = LoggerFactory.getLogger(ProjetoApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(ProjetoApplication.class, args);
		log.info("OK! args: {}", args);

		MongoClient mongoClient = MongoClients.create("mongodb://root:senha@localhost:27017/?authSource=admin");
		MongoDatabase database = mongoClient.getDatabase("mydb");
		MongoCollection<Document> collection = database.getCollection("test");
		Document doc = new Document("name", "MongoDB")
				.append("type", "database")
				.append("count", 1)
				.append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
				.append("info", new Document("x", 203).append("y", 102));
		collection.insertOne(doc);

		List<Document> documents = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			documents.add(new Document("i", i));
		}
		collection.insertMany(documents);

		log.info("Documentos na collection: {}", collection.countDocuments());

		MongoCursor<Document> cursor = collection.find().iterator();
		while (cursor.hasNext()) {
			log.info(cursor.next().toJson());
		}

	}

}
