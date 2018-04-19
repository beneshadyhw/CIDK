package test;

import java.io.*;  
import java.net.HttpURLConnection;  
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class apiTest {
	private static final String DEF_CHATSET = "UTF-8";
    private static final int DEF_CONN_TIMEOUT = 60000;  
    private static final int DEF_READ_TIMEOUT = 60000;  
    
    public static String getToken(String strUrl, String username, String projectID, String pw) throws Exception{
        HttpURLConnection conn = null;  
        String rs = null; 
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
		jsonStr = jsonStr.replace("zhanghaoming", username);
		jsonStr = jsonStr.replace("xiangmuid", projectID);
		jsonStr = jsonStr.replace("mima", pw);
		
        try {
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
            } catch (IOException err) {  
                err.printStackTrace();
            } 
//            
//            Response Body
//            
//            InputStream is = conn.getInputStream();  
//            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));  
//            String strRead = null;  
//            while ((strRead = reader.readLine()) != null) {  
//                sb.append(strRead);  
//            }  
//            rs = sb.toString(); 
            

            rs = conn.getHeaderField("X-Subject-Token");
            
        }catch(IOException e) {
        	e.printStackTrace();
        }finally {
            if (conn != null) {  
                conn.disconnect();  
            }
        }
        
        return rs;
    }

    
    //https://ims.cn-south-1.myhuaweicloud.com/v2/images/d47896ef-19b4-446a-af97-8cb702dd5c83
    
    public static Map<String, String> dupImage(String strUrl, String Token, String imageID, String imageName) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		
    	HttpURLConnection conn = null;  
		String rs = null;
		BufferedReader reader = null;  
		String jsonStr = "{\r\n" + 
				" \"name\": \"imageName\"\r\n" + 
				"}";
		
		strUrl = strUrl.replace("imageID", imageID);
		jsonStr = jsonStr.replace("imageName", imageName);
				
		try {
			StringBuffer sb = new StringBuffer();
			
			URL url = new URL(strUrl);
        	conn = (HttpURLConnection) url.openConnection(); 
        	conn.setRequestMethod("GET");
        	conn.setDoOutput(true); 
        	conn.setRequestProperty("Content-Type","application/json");
        	conn.setRequestProperty("X-Auth-Token", Token);
        	conn.setUseCaches(false); 
        	conn.connect();
        	
//        	try {
//                DataOutputStream out = new DataOutputStream(conn.getOutputStream());  
//                out.writeBytes(jsonStr);  
//            } catch (IOException err) {  
//                err.printStackTrace();
//            }
//request body
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
//          System.out.println(rs);
//          Gson gson = new Gson();
//          Map<String, Object> jsonMap = GsonParser.toMap(rs);

          map.put("code", code.toString());
          map.put("message", rs);
//          map.put("name", (String)jsonMap.get("name"));
        	
          
          
		}catch(IOException e) {
			e.printStackTrace();
		}finally { 
            if (conn != null) {  
                conn.disconnect();  
            }
		}
		return map;
	}
    
    public static Map<String, String> getTokenMap(String strUrl, String username, String projectID, String pw) throws Exception{
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
		jsonStr = jsonStr.replace("zhanghaoming", username);
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
    public  static void main(String[] ags) throws Exception {
    	String token = "MIISjgYJKoZIhvcNAQcCoIISfzCCEnsCAQExDTALBglghkgBZQMEAgEwghDcBgkqhkiG9w0BBwGgghDNBIIQyXsidG9rZW4iOnsiZXhwaXJlc19hdCI6IjIwMTgtMDQtMTJUMDE6Mjc6MTQuMTYxMDAwWiIsIm1ldGhvZHMiOlsicGFzc3dvcmQiXSwiY2F0YWxvZyI6W10sInJvbGVzIjpbeyJuYW1lIjoidGVfYWRtaW4iLCJpZCI6ImUyZDc1NDI5NTQ5MDQ0ZDJiMzEzZmJkZDExNTIwZjdkIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWNzX2dwdV9rdm1tNjAiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfZGVmb2ciLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfc3VwZXJfcmVzb2x1dGlvbiIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19vY3JfaGFuZHdyaXRpbmciLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfcGF0aF9wcm9ncmFtIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfY2VzX2FndCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2RvbWFpbiIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19ncHVfdjEwMCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19vY3JfYmFua19jYXJkIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZHdzX3BvYyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Rkc19yZXBsaWNhIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbWxzX3N0ZCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2VycyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2lvdC10cmlhbCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc3F1aWNrZGVwbG95IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfcmRzX2h3c3FsIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfcnRzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfY2xvdWR0YWJsZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19kZWgiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9lY3NfZnBnYSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19iaW5fcGFja2luZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FpcyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19yZWN5Y2xlYmluIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfc2FwaGFuYSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Nsb3VkaWRlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYmNzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfb21zIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZ2VzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWNzX2V0MiIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Rlc3MiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfdGV4dF9hbnRpX3NwYW0iLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9hYWRfZnJlZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19vY3JfaWRfY2FyZCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19ub3JtYWxfczMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9WT0QiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9jcHRzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWNzX2dwdV9wNCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19pbWFnZV9yZWNhcHR1cmVfZGV0ZWN0IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYWlzX29jcl9nZW5lcmFsX3RleHQiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9zY2Nfc2NzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbWxzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfc2NjX3NzYSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19oMSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2RycyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19oMyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3ZvaWNlY2FsbCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc190dHMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9pb3QwMSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19kaXNraW50ZW5zaXZlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYWlzX2ltYWdlX3RhZ2dpbmciLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9yZHNfY3VzdG9tZXJjbG91ZCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FwaWciLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9kY3NfbWVtY2FjaGVkIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYWlzX2Fzcl9zZW50ZW5jZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19vY3JfdmF0X2ludm9pY2UiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF92aXBfYmFuZHdpZHRoIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYWlzX29jcl9tdnNfaW52b2ljZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NjZV9ncHUiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9kbHMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfb2NyX2JhcmNvZGUiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfZGlzdG9ydGlvbl9jb3JyZWN0IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfdXF1ZXJ5IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfY2xvdWRjYyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19pbWFnZV9jbGFyaXR5X2RldGVjdCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NycyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2xsZCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19vY3JfZ2VuZXJhbF90YWJsZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX3BjX3ZlbmRvcl9zdWJ1c2VyIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfSU0iLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9MVFMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9lY3NfZ3B1X2NhIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZ2F0ZWRfZWNzX3JlY3ljbGViaW4iLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfb2NyX3ZlaGljbGVfbGljZW5zZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19kaXNwYXRjaF9wbGFubmluZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc190aW1lX2Fub21hbHkiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9mZ3MiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9lY3NfSGlnaFBlcmZvcm1hbmNlSDFIQU5BIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfbGVnYWN5IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYWlzX3BpY2t1cF9wbGFubmluZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FfQ04tU09VVEgtMyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX21vYmlsZXRlc3QiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9kbnMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfb2NyX2RyaXZlcl9saWNlbnNlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYWlzX29jcl9xcl9jb2RlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZGNzX2ltZGciLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF90bXMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfZGFya19lbmhhbmNlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfSGlnaElPSTMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfaW1hZ2VfYW50aXBvcm4iLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9tcGMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9jY2kiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9jY3MiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9haXNfb2NyX3BsYXRlX251bWJlciIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NjZV93aW4iLCJpZCI6IjAifV0sInByb2plY3QiOnsiZG9tYWluIjp7Im5hbWUiOiJsaWxpYW5neXUiLCJpZCI6Ijk2ZmE0OGUyYzVkNTQ1NTQ5YjYxMjA5OTdkNDViZjc2In0sIm5hbWUiOiJjbi1zb3V0aC0xIiwiaWQiOiJjOGYxMTM0NzYyMmI0Y2Q4YmFkZjE3Y2I5Njk0YWYyZiJ9LCJpc3N1ZWRfYXQiOiIyMDE4LTA0LTExVDAxOjI3OjE0LjE2MTAwMFoiLCJ1c2VyIjp7ImRvbWFpbiI6eyJuYW1lIjoibGlsaWFuZ3l1IiwiaWQiOiI5NmZhNDhlMmM1ZDU0NTU0OWI2MTIwOTk3ZDQ1YmY3NiJ9LCJuYW1lIjoibGlsaWFuZ3l1IiwiaWQiOiJhYmQxYzY5OGQ3OWI0MGUyOWFmM2Q1MGVkNWVlMGFkNSJ9fX0xggGFMIIBgQIBATBcMFcxCzAJBgNVBAYTAlVTMQ4wDAYDVQQIDAVVbnNldDEOMAwGA1UEBwwFVW5zZXQxDjAMBgNVBAoMBVVuc2V0MRgwFgYDVQQDDA93d3cuZXhhbXBsZS5jb20CAQEwCwYJYIZIAWUDBAIBMA0GCSqGSIb3DQEBAQUABIIBAH8SwaxroSgiKyWU1rJ6Oa-8+sSJofr39u5EbGBmB+dvgI6L00YI8iUrBp3lDCnL7DsPQr41IGB83boAGw+UhkzRP-2KjEyt0ljcelfPOXh9thL7qRkMk6r9ZOroscmuKyKtyEpqcrApZXuqu4gZm-LPt2RyUYGYzps+pX1J2Xwf6gMbrvZmINWDFy+6C+egf8d+rC86z1NxJTSQwWRmZB0uYN93bo-sLKPq6VK214wv4tDMiRGCDp3J5H9T7H-oAPJJL-J+KnMts1JFcqGWvlLNCsbQsi4vEICctR3IWfnhPCI3zyi34j-heee3N2H2pyZpEKn79IUbPUl1sVP9SLc=";
    	String imageID = "d47896ef-19b4-446a-af97-8cb702dd5c83";

//    	String token = getToken("https://iam.cn-south-1.myhuaweicloud.com/v3/auth/tokens", "zyfhuawei-test", "0ca566cd62884c8e94b1d111d4dfe88a", "zyfanthony03@uci");
//
//    	String imageID = "ef344858-e60e-4df6-8413-acf81a95bcae";
//    	String imageName = "CentOS-GPU-peraglobal";
//    	
    	System.out.println(dupImage("https://ims.cn-south-1.myhuaweicloud.com/v2/images/imageID", token, imageID, ""));
//    	Map<String, String> map = new HashMap<String, String>();
//    	map = getTokenMap("https://iam.cn-south-1.myhuaweicloud.com/v3/auth/tokens", "sda", "dad", "sda@uci");
//    	
//    	System.out.println(map.get("name"));
//        //https://support.huaweicloud.com/api-iam/zh-cn_topic_0057845583.html
//https://ims.cn-south-1.myhuaweicloud.com/v2/images/imageID
    }
}
