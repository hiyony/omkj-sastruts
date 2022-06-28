package sastruts.omikuji.form;

import java.io.Serializable;

/**
 * OutputActionに関するフォームです。
 * @author h_kim
 * @version 1.0
 */


public class OutputForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void setUnsei(){
	
	}
	
	/**
	 * 値を受け取る。
	 * @return unsei
	 */
	public String getUnsei() {
		return unsei;
	}
	
	/**
	 * 値をセットする。
	 * @param unsei
	 */
	public void setUnsei(String unsei) {
		this.unsei = unsei;
	}
	
	/**
	 * 値を受け取る。
	 * @return negaigoto
	 */
	public String getNegaigoto() {
		return negaigoto;
	}
	
	/**
	 * 値をセットする。
	 * @param negaigoto
	 */
	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}
	
	/**
	 * 値を受け取る。
	 * @return akinai
	 */
	public String getAkinai() {
		return akinai;
	}
	
	/**
	 * 値をセットする。
	 * @param akinai
	 */
	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}
	
	/**
	 * 値を受け取る。
	 * @return gakumon
	 */
	public String getGakumon() {
		return gakumon;
	}
	
	/**
	 * 値をセットする。
	 * @param gakumon
	 */
	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}
	
	protected String unsei;
	protected String negaigoto;
	protected String akinai;
	protected String gakumon;
	protected String omikujicode;
	
	public String name;
	public String postnumber;
	public String homeaddress;
	public String emailaddress;

	/**
	 * 値を受け取る。
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 値をセットする。
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 値を受け取る。
	 * @return postnumber
	 */
	public String getPostnumber() {
		return postnumber;
	}
	
	/**
	 * 値をセットする。
	 * @param postnumber
	 */
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}
	
	/**
	 * 値を受け取る。
	 * @return homeaddress
	 */
	public String getHomeaddress() {
		return homeaddress;
	}
	
	/**
	 * 値をセットする。
	 * @param homeaddress
	 */
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	
	/**
	 * 値を受け取る。
	 * @return emailadress
	 */
	public String getEmailaddress() {
		return emailaddress;
	}
	
	/**
	 * 値をセットする。
	 * @param emailaddress
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
}
