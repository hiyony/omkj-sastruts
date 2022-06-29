package sastruts.omikuji.dto;

/**
 * データベースから受け取った内容を保存するDTOクラスです。
 * DTOクラス＝単純データ移送クラス。
 * 
 * @author h_kim
 * @version 1.0
 */

public class GetaddressDto {
	
	/** 郵便番号 */
	public String zipcode;
	
	/** 住所 */
	public String homeaddress;
	
	/**
	 * 郵便番号を受け取る。
	 * @return 郵便番号
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * 郵便番号をセットする。
	 * @param zipcode 郵便番号
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
	 * @param homeaddress 住所
	 */
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
}
