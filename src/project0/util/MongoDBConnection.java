package project0.util;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	
	private MongoDBConnection() {
		
	}
	
	public static MongoDatabase getDatabase() {
		if (mongoClient == null) {
			String uri = "mongodb+srv://empresaManager:abc123.@cluster0.dbbz6kv.mongodb.net/?appName=Cluster0";

			// CodecRegistry for POJOs
			CodecRegistry pojoCodedRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
					fromProviders(PojoCodecProvider.builder().automatic(true).build()));

			// settings del MongodbClient
			MongoClientSettings settings = MongoClientSettings.builder()
					.applyConnectionString(new ConnectionString(uri)).codecRegistry(pojoCodedRegistry).build();

			mongoClient = MongoClients.create(settings);
			database = mongoClient.getDatabase("empresa");
		}
			return database;
		
	}
}