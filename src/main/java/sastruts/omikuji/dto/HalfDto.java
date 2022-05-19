package sastruts.omikuji.dto;

import java.io.Serializable;

public class HalfDto implements Serializable{
	
	public String getUranaidate() {
		return uranaidate;
	}

	public void setUranaidate(String uranaidate) {
		this.uranaidate = uranaidate;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getOmikujicode() {
		return omikujicode;
	}

	public void setOmikujicode(String omikujicode) {
		this.omikujicode = omikujicode;
	}

	public String getRenewalwriter() {
		return renewalwriter;
	}

	public void setRenewalwriter(String renewalwriter) {
		this.renewalwriter = renewalwriter;
	}

	public String getRenewaldate() {
		return renewaldate;
	}

	public void setRenewaldate(String renewaldate) {
		this.renewaldate = renewaldate;
	}

	public String getUnseiwriter() {
		return unseiwriter;
	}

	public void setUnseiwriter(String unseiwriter) {
		this.unseiwriter = unseiwriter;
	}

	public String getUnseiwritedate() {
		return unseiwritedate;
	}

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
	
	public HalfDto(){
		super();
	}
	
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
