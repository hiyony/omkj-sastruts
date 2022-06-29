package sastruts.omikuji.others;

/**
 * 運勢をセットします。
 * @author h_kim
 * @version 1.0
 */
public class Selectunsei {
	
	/**
	 * 六つの運勢中で一つをセットします。
	 * @param unseistr 運勢名
	 * @return 選択された運勢 fortune
	 */
	public static Unsei selectUnsei(String unseistr){
		Unsei fortune = null;
		
		switch (unseistr) {
		case "大吉":
			fortune = new Daikichi();
			break;
		case "中吉":
			fortune = new Cyuukichi();
			break;
		case "小吉":
			fortune = new Syoukichi();
			break;
		case "吉":
			fortune = new Kichi();
			break;
		case "末吉":
			fortune = new Sueyosi();
			break;
		case "凶":
			fortune = new Kyou();
			break;
		default:
			break;
			
		}
		return fortune;
	}
}
