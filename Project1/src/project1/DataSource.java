package project1;

import java.math.BigDecimal;
import java.sql.*;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
		dataSource.setUsername("PROJECT");
		dataSource.setPassword("project");
		dataSource.setMaxTotal(50); // 設定最多connection上線,超過使用量必須等待
		dataSource.setMaxIdle(50); // 設定最多idle的connection,超過的connection會被執行connection.close()

		try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement();
			
			
			) {

			PreparedStatement pstmt= conn.prepareStatement("select * from table1 where site=?");
			pstmt.setString(1,"林口");
			ResultSet rs =pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("林口PM2.5數值為"+rs.getInt("PM25")+" μg/m3");
			}
	          String site = rs.getString("site");
              int pm25 = rs.getInt("pm25");
              if ( site.equals("林口")){
                  pstmt.setBigDecimal(1,new BigDecimal(rs.getString("PM25")));
//              }else if ( job.equals("業務")){
//                  pstmt.setint(1,);
			
			
			System.out.println("connection success");
              }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
