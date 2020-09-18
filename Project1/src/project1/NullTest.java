package project1;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Timestamp;


public class NullTest{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
URL url = new URL("https://data.epa.gov.tw/api/v1/aqx_p_02?limit=1000&api_key=9be7b239-557b-4c10-9775-78cadfc555e9&format=csv");
try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
		"project");	
	InputStream inp= url.openStream();
	BufferedInputStream binp = new BufferedInputStream(inp);
	InputStreamReader inpr = new InputStreamReader(binp);
	BufferedReader br = new BufferedReader(inpr);
		) {
	
	String line = null;
	while((line = br.readLine())!=null) {
//	System.out.println(line);
	String reline= line.replace("Site,county,PM25,DataCreationDate,ItemUnit","台灣,台灣省,27,2020-09-07 17:00,μg/m3");
//	System.out.println(reline);
//	if (reline != null && !reline.equals("") && !reline.equals("null")) {
	String[] item = reline.split(",");
		for(int i=0;i<item.length;i++){
		System.out.println(item[i]);
		}
		
//	}
	}
			
		
		
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}