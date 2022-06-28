package sastruts.omikuji.dto;

import java.io.Serializable;

/**
 * HalfActionに関するDTOです。
 * @author h_kim
 * @version 1.0
 */

public class HalfDto implements Serializable{
	
	/**
	 * 値を受け取る。
	 * @return uranaidate
	 */
	public String getUranaidate() {
		return uranaidate;
	}
	
	/**
	 * 値をセットする。
	 * @param uranaidate
	 */
	public void setUranaidate(String uranaidate) {
		this.uranaidate = uranaidate;
	}
	
	/**
	 * 値を受け取る。
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * 値をセットする。
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 値を受け取る。
	 * @return omikujicode
	 */
	public String getOmikujicode() {
		return omikujicode;
	}
	
	/**
	 * 値をセットする。
	 * @param omikujicode
	 */
	public void setOmikujicode(String omikujicode) {
		this.omikujicode = omikujicode;
	}
	
	/**
	 * 値を受け取る。
	 * @return renewalwriter
	 */
	public String getRenewalwriter() {
		return renewalwriter;
	}
	
	/**
	 * 値をセットする。
	 * @param renewalwriter
	 */
	public void setRenewalwriter(String renewalwriter) {
		this.renewalwriter = renewalwriter;
	}
	
	/**
	 * 値を受け取る。
	 * @return renewaldate
	 */
	public String getRenewaldate() {
		return renewaldate;
	}
	
	/**
	 * 値をセットする。
	 * @param renewaldate
	 */
	public void setRenewaldate(String renewaldate) {
		this.renewaldate = renewaldate;
	}
	
	/**
	 * 値を受け取る。
	 * @return unseiwriter
	 */
	public String getUnseiwriter() {
		return unseiwriter;
	}
	
	/**
	 * 値をセットする。
	 * @param unseiwriter
	 */
	public void setUnseiwriter(String unseiwriter) {
		this.unseiwriter = unseiwriter;
	}
	
	/**
	 * 値を受け取る。
	 * @return unseiwritedate
	 */
	public String getUnseiwritedate() {
		return unseiwritedate;
	}
	
	/**
	 * 値をセットする。
	 * @param unseiwritedate
	 */
	public void setUnseiwritedate(String unseiwritedate) {
		this.unseiwritedate = unseiwritedate;
	}

	private String uranaidate;
	private String birthday;
	private String omikujicode;
	private String renewalwriter;
	private String renewaldate;
	private String unseiwriter;
	private String unseiwritedate;
	
	/**
	 * コンストラクタ宣言
	 */
	public HalfDto(){
		super();
	}
	
	/**
	 * コンストラクタオーバーロード
	 * @param uranaidate
	 * @param birthday
	 * @param omikujicode
	 * @param renewalwriter
	 * @param renewaldate
	 * @param unseiwriter
	 * @param unseiwritedate
	 */
	public HalfDto(String uranaidate, String birthday, String omikujicode, String renewalwriter, String renewaldate, 
			String unseiwriter, String unseiwritedate){
		super();
		this.uranaidate = uranaidate;
		this.birthday = birthday;
		this.omikujicode = omikujicode;
		this.renewalwriter = renewalwriter;
		this.renewaldate = renewaldate;
		this.unseiwriter = unseiwriter;
		this.unseiwritedate = unseiwritedate;
	}
	
	

}
