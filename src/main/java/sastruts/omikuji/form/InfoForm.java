package sastruts.omikuji.form;

import java.io.Serializable;

/**
 * InfoActionに関するフォームです。
 * @author h_kim
 * @version 1.0
 */


public class InfoForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	public String postnumber;
	public String homeaddress;
	public String emailaddress;
	public String fulladdress;
	
	/**
	 * 値を受け取る。
	 * @return fulladdress
	 */
	public String getFulladdress() {
		return fulladdress;
	}
	
	/**
	 * 値をセットする。
	 * @param fulladdress
	 */
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	
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
	 * @return emailaddress
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
