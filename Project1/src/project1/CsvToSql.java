package project1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CsvToSql {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("c:\\iii\\pm2.5.csv");

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
				"project");
				InputStream inp = new FileInputStream(file);
				BufferedInputStream binp = new BufferedInputStream(inp);
				InputStreamReader inpr = new InputStreamReader(binp, "UTF-8");
				BufferedReader br = new BufferedReader(inpr);) {
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println(line);
			
			String reline = line.replace("Site,county,PM25,DataCreationDate,ItemUnit,",
					"台灣,台灣省,27,2020-09-07 17:00,μg/m3");
			System.out.println(reline);
			String[] item = line.split(",");
			for (int i = 0; i < item.length; i++) {
				System.out.println(item[i]);
			}

			PreparedStatement pstmt = connection
					.prepareStatement("insert into table1 (SITE,COUNTRY,pm25,datacreationdate)values(?,?,?,?)");
			pstmt.setString(1, item[0]);
			pstmt.setString(2, item[1]);
			pstmt.setInt(3, Integer.valueOf(item[2]));
			// string=>date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			java.util.Date date1 = sdf.parse(item[3]);
			long lg = date1.getTime();
			pstmt.setDate(4, new java.sql.Date(lg));
			pstmt.execute();

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