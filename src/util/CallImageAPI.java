package util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import test.GsonParser;

public class CallImageAPI {
	private static final String DEF_CHATSET = "UTF-8";
	
	public static Map<String, String> dupImage(String strUrl, String Token, String imageID, String imageName) throws Exception{
		Map<String, String> responseMessage = new HashMap<String, String>();
		String rs = null;
		BufferedReader reader = null; 
		
		Integer code = null;
		HttpURLConnection conn = null;  
		String jsonStr = "{\r\n" + 
				" \"name\": \"imageName\"\r\n" + 
				"}";
		
		strUrl = strUrl.replace("imageID", imageID);
		jsonStr = jsonStr.replace("imageName", imageName);
		
		try {
			StringBuffer sb = new StringBuffer();

			URL url = new URL(strUrl);
        	conn = (HttpURLConnection) url.openConnection(); 
        	conn.setRequestMethod("POST");
        	conn.setDoOutput(true); 
        	conn.setRequestProperty("Content-Type","application/json");
        	conn.setRequestProperty("X-Auth-Token", Token);
        	conn.setUseCaches(false); 
        	conn.connect();

        	
        	try {
        		//Send Request Body
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());  
                out.writeBytes(jsonStr); 
                
                //Get Response Body
                InputStream is;
                code = conn.getResponseCode();
                if(code < HttpURLConnection.HTTP_BAD_REQUEST) {
              	  is = conn.getInputStream();
                }else {
              	  is = conn.getErrorStream();
                }
                reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));  
                String strRead = null;  
                while ((strRead = reader.readLine()) != null) {  
                    sb.append(strRead);  
                }  
                rs = sb.toString(); 
                responseMessage.put("code", code.toString());
                responseMessage.put("message", rs);
//                System.out.println("Response: \r\n"+rs);
            } catch (IOException err) {  
                err.printStackTrace();
            } 
        	
        	
		}catch(IOException e) {
			e.printStackTrace();
		}finally { 
            if (conn != null) {  
                conn.disconnect();  
            }
		}

		return responseMessage;
	}
	
    public static Map<String, String> getImage(String strUrl, String token, String imageID) throws Exception{
    	Map<String, String> map = new HashMap<String, String>();
    	HttpURLConnection conn = null;  
		String rs = null;
		BufferedReader reader = null; 
		strUrl = strUrl.replace("imageID", imageID);
		try {
			StringBuffer sb = new StringBuffer();
			
			URL url = new URL(strUrl);
        	conn = (HttpURLConnection) url.openConnection(); 
        	conn.setRequestMethod("GET");
        	conn.setRequestProperty("Content-Type","application/json");
        	conn.setRequestProperty("X-Auth-Token", token);
        	conn.setUseCaches(false); 
        	conn.connect();
        	
          InputStream is; 
          Integer code = conn.getResponseCode();
          if(code < HttpURLConnection.HTTP_BAD_REQUEST) {
        	  is = conn.getInputStream();
          }else {
        	  is = conn.getErrorStream();
          }
          reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));  
          String strRead = null;  
          while ((strRead = reader.readLine()) != null) {  
              sb.append(strRead);  
          }  
          rs = sb.toString(); 
          Map<String, Object> jsonMap = GsonParser.toMap(rs);
//          System.out.println(jsonMap.get("name"));
          map.put("code", code.toString());
          map.put("message", rs);
          map.put("name", jsonMap.get("name").toString());
      
		}catch(IOException e) {
			e.printStackTrace();
		}finally { 
            if (conn != null) {  
                conn.disconnect();  
            }
		}
    	return map;
    }
}
