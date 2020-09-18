//package com.iii.jerry;
//
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.Array;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import com.sun.corba.se.pept.transport.Connection;
//
//public class csv {
//	public static void main(String[] args) {
//		try {
//			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";//資料庫選擇
//			java.sql.Connection conn = DriverManager.getConnection(connUrl, "sa", "P@sswOrd");
//			
//			
//			
//			FileReader fr = new FileReader("C:\\test.csv");//抓CSV檔進java
//            BufferedReader brdFile = new BufferedReader(fr);//bufferedReader
//            String strLine = null;
//            while((strLine = brdFile.readLine())!=null){//將CSV檔字串一列一列讀入並存起來直到沒有列為止
//            
//            
//			
//			String[] array=strLine.split(",");//因為預設是用"，"分開所以用split切開存入字串陣列
//			System.out.println(strLine);
//			for(int i=0;i<array.length;i++){//偷看陣列元素有沒有切對
//			System.out.println(array[i]);
//			}
//			String qryInsert="insert into custinfo values(?,?,?,?)";//動態SQL指令
//					
//			PreparedStatement pstmt= conn.prepareStatement(qryInsert);//因為是insert所以用PreparedStatement來接
//			
//			pstmt.setString(1,array[0]);
//			pstmt.setInt(2,Integer.valueOf(array[1]));//因為這欄是用int的格式，所以將array[1]值抓出來轉int			
//			pstmt.setString(3,array[2]);			
//			pstmt.setString(4,array[3]);
//			
//			pstmt.execute();
//			};
//		}catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (IOException e) {
//				// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (SQLException e){
//				// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
//	
//}package project1;
//
//public class Csv {
//
//}
