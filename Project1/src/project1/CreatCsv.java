package project1;

import java.io.File;
import java.io.IOException;

public class CreatCsv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("C:\\iii\\report.csv");
		try {
			file.createNewFile();
		
		
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
