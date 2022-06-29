package sastruts.omikuji.dto;

/**
 * 入力された個人情報を保存するDTOクラスです。
 * DTOクラス＝単純データ移送クラス。
 * 
 * @author h_kim
 * @version 1.0
 */
public class SaveDto {
	
	/** 名前 */
	public String name;
	
	/** 郵便番号 */
	public String zipcode;
	
	/** 住所 */
	public String homeaddress;
	
	/** メールアドレス */
	public String emailaddress;
	
	/**
	 * 名前を受け取る。
	 * @return 名前
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 名前をセットする。
	 * @param name　名前
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 郵便番号を受け取る。
	 * @return 郵便番号
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * 郵便番号をセットする。
	 * @param zipcode　郵便番号
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * 住所を受け取る。
	 * @return 住所
	 */
	public String getHomeaddress() {
		return homeaddress;
	}
	
	/**
	 * 住所をセットする。
	 * @param homeaddress　住所
	 */
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}	
	
	/**
	 * メールアドレスを受け取る。
	 * @return メールアドレス
	 */
	public String getEmailaddress() {
		return emailaddress;
	}
	
	/**
	 * メールアドレスをセットする。
	 * @param emailaddress　メールアドレス
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
}
