package project1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.file.attribute.AclEntry.Builder;
import java.sql.*;
import java.util.Scanner;

public class CsvPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				File file = new File("C:\\iii\\report.csv");
				file.createNewFile();
//				File file2 = new File("C:\\iii\\report.csv");
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
				"project");
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter writer = new OutputStreamWriter(fos, "MS950");
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) 
		{

			System.out.println("是否確認匯出\r\n" + "1確認 2取消");
			int num1;
			Scanner scanner = new Scanner(System.in);
			num1 = scanner.nextInt();
			if (num1 == 1) {

				Statement stmt = connection.createStatement();
				String query = "select * from table1";
				ResultSet rs = stmt.executeQuery(query);

				StringBuilder builder = new StringBuilder();
				builder.append("Site").append(",").append("Country").append(",").append("PM2.5").append(",")
						.append("ItemUnit");
//			System.out.println(builder);

				while (rs.next()) {
					String site = rs.getString("site");
					String country = rs.getString("country");
					String pm25 = rs.getString("PM25");

					builder.append(System.lineSeparator());
					builder.append(site).append(",");
					builder.append(country).append(",");
					builder.append(pm25).append(",").append("μg/m3");
				}

//				System.out.println(builder.toString());
				bufferedWriter.write(builder.toString());
				System.out.println("資料已匯出");
			}
			if (num1 == 2) {
				System.out.println("匯出已取消");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
