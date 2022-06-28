package sastruts.omikuji.others;

import java.text.SimpleDateFormat;

/**
 * 誕生日をチェックします。
 * @author h_kim
 * @version1.0
 */

public class Checkbirthday {
	
	/**
	 * 正しい形式(yyyyMMdd)で入力するかチェックします。
	 * @param bday
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
