package project1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
public class DownloadCsv {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://data.epa.gov.tw/api/v1/aqx_p_02?limit=1000&api_key=9be7b239-557b-4c10-9775-78cadfc555e9&format=csv");
		// 取得InputStream就可以read資料
		try (InputStream is = url.openStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				FileOutputStream fos = new FileOutputStream("c:\\iii\\pm2.5.csv");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				) {

			byte[] buffer = new byte[1024];
			int length;
			while ((length = bis.read(buffer)) != -1) {
				bos.write(buffer,0,length);
			}

			System.out.println("finish");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
