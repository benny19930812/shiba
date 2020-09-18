package project1;

import java.sql.*;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xepdb1", "PROJECT",
			"project");) {

		Statement stmt= connection.createStatement();
		String query = "DELETE FROM table1";
		int deletedRows=stmt.executeUpdate(query);
		if(deletedRows>0){
		     System.out.println("Deleted All Rows In The Table Successfully...");
		   }else{
                        System.out.println("Table already empty."); 
		  }
		
//		stmt.executeUpdate("delete from table1");
//		stmt.close();
		
//		PreparedStatement pstmt2 = connection.prepareStatement("delete from table1 ");
//		pstmt2.setString(1,"table1");
//		pstmt2.executeUpdate();
//		pstmt2.clearParameters();
//		System.out.println("舊資料已刪除");
//		
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();

	}
		
		
		
	}

}
