package project1;

import java.sql.*;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
			"project");) {

		int num1 = 0, num2;
		String string1,string2,string3 = null;
			Scanner scanner = new Scanner(System.in);
			
			PreparedStatement pstmt = connection.prepareStatement("insert into table1 (COUNTRY,SITE,PM25)values(?,?,?)");
			System.out.println("請輸入欲新增的縣市");
			string1 = scanner.nextLine();
			pstmt.setString(1, string1);
			System.out.println("請輸入地區");
			string2 = scanner.nextLine();	
			pstmt.setString(2, string2);
			System.out.println("請輸入PM2.5數值");
			string3 = scanner.nextLine();	
			pstmt.setString(3, string3);
			System.out.println("確認是否新增\r\n"
					+"1確認  2取消");
			num1 = scanner.nextInt();
				if (num1==1) {
					pstmt.execute();
					System.out.println("資料已寫入");								
				}
				if (num1==2) {
						System.out.println("寫入已取消");			
					}
			
			
	
		
			
		
		
	} catch (SQLException e) {
		e.printStackTrace();

	}
	
		
		
	}

}
