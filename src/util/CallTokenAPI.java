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

public class CallTokenAPI {
	private static final String DEF_CHATSET = "UTF-8";
    private static final int DEF_CONN_TIMEOUT = 60000;  
    private static final int DEF_READ_TIMEOUT = 60000;  
    
    public static Map<String, String> getToken(String strUrl, String username, String accountName, String projectID, String pw) throws Exception{
    	Map<String, String> responseMessage = new HashMap<String, String>();
    	HttpURLConnection conn = null;  
        String token = null;
        String rs = null;
        Integer code = null;
        BufferedReader reader = null;
        
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
        
        jsonStr = jsonStr.replace("yonghuming", username);
		jsonStr = jsonStr.replace("zhanghaoming", accountName);
		jsonStr = jsonStr.replace("xiangmuid", projectID);
		jsonStr = jsonStr.replace("mima", pw);
		
        try {
        	StringBuffer sb = new StringBuffer();
        	
        	URL url = new URL(strUrl);
        	conn = (HttpURLConnection) url.openConnection(); 
        	conn.setRequestMethod("POST");
        	conn.setDoOutput(true); 
        	conn.setRequestProperty("Content-Type","application/json");
        	conn.setUseCaches(false);  
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);  
            conn.setReadTimeout(DEF_READ_TIMEOUT);  
            conn.setInstanceFollowRedirects(false);
            conn.connect();

            try {
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());  
                out.writeBytes(jsonStr);  
                InputStream is;
                code = conn.getResponseCode();
                if(code < HttpURLConnection.HTTP_BAD_REQUEST) {
              	  is = conn.getInputStream();
              	  token = conn.getHeaderField("X-Subject-Token").trim();
                }else {
              	  is = conn.getErrorStream();
                }
                reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));  
                String strRead = null;  
                while ((strRead = reader.readLine()) != null) {  
                    sb.append(strRead);  
                }  
                rs = sb.toString(); 
                code = conn.getResponseCode();
                
                responseMessage.put("message", rs);
                responseMessage.put("code", code.toString());
                responseMessage.put("token", token);
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
}
