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

public class UPDATE2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL(
				"https://data.epa.gov.tw/api/v1/aqx_p_02?limit=1000&api_key=9be7b239-557b-4c10-9775-78cadfc555e9&format=csv");
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
				"project");
				InputStream inp = url.openStream();
				BufferedInputStream binp = new BufferedInputStream(inp);
				InputStreamReader inpr = new InputStreamReader(binp);
				BufferedReader br = new BufferedReader(inpr);) {

			String line = null;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				String reline = line.replace("Site,county,PM25,DataCreationDate,ItemUnit",
						"台灣,台灣省,27,2020-09-07 17:00,μg/m3");
//				System.out.println(reline);
//				if (reline != null && !reline.equals("") && !reline.equals("null")) {
				String item[] = reline.split(",");
				for (int i = 0; i < item.length; i++) {
//					System.out.println(item[i]);
				}

//				}			
				PreparedStatement pstmt = connection
						.prepareStatement("update set table1 (SITE,COUNTRY,pm25,datacreationdate)values(?,?,?,?)");
				pstmt.setString(1, item[0]);
				pstmt.setString(2, item[1]);
				pstmt.setString(3, item[2]);
//				if (item[2]==null) {
//					
//				}
//				else {
//				pstmt.setInt(3, Integer.valueOf(item[2]));
				// int內有NULL值 無法儲存
//				}			
				// string=>date
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date1 = sdf.parse(item[3]);
				long lg = date1.getTime();
				pstmt.setDate(4, new java.sql.Date(lg));
				pstmt.executeUpdate();
				System.out.println("資料已更新");
			}
			;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
