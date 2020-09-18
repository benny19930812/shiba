package project1;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UrlToSql {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		int num1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("是否確認更新?\r\n" + "1確認  2取消");
		num1 = scanner.nextInt();
		URL url = new URL(
				"https://data.epa.gov.tw/api/v1/aqx_p_02?limit=1000&api_key=9be7b239-557b-4c10-9775-78cadfc555e9&format=csv");
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
				"project");
				InputStream inp = url.openStream();
				BufferedInputStream binp = new BufferedInputStream(inp);
				InputStreamReader inpr = new InputStreamReader(binp,"UTF-8");
				BufferedReader br = new BufferedReader(inpr);) {

			Statement stmt = connection.createStatement();
			String query = "DELETE FROM table1";
			int delete = stmt.executeUpdate(query);
			if (delete > 0) {
				System.out.println("舊資料已刪除");
			} else {
				System.out.println("資料庫無資料.");
			}

			String line = null;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				String reline = line.replace("Site,county,PM25,DataCreationDate,ItemUnit",
						"台灣,台灣省,27,2020-09-07 17:00,μg/m3");
//				System.out.println(reline);
//				if (reline != null && !reline.equals("") && !reline.equals("null")) {
				String item[] = reline.split(",");			
				for (int i = 0; i < item.length; i++) {
					System.out.println(item[i]);
				}

//				}			
				PreparedStatement pstmt = connection
						.prepareStatement("insert into table1 (SITE,COUNTRY,pm25,datacreationdate)values(?,?,?,?)");
				pstmt.setString(1, item[0]);
				pstmt.setString(2, item[1]);
//				pstmt.setString(3, item[2]);
//				pstmt.setString(4, item[3]);
				
				if (Integer.valueOf(item[2])==) {
					pstmt.setInt(3, -1);		
				}
				else {
//				 int內有NULL值 無法儲存
					pstmt.setInt(3, Integer.valueOf(item[2]));				
				}			
//				 string=>date
				
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
//				Date date = (Date) format.parse(item[3]);
//				Timestamp ts = new Timestamp(date.getTime());
//				pstmt.setTimestamp(4, ts);
//				
//	

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date1 = null;
				date1 = sdf.parse(item[3]);							
				long lg = date1.getTime();
				pstmt.setDate(4, new java.sql.Date(lg));
				pstmt.execute();
				
			}
			System.out.println("資料庫已更新");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (ParseException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

}
