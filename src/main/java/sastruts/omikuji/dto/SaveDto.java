package sastruts.omikuji.dto;

/**
 * SaveActionに関するDTOです。
 * @author h_kim
 * @version 1.0
 */

public class SaveDto {
	public String name;
	public String zipcode;
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
	 * @return zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * 値をセットする。
	 * @param zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
