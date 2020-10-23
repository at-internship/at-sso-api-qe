package com.globalClasses;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

public class MongoDBUtils {
	public static boolean compareAllJsonString(String env, String mDataBase, String collection, String json) {
		MongoDBConnection db = new MongoDBConnection(env, mDataBase);
		boolean bool;
		try {
			bool = db.compareAllJsonString(collection, json);
		} catch(Exception var9) {
			var9.printStackTrace();
			bool = false;
		} finally {
			db.close();
		}
		return bool;
	}
	
	public static JSONArray executeMyQueryID(String env, String mDataBase, String collection, String field, String filter) {
		MongoDBConnection db = new MongoDBConnection(env, mDataBase);
		JSONArray querySelect = new JSONArray();
		querySelect = db.executeQuerySelectID(collection, field, filter);
		db.close();
		System.out.println("return result");
		return querySelect;
	}
	
	public static JSONArray showAll(String env, String mDataBase, String collection) {
		MongoDBConnection db = new MongoDBConnection(env, mDataBase);
		JSONArray querySelect = new JSONArray();
		querySelect = db.obtainAll(collection);
		db.close();
		System.out.println("return result");
		return querySelect;
	}

	public static boolean compareEncodedPassword(String env, String mDataBase, String collection, String id, String json) {
		MongoDBConnection db = new MongoDBConnection(env, mDataBase);
		boolean bool;
		try {
			bool = db.compareEncodedPassword(collection, id, json);
		} catch(Exception var9) {
			var9.printStackTrace();
			bool = false;
		} finally {
			db.close();
		}
		return bool;
	}
}

