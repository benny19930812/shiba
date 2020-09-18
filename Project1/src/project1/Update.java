package project1;

import java.sql.*;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
				"project");) {

			int num1, num2;
			String string1 = null, string2 = null, string3 = null;
			Scanner scanner = new Scanner(System.in);
			PreparedStatement pstmt = connection
					.prepareStatement("update table1 set PM25=? where site=?");
			
			
			System.out.println("請輸入修改的縣市 1臺北市  2新北市 3基隆市  4桃園市  5新竹市  6新竹縣  7苗栗縣  8台中市  9彰化縣 10南投縣11雲林縣\r\n"
					+ "12嘉義市13嘉義縣14臺南市15高雄市16屏東縣17台東縣18花蓮縣19宜蘭縣20澎湖縣21金門縣22連江縣 ");
			string1 = scanner.nextLine();
			System.out.println("請輸入地區");
			string2 = scanner.nextLine();
			pstmt.setString(2,string2);
			System.out.println("請輸入更新PM2.5數值");
			string3 = scanner.nextLine();
			pstmt.setString(1,string3);		
			System.out.println("確認是否修改\r\n" + "1確認  2取消");
			num1 = scanner.nextInt();
			if (num1 == 1) {
				pstmt.executeUpdate();
				pstmt.clearParameters();
				System.out.println("資料已修改");
			}
			if (num1 == 2) {
				System.out.println("修改已取消");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
