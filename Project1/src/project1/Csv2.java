//import java.io.BufferedReader;
//
//
//import java.io.*;
//
//
//import java.util.*;
//
//
//import java.io.IOException;
//
//
//import java.sql.*;
//
//
//public class test{
//
//
//public static void main(String[] args){
//
//
//csv2sql("test.csv");
//
//
//}
//
//
//private static void csv2sql(String filename){
//
//
//try{
//
//
//BufferedReader br = new BufferedReader(new FileReader(filename));
//
//
//String line = null;
//
//
//String connString = "jdbc:sqlserver://127.0.0.1:1433;database=test;user=sa;password=test";
//
//
//Connection con = null;
//
//
//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//
//con = DriverManager.getConnection(connStr);
//
//
//while ((line=br.readLine())!=null){
//
//
//String item[] = line.split(",");
//
//
//String sql = "insert into table (column1,column2) values ('"+item[0]+"','"+item[1]+"')";
//
//
//Statement stmt = con.createStatement();
//
//
//stmt.executeUpdate(sql);
//
//
//stmt.close();
//
//
//}
//
//
//}
//
//
//catch (IOException e){
//
//
//e.printStackTrace();
//
//
//}
//
//
//}
//
//
//}
//
