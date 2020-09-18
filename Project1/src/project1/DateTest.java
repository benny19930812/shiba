package project1;


import  java.util.*;
import java.text.*;
public class DateTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	     SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
//	        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm");
//	        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等價於now.toLocaleString()
//	        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒 E ");
//	        SimpleDateFormat myFmt4=new SimpleDateFormat(
//	                "一年中的第 D 天 一年中第w個星期 一月中第W個星期 在一天中k時 z時區");
	        Date now=new Date();
	        System.out.println(myFmt.format(now));
		
		
	}

}
