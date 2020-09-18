package project1;

import java.sql.*;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
				"project");) {
			int num4,num5;
			String string1=null;
			Scanner scanner4 = new Scanner(System.in);
			PreparedStatement pstmt = connection.prepareStatement("delete from table1 where site=?");
			System.out.println("請輸入地區臺北市  2新北市 3基隆市  4桃園市  5新竹市  6新竹縣  7苗栗縣  8台中市  9彰化縣 10南投縣11雲林縣\r\n"
					+ "12嘉義市13嘉義縣14臺南市15高雄市16屏東縣17台東縣18花蓮縣19宜蘭縣20澎湖縣21金門縣22連江縣 ");
			num4 = scanner4.nextInt();
			System.out.println("請輸入地區");
			//新增一行nextLine() 因為nextInt()執行會回傳一個空白導致nextInt()被執行
			string1 = scanner4.nextLine();
			string1 = scanner4.nextLine();
			pstmt.setString(1, string1);
			pstmt.executeUpdate();
			pstmt.clearParameters();
			System.out.println("資料已刪除");


		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
