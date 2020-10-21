package com.globalClasses;

import java.io.FileNotFoundException;
import java.io.InputStream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.bson.Document;
import org.bson.types.ObjectId;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;


public class MongoDBConnection {
	private static MongoClient mClient;
    private static MongoDatabase mDataBase;


    public MongoDBConnection(String env, String db) {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        
        try {
            if(inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            String uriString = prop.getProperty(env + "." + db);
            getMongoClient(uriString);
            mDataBase = getDB(db);
            System.out.println("Connection successful");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Failed to make connection!");
        }
    }

    public void close() {
        try {
            if(mClient != null) {
                mClient.close();
                mClient = null;
            }
        } catch(Exception e) {
            e.getMessage();
        }
    }

    private MongoClient getMongoClient(String uriString) {
        if(mClient == null) {
            mClient = new MongoClient(new MongoClientURI(uriString));
        }
        return mClient;
    }

    private MongoDatabase getDB(String db) {
        return mClient.getDatabase(db);
    }

    public boolean compareAllJsonString(String collection, String object) {

        boolean bool = false;
        List<String> mongoJson = new ArrayList<String>();

        int i = 0;
        MongoCollection<Document> coll = mDataBase.getCollection(collection);
        FindIterable<Document> findIterable = coll.find();

        for (Document document : findIterable) {
            mongoJson.add(document.toJson());
        }

        bool = compareAllJS(mongoJson.toString(),object);

        return bool;
    }

    public boolean compareAllJS(String mongoJson, String object) {

        boolean bool = false;


        JSONArray mongoJs = new JSONArray(mongoJson);

        for (int i=0; mongoJs.length() > i; i++){
            JSONObject jsnObject = mongoJs.getJSONObject(i);
            jsnObject.remove("_id");
            jsnObject.remove("password");

        }

        JSONArray obj = new JSONArray(object);

        for (int i=0; obj.length() > i; i++){
            JSONObject jsnObject = obj.getJSONObject(i);
            jsnObject.remove("id");
            jsnObject.remove("password");

        }

        if(mongoJs.toString().equals(obj.toString())) {
            //System.out.println("Equals");
            bool = true;
        }else {
            //System.out.println("Non equals  =(");
        }

        return bool;
    }
    
    public JSONArray executeQuerySelectID(String collection, String field, String filter) {
		JSONObject json = new JSONObject();
		JSONArray resultJ = new JSONArray();
		MongoCollection<Document> coll = mDataBase.getCollection(collection);
		AggregateIterable<Document> output = coll.aggregate(Arrays.asList(Aggregates.sample(1)));
		try (MongoCursor<Document> cursor = coll.find(Filters.eq(field, new ObjectId(filter))).iterator()) {
			while (cursor.hasNext()) {
				resultJ.put(json = new JSONObject(cursor.next().toJson()));
			}
		}
		return resultJ;
	}
    
    public JSONArray obtainAll(String collection) {
    	JSONObject json = new JSONObject();
		JSONArray resultJ = new JSONArray();
		MongoCollection<Document> coll = mDataBase.getCollection(collection);
		AggregateIterable<Document> output = coll.aggregate(Arrays.asList(Aggregates.sample(1)));
		try (MongoCursor<Document> cursor = coll.find().iterator()) {
			while (cursor.hasNext()) {
				resultJ.put(json = new JSONObject(cursor.next().toJson()));
			}
		}
		return resultJ;
    }
}