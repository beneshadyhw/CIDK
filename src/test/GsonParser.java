package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import com.google.gson.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GsonParser {
	public static JsonObject parseJson(String json){
		JsonParser parser = new JsonParser();
	    JsonObject jsonObj = parser.parse(json).getAsJsonObject();
		return jsonObj;
	}
	
	public static List<Object> toList(JsonArray json){
	    List<Object> list = new ArrayList<Object>();
	    for (int i=0; i<json.size(); i++){
	    	Object value = json.get(i);
	    	if(value instanceof JsonArray){
	            list.add(toList((JsonArray) value));
	    	}
	        else if(value instanceof JsonObject){
	            list.add(toMap((JsonObject) value));
	        }
	        else{
	            list.add(value);
	        }
	    }
	    return list;
	}
	
	public static Map<String,Object> toMap(String json){
		return GsonParser.toMap(GsonParser.parseJson(json));
	}
	
	public static Map<String, Object> toMap(JsonObject json){
	    Map<String, Object> map = new HashMap<String, Object>();
	    Set<Entry<String, JsonElement>> entrySet = json.entrySet();
	    for (Iterator<Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ){
	    	Entry<String, JsonElement> entry = iter.next();
	    	String key = entry.getKey();
	    	Object value = entry.getValue();
	        if(value instanceof JsonArray)
	            map.put(key, toList((JsonArray) value));
	        else if(value instanceof JsonObject)
	            map.put(key, toMap((JsonObject) value));
	        else
	            map.put(key, value);
	    }
	    return map;
	}
	public  static void main(String[] ags) {
		
		String jsonStr = "{\r\n" + 
				"  \"auth\": {\r\n" + 
				"    \"identity\": {\r\n" + 
				"      \"methods\": [\"password\"],\r\n" + 
				"      \"password\": {\r\n" + 
				"        \"user\": {\r\n" + 
				"          \"name\": \"yonghuming\",\r\n" + 
				"          \"password\": \"mima\",\r\n" + 
				"          \"domain\": {\r\n" + 
				"            \"name\": \"zhanghaoming\"\r\n" + 
				"          }\r\n" + 
				"        }\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"scope\": {\r\n" + 
				"      \"project\": {\r\n" + 
				"        \"id\": \"xiangmuid\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		Gson gson = new Gson();
//				
		Map<String, Object> map = new HashMap<String, Object>();
//		List<String> methodValue = new ArrayList<>(Arrays.asList("password"));
		
//		map.put("method", methodValue);


		jsonStr = jsonStr.replace("yonghuming", "ericyang");
		jsonStr = jsonStr.replace("zhanghaoming", "ericyang");
		jsonStr = jsonStr.replace("xiangmuid", "d0c4a0066e8a4350be92bb1ea5a423e5");
		jsonStr = jsonStr.replace("mima", "hwclouds@123");
		
		map = GsonParser.toMap(jsonStr);
		
//		String son = gson.toJson(map);
		
		System.out.println(map);
	}
}