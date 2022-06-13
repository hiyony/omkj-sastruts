package sastruts.omikuji.dto;

public class GetaddressDto {
	private String zipcode;
	private String homeaddress1;
	private String homeaddress2;
	private String homeaddress3;
	
	public GetaddressDto(String zipcode, String homeaddress1, String homeaddress2, String homeaddress3){
		this.zipcode = zipcode;
		this.homeaddress1 = homeaddress1;
		this.homeaddress2 = homeaddress2;
		this.homeaddress3 = homeaddress3;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getHomeaddress1() {
		return homeaddress1;
	}

	public void setHomeaddress1(String homeaddress1) {
		this.homeaddress1 = homeaddress1;
	}

	public String getHomeaddress2() {
		return homeaddress2;
	}

	public void setHomeaddress2(String homeaddress2) {
		this.homeaddress2 = homeaddress2;
	}

	public String getHomeaddress3() {
		return homeaddress3;
	}

	public void setHomeaddress3(String homeaddress3) {
		this.homeaddress3 = homeaddress3;
	}
	
	
}
