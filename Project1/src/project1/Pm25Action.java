package project1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

public class Pm25Action extends Pm25 {

	public static void main(String[] args) throws ParseException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/XEPDB1");
		dataSource.setUsername("PROJECT");
		dataSource.setPassword("project");
		dataSource.setMaxTotal(50); // 設定最多connection上線,超過使用量必須等待
		dataSource.setMaxIdle(50); // 設定最多idle的connection,超過的connection會被執行connection.close()

		int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13;
		Scanner scanner5 = new Scanner(System.in);

		// 返回主畫面
		String string7 = null;
		System.out
				.println("                                                                                                                  \r\n" + 
						"                                                                                    ir7i.                         \r\n" + 
						"                                                                                  .P27ii..:.                      \r\n" + 
						"                                                                                  Xs777iiir:.                     \r\n" + 
						"                                                                                 s2vvs7rrL7r...                   \r\n" + 
						"                                                                                .KJYLr7rrir77i:.                  \r\n" + 
						"                                                                                JUvLv2v7r7r77i::..:ir7r77ri::::rrv\r\n" + 
						"                                                                                qjs1Ji:.:rvrvr:.. .::.:iiir::7vvvL\r\n" + 
						"                                                                               .I27vi.   .:rvL:...:i.::::i::.irrir\r\n" + 
						"                .:i:.    .         .    :7Yr        .:iir:                     .UvYri...  .7YYi.i7r:iiiii:ii::rrr:\r\n" + 
						"               :BE5ZBB  .BB       QB1  SB5YqQ7      BB1qbv                     :2JIIL7.    j27:vJ7r77v7ririi:::rri\r\n" + 
						"               :B    BB  BQQ     2BBU       PB      B.                         :gI17::r.    L71j7r77L7vrrii:..:irr\r\n" + 
						"               .B    Bd  B Bg   :B B1       Bj      BBIPi                      .ZPr:..ri.7. :2Jv7Lvv77rv777i. .r7v\r\n" + 
						"               .BggBBj  .B  Bi  B: BI     sB7       ...rBB                      sE177i:.rjUu5usvLvv7vr77777ri .v77\r\n" + 
						"               :B.      .B  .B BP  BU   .BE              B.                     .1s7ii:rvuU5Ujvvr77LvYLvLLr7i..77j\r\n" + 
						"               :B       :B   jBB   BE  BBU .i.  P: .v. :BB                       v1LsvjUI1I12JL7rir7Jj51UULr7..ivS\r\n" + 
						"               .d        Z    1    Xi  Q5UPEZj .Br .QQDDr                        KqKU5ISuU11JJvv7jJjJ25SuIJi7i.iYP\r\n" + 
						"                                                                                .ZPu5S51112u1YJ1bgREPU2S5U1r7r::sq\r\n" + 
						"                                                                                .dIS5XII2I1IjJs5S5viiisEXXuvLu::iU\r\n" + 
						"                                                                                sPqKqXS2II5U22PK.  :   r1IXu2Us..i\r\n" + 
						"                                                                                XZKPqPXXSPqPKbMQU:     ..ruXU22r..\r\n" + 
						"                                                                               .ZbdPPPEPdDRgZdgZZPu:....:rs77vsY.:\r\n" + 
						"                                                                                KZXPPZZgDQQRDgbEbbKPXSsLLviiir7J:i\r\n" + 
						"                                                                                dgZPDDRgMRQMgDgEDPPSKPd57ivYvr77:i\r\n" + 
						"                :DQBB5                                QM                       :ZQgggRgRMQMgggDRggEgEZburJuIjL7r:r\r\n" + 
						"               bB.  :r                                Bg                       .ZMQMQgRMQMRggDRQQMQgDP5J1uSKKSKYi7\r\n" + 
						"               BB        SRRQs   PRRQd   RrPB: .gQQB: QQrZQB.                   2gZggRMQgRgRDgRBQQggEPSK551XKDqjvI\r\n" + 
						"                1BBX.   BE   Bg  :   BQ  BB.  rBv  .  BB.  ZB                   vbDZggRRQMRDMgQQQRQRQEEdEPbdP:    \r\n" + 
						"                  .5BE iB2SZSBB  vKqjBB  Bi   BP      Bg    B                   rPEDZgZgDMgggQQQMQMRRgqEEEDD. ..  \r\n" + 
						"                    :B  B.      BB   BB  Qr   BB      BM   .B                   7KPbgDgZDPdPddgRQMggQPK5PdR5      \r\n" + 
						"               QBDKbBP  JBqJUQ. 2Bus2BB  B7    BQKUQ: QB   :Q.                  :S5PbggMDgZEbdKZMMggggdPXPbdi   . \r\n" + 
						"                :r7i      i7r.    7r  .  .      .r7:  .     .                   .2qIKbgDMggZggMgQRgZQgZKPXKKPr    \r\n" + 
						"                                                                                 JP5IPbDZDEggQQQgMPJ2REKXqSXvi..  \r\n" + 
						"                                                                                 :dXXIqPEdDDgZMgggg5s7X5X5si:..:: \r\n" + 
						"                                                                                 .5dSSSqPZEgZDZggRDMd27L1Lr:::..  \r\n" + 
						"                                                                                  7PqXXXPPEdDZgZgEgDDEb5qISqdKIvsu\r\n" + 
						"                                                                                  .5XKSKXPKbbgdZdEEZdggMDgPKSPK5sU\r\n" + 
						"                                                                                   sPKqSqKbPEdEbEPPKPqddEbDKXI1777\r\n" +
						"                                                 請按任意鍵進入畫面");

		string7 = scanner5.nextLine();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		while (true) {
			try (Connection connection = dataSource.getConnection(); Statement stmt = connection.createStatement();) {

				PreparedStatement pstmt1 = connection.prepareStatement("select * from table1 where country=?");
				pstmt1.setString(1, "臺北市");
				ResultSet rs1 = pstmt1.executeQuery();
				if (rs1.next()) {
					System.out.println("");
					System.out.println("");
					System.out.println("最近更新時間" + rs1.getString("DATACREATIONDATE"));
					pstmt1.clearParameters();
				}
				System.out.println(""
						+ "                       ************************************************************************                       \r\n"
						+ "                       ************************************************************************                       \r\n"
						+ "                       *******                 歡迎使用PM2.5 查詢系統                    ******                       \r\n"
						+ "                       ************************************************************************                       \r\n"
						+ "                       ************************************************************************                       \r\n"
						+ "                                                                 版本:1.0.0\r\n"
						+ " 請輸入需要操作的功能\r\n" + "\r\n" + "1.查詢PM2.5指數  2.資料新增  3.資料更新   4.資料修改  5.資料刪除   6.資料匯出  7.關閉程式");

				Scanner scanner = new Scanner(System.in);
				num3 = scanner.nextInt();
				// 進入查詢系統
				if (num3 == 1) {

					System.out.println(
							"請輸入欲查詢縣市\r\n " + " 1台北市  2新北市 3基隆市  4桃園市  5新竹市  6新竹縣  7苗栗縣  8台中市  9彰化縣  10南投縣  11雲林縣\r\n"
									+ "12嘉義市  13嘉義縣  14台南市  15高雄市  16屏東縣  17台東縣  18花蓮縣  19宜蘭縣  20澎湖縣  21金門縣  22連江縣 ");

					Scanner scanner2 = new Scanner(System.in);
					num1 = scanner2.nextInt();
					if (num1 == 1) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "臺北市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					}

					else if (num1 == 2) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "新北市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 3) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "基隆市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 4) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "桃園市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 5) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "新竹市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 6) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "新竹縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 7) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "苗栗縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 8) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "臺中市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 9) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "彰化縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 10) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "南投縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 11) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "雲林縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 12) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "嘉義市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 13) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "嘉義縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 14) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "臺南市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 15) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "高雄市");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 16) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "屏東縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					}

					else if (num1 == 17) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "臺東縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 18) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "花蓮縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 19) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "宜蘭縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 20) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "澎湖縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 21) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "金門縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為"
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else if (num1 == 22) {
						PreparedStatement pstmt = connection
								.prepareStatement("select * from table1 where country = ? ");
						pstmt.setString(1, "連江縣");
						ResultSet rs = pstmt.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString("country") + rs.getString("site") + "地區的PM2.5數值為 "
									+ rs.getString("PM25") + " μg/m3");
							pstmt.clearParameters();
						}
					} else {
						System.out.println("輸入錯誤 請重新輸入");
					}
					// 新增功能
				} else if (num3 == 2) {
					String string1, string2, string3 = null;
					Scanner scanner3 = new Scanner(System.in);

					PreparedStatement pstmt = connection
							.prepareStatement("insert into table1 (COUNTRY,SITE,PM25)values(?,?,?)");

					System.out.println("請輸入欲新增的縣市");
					string1 = scanner3.nextLine();
					pstmt.setString(1, string1);
					System.out.println("請輸入地區");
					string2 = scanner3.nextLine();
					pstmt.setString(2, string2);
					System.out.println("請輸入PM2.5數值");
					string3 = scanner3.nextLine();
					pstmt.setString(3, string3);
					System.out.println("是否確認新增?\r\n" + "1確認  2取消");
					num8 = scanner.nextInt();
					if (num8 == 1) {
						pstmt.execute();
						System.out.println("資料已寫入");
					} else if (num8 == 2) {
						System.out.println("寫入已取消");
					} else {
						System.out.println("輸入錯誤 請重新輸入");
					}

				}
				// 更新資料
				else if (num3 == 3) {
					System.out.println("是否確認更新?\r\n" + "1確認  2取消");
					num9 = scanner.nextInt();
					if (num9 == 1) {
						URL url = new URL(
								"https://data.epa.gov.tw/api/v1/aqx_p_02?limit=1000&api_key=9be7b239-557b-4c10-9775-78cadfc555e9&format=csv");

						InputStream inp = url.openStream();
						BufferedInputStream binp = new BufferedInputStream(inp);
						InputStreamReader inpr = new InputStreamReader(binp, "UTF8");
						BufferedReader br = new BufferedReader(inpr);

						String query = "DELETE FROM table1";
						int delete = stmt.executeUpdate(query);
						if (delete > 0) {
							System.out.println("舊資料已刪除");
						} else {
							System.out.println("資料庫無資料.");
						}

						String line = null;
						while ((line = br.readLine()) != null) {
//						System.out.println(line);
							String reline = line.replace("Site,county,PM25,DataCreationDate,ItemUnit",
									"台灣,台灣省,27,2020-09-07 17:00,μg/m3");
//						System.out.println(reline);

							String item[] = reline.split(",");
							for (int i = 0; i < item.length; i++) {
//							System.out.println(item[i]);
							}

//						}			
							PreparedStatement pstmt = connection.prepareStatement(
									"insert into table1 (SITE,COUNTRY,pm25,datacreationdate)values(?,?,?,?)");
							pstmt.setString(1, item[0]);
							pstmt.setString(2, item[1]);
							pstmt.setString(3, item[2]);

//							if (item[2]==null) {
//								pstmt.setInt(3, -1);
//							} else {
//								pstmt.setString(3, item[2]);
//							}

							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							Date date1 = null;
							date1 = sdf.parse(item[3]);
							long lg = date1.getTime();
							pstmt.setDate(4, new java.sql.Date(lg));
							pstmt.execute();

						}
						System.out.println("資料庫已更新");
					} else if (num9 == 2) {
						System.out.println("更新已取消");
					} else {
						System.out.println("輸入錯誤 請重新輸入");
					}

				}
				// 資料修改
				else if (num3 == 4) {

					String string1 = null, string2 = null, string3 = null;
					Scanner scanner3 = new Scanner(System.in);
					PreparedStatement pstmt = connection.prepareStatement("update table1 set PM25=? where site=?");

					System.out.println(
							"請輸入修改的縣市" + " 1臺北市  2新北市 3基隆市  4桃園市  5新竹市  6新竹縣  7苗栗縣  8台中市  9彰化縣  10南投縣  11雲林縣\r\n"
									+ "12嘉義市  13嘉義縣  14臺南市  15高雄市  16屏東縣  17台東縣  18花蓮縣  19宜蘭縣  20澎湖縣  21金門縣  22連江縣 ");
					num1 = scanner.nextInt();
					// 新增地區名單
					if (num1 == 1) {
						System.out.println("1大同 2士林 3中山 4萬華 5陽明");
					} else if (num1 == 2) {
						System.out.println("1菜寮 2淡水 3林口富貴角 4汐止 5萬里 6新店 7土城 8板橋 9永和 10新莊 11三重 12新北(樹林)");
					} else if (num1 == 3) {
						System.out.println("1基隆");
					} else if (num1 == 4) {
						System.out.println("1桃園 2大園 3觀音 4平鎮 5龍潭 6中壢 7桃園(觀音工業區)");
					} else if (num1 == 5) {
						System.out.println("1新竹市");
					} else if (num1 == 6) {
						System.out.println("1竹東2湖口");
					} else if (num1 == 7) {
						System.out.println("1頭份2苗栗3三義");
					} else if (num1 == 8) {
						System.out.println("1豐原2沙鹿3大里4忠明5西屯");
					} else if (num1 == 9) {
						System.out.println("1彰化 2線西 3二林 4彰化(大城)");
					} else if (num1 == 10) {
						System.out.println("1南投 2竹山 3埔里");
					} else if (num1 == 11) {
						System.out.println("1斗六 2崙背 3臺西 4麥寮");
					} else if (num1 == 12) {
						System.out.println("1嘉義");
					} else if (num1 == 13) {
						System.out.println("1新港 2朴子");
					} else if (num1 == 14) {
						System.out.println("1新營2善化3安南4臺南5臺南(麻豆)6臺南(北門)");
					} else if (num1 == 15) {
						System.out.println("1橋頭2仁武3鳳山4大寮5林園6楠梓7左營8前金9前鎮10小港11美濃12復興");
					} else if (num1 == 16) {
						System.out.println("1屏東2潮州3恆春4屏東(琉球)");
					} else if (num1 == 17) {
						System.out.println("1花蓮");
					} else if (num1 == 18) {
						System.out.println("1臺東2關山");
					} else if (num1 == 19) {
						System.out.println("1宜蘭2冬山");
					} else if (num1 == 20) {
						System.out.println("1馬公 2澎湖");
					} else if (num1 == 21) {
						System.out.println("1馬祖 2連江");
					} else if (num1 == 22) {
						System.out.println("1金門");
					} else {
						System.out.println("輸入錯誤 請重新輸入");
					}
					System.out.println("請輸入地區");
					string1 = scanner.nextLine();
					string1 = scanner.nextLine();
					pstmt.setString(2, string1);
					System.out.println("請輸入更新PM2.5數值");
					string2 = scanner.nextLine();
					pstmt.setString(1, string2);
					System.out.println("確認是否修改\r\n" + "1確認  2取消");
					num1 = scanner.nextInt();
					if (num1 == 1) {
						pstmt.executeUpdate();
						pstmt.clearParameters();
						System.out.println("資料已修改");
					} else if (num1 == 2) {
						System.out.println("修改已取消");
					} else {
						System.out.println("輸入錯誤 請重新輸入");
					}
				}
				// 刪除資料
				else if (num3 == 5) {
					String string4 = null;
					Scanner scanner4 = new Scanner(System.in);
					PreparedStatement pstmt2 = connection.prepareStatement("delete from table1 where site=?");
					System.out.println("請輸入刪除的縣市" + "1臺北市  2新北市 3基隆市  4桃園市  5新竹市  6新竹縣  7苗栗縣  8台中市  9彰化縣 10南投縣11雲林縣\r\n"
							+ "12嘉義市13嘉義縣14臺南市15高雄市16屏東縣17台東縣18花蓮縣19宜蘭縣20澎湖縣21金門縣22連江縣 ");

					num1 = scanner4.nextInt();
					if (num1 == 1) {
						System.out.println("1大同 2士林 3中山 4萬華 5陽明");
					} else if (num1 == 2) {
						System.out.println("1菜寮 2淡水 3林口富貴角 4汐止 5萬里 6新店 7土城 8板橋 9永和 10新莊 11三重 12新北(樹林)");
					} else if (num1 == 3) {
						System.out.println("1基隆");
					} else if (num1 == 4) {
						System.out.println("1桃園 2大園 3觀音 4平鎮 5龍潭 6中壢 7桃園(觀音工業區)");
					} else if (num1 == 5) {
						System.out.println("1新竹市");
					} else if (num1 == 6) {
						System.out.println("1竹東2湖口");
					} else if (num1 == 7) {
						System.out.println("1頭份2苗栗3三義");
					} else if (num1 == 8) {
						System.out.println("1豐原2沙鹿3大里4忠明5西屯");
					} else if (num1 == 9) {
						System.out.println("1彰化 2線西 3二林 4彰化(大城)");
					} else if (num1 == 10) {
						System.out.println("1南投 2竹山 3埔里");
					} else if (num1 == 11) {
						System.out.println("1斗六 2崙背 3臺西 4麥寮");
					} else if (num1 == 12) {
						System.out.println("1嘉義");
					} else if (num1 == 13) {
						System.out.println("1新港 2朴子");
					} else if (num1 == 14) {
						System.out.println("1新營2善化3安南4臺南5臺南(麻豆)6臺南(北門)");
					} else if (num1 == 15) {
						System.out.println("1橋頭2仁武3鳳山4大寮5林園6楠梓7左營8前金9前鎮10小港11美濃12復興");
					} else if (num1 == 16) {
						System.out.println("1屏東2潮州3恆春4屏東(琉球)");
					} else if (num1 == 17) {
						System.out.println("1花蓮");
					} else if (num1 == 18) {
						System.out.println("1臺東2關山");
					} else if (num1 == 19) {
						System.out.println("1宜蘭2冬山");
					} else if (num1 == 20) {
						System.out.println("1馬公 2澎湖");
					} else if (num1 == 21) {
						System.out.println("1馬祖 2連江");
					} else if (num1 == 22) {
						System.out.println("1金門");
					} else {
						System.out.println("輸入錯誤 請重新輸入");
					}
					// 新增地區名單
					System.out.println("請輸入地區");
					// 新增一行nextLine() 因為nextInt()執行會回傳一個空白導致nextInt()被執行
					string4 = scanner4.nextLine();
					string4 = scanner4.nextLine();
					pstmt2.setString(1, string4);
					System.out.println("確認是否刪除\r\n" + "1確認  2取消");
					num1 = scanner.nextInt();
					if (num1 == 1) {
						pstmt2.executeUpdate();
						pstmt2.clearParameters();
						System.out.println("資料已刪除");
					}
					else if (num1 == 2) {
						System.out.println("刪除已取消");
					} else {
						System.out.println("輸入錯誤 請重新輸入");
					}
				}
				// 資料匯出
				else if (num3 == 6) {
					File file = new File("C:\\iii\\CsvReport\\reportPM25.csv");
					try (FileOutputStream fos = new FileOutputStream(file);
							OutputStreamWriter writer = new OutputStreamWriter(fos, "MS950");
							BufferedWriter bufferedWriter = new BufferedWriter(writer);) {

						System.out.println("是否確認匯出\r\n" + "1確認 2取消");
//				Scanner scanner = new Scanner(System.in);
						num13 = scanner.nextInt();
						if (num13 == 1) {

							String query = "select * from table1";
							ResultSet rs = stmt.executeQuery(query);

							StringBuilder builder = new StringBuilder();
							builder.append("Site").append(",").append("Country").append(",").append("PM2.5").append(",")
									.append("DataCreationDate").append(",").append("ItemUnit");
//				System.out.println(builder);

							while (rs.next()) {
								String site = rs.getString("site");
								String country = rs.getString("country");
								String pm25 = rs.getString("PM25");
								String DataCreationDate = rs.getString("DataCreationDate");
								builder.append(System.lineSeparator());
								builder.append(site).append(",");
								builder.append(country).append(",");
								builder.append(pm25).append(",");
								builder.append(DataCreationDate).append(",").append("μg/m3");
							}

//					System.out.println(builder.toString());
							bufferedWriter.write(builder.toString());
							System.out.println("資料已匯出");
						} else if (num13 == 2) {
							System.out.println("匯出已取消");
						} else {
							System.out.println("輸入錯誤 請重新輸入");
						}
						bufferedWriter.close();
						fos.close();
					}
					//程式關閉
				}else if (num3==7) {
					System.out.println("是否確認關閉\r\n" + "1確認 2取消");
					num1 = scanner.nextInt();
					if (num1==1) {
						System.out.println("程式已關閉");
						System.exit(0);
					}
					else if (num1==2) {
						System.out.println("關閉已取消");
					}
					else  {
						System.out.println("輸入錯誤 請重新輸入");
					}
					
					
				} else {
					System.out.println("輸入錯誤 請重新輸入");
				}

			} catch (SQLException e) {

// SQLSyntaxException繼承SQLException e無法再另外catch
				System.out.println("數值輸入錯誤 請重新輸入");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			catch (FileNotFoundException e) {
				// TODO: handle exception
				System.out.println("程序無法存取檔案，因為檔案正由另一個程序使用。");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("輸入錯誤 請重新輸入");
			}
//		

			System.out.println("");
			System.out.println("全部執行完畢");
			System.out.println("");
			System.out.println("按任意鍵返回主畫面");
			string7 = scanner5.nextLine();
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
	
		}
	}

}