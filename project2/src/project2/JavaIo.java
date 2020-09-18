package project2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class JavaIo extends JsonOJ {
	public static void main(String[] args) throws IOException {
		// http://iosnetworkdemo.appspot.com/json.jsp?msg=helloWorld
		// 此將此網址回傳的結果示在Console中
		URL url = new URL("https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=6");
		try (InputStream inp = url.openStream(); //
				BufferedInputStream binp = new BufferedInputStream(inp);
				InputStreamReader inpr = new InputStreamReader(binp);
				BufferedReader br = new BufferedReader(inpr);) {
			String line = null;
			String line2 = null ;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				line2=line;
			}
//			System.out.println(line2);
//			String userJson = "[{'name': 'Alex','id': 1}, " + "{'name': 'Brian','id':2}, " + "{'name': 'Charles','id': 3}]";
			Gson gson = new Gson();
			
			Type userListType = new TypeToken<ArrayList<JsonOJ>>(){}.getType();
			 
			ArrayList<JsonOJ> userArray = gson.fromJson(line2, userListType);  
			 
			for(JsonOJ user : userArray) {
//			    System.out.println("title"+user.getTitle());
//			    System.out.println("UID"+user.getUID());
			    System.out.println(user);
			}
		
//			JsonOJ[] userArray = gson.fromJson(line2, JsonOJ[].class);
//			System.out.println(userArray);
//			for(JsonOJ user : userArray) {
//				System.out.println(user);
//			}

//			System.out.println(jsonOJ.getTitle());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
