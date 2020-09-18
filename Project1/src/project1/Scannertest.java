package project1;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Scannertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
while (true) {
		try {
			

		System.out.println("請輸入");	
		String string = null;
		int num1;
		Scanner scanner = new Scanner(System.in);
		num1= scanner.nextInt();
		if (num1==1) {
			System.out.println("成功");
		}
//		else {
//			System.out.println("輸入錯誤 請重新輸入");
//			
//			string = scanner.nextLine();
//		}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("輸入錯誤 請重新輸入");
		}
	}		
		
	}
}

