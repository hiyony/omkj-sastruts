package sastruts.omikuji.others;

import java.text.SimpleDateFormat;

/**
 * 誕生日をチェックするクラスです。
 * 
 * @author h_kim
 * @version1.0
 */

public class Checkbirthday {
	
	/**
	 * 正しい方式(yyyyMMdd)で入力されているかをチェックします。
	 * 
	 * @param bday　誕生日
	 * @return boolean
	 */
	public static Boolean checkbday(String bday) {
		while(true) {
			SimpleDateFormat datefp;
			
			try {
				datefp = new SimpleDateFormat("yyyyMMdd");
				datefp.setLenient(false);
				datefp.parse(bday);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}
