package sastruts.omikuji.dto;

/**
 * GetAddressActionに関するDTOです。
 * @author h_kim
 * @version 1.0
 */

public class GetaddressDto {
	public String zipcode;
	public String homeaddress;
	
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
}
