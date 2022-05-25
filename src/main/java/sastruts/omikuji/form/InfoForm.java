package sastruts.omikuji.form;

import java.io.Serializable;

public class InfoForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	public String postnumber;
	public String homeaddress;
	public String emailaddress;
	public String fulladdress;
	
	public String getFulladdress() {
		return fulladdress;
	}
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostnumber() {
		return postnumber;
	}
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}
	public String getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	
}
