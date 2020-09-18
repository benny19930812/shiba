package project1;

import java.sql.*;
import java.util.Scanner;

public class JavaScanner3 {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
				"project");) {
			System.out.println("歡迎使用全國PM2.5指標查詢系統 請輸入需要操作的功能\r\n+"
					+ "1 PM2.5查詢 2 資料新增 3資料更新 4 資料刪除");
			int num3, num4;
			Scanner scanner = new Scanner(System.in);
			num3 = scanner.nextInt();
			//進入查詢系統
			if (num3==1) {
				
			
			int num1, num2;
			PreparedStatement pstmt1 = connection.prepareStatement("select * from table1 where country=?");
			pstmt1.setString(1, "臺北市");
			ResultSet rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				System.out.println("最近更新時間" + rs1.getDate("DATACREATIONDATE"));
				pstmt1.clearParameters();
			}
			

			System.out.println("請輸入欲查詢縣市\r\n " + " 1台北市  2新北市 3基隆市  4桃園市  5新竹市  6新竹縣  7苗栗縣  8台中市  9彰化縣 10南投縣11雲林縣\r\n"
					+ "12嘉義市13嘉義縣14台南市15高雄市16屏東縣17台東縣18花蓮縣19宜蘭縣20澎湖縣21金門縣22連江縣 ");

			Scanner scanner2 = new Scanner(System.in);
			num1 = scanner2.nextInt();

			if (num1 == 1) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "臺北市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			
			if (num1 == 2) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "新北市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 3) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "基隆市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 4) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "桃園縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 5) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "新竹市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 6) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "新竹縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 7) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "苗栗縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 8) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "台中市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 9) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "彰化縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 10) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "南投縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 11) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "雲林縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 12) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "嘉義市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 13) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "嘉義縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 14) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "臺南市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 15) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "高雄市");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 16) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "屏東縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			
			if (num1 == 17) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "臺東縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 18) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "花蓮縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 19) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "宜蘭縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 20) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "澎湖縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 21) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "金門縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			if (num1 == 22) {
				PreparedStatement pstmt = connection.prepareStatement("select * from table1 where country = ? ");
				pstmt.setString(1, "連江縣");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為 "
							+ rs.getString("PM25") + " μg/m3");
					pstmt.clearParameters();
				}
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
