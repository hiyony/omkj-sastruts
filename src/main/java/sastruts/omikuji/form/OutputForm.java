package sastruts.omikuji.form;

import java.io.Serializable;

public class OutputForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void setUnsei(){
	
	}
	public String getUnsei() {
		return unsei;
	}
	public void setUnsei(String unsei) {
		this.unsei = unsei;
	}
	public String getNegaigoto() {
		return negaigoto;
	}
	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}
	public String getAkinai() {
		return akinai;
	}
	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}
	public String getGakumon() {
		return gakumon;
	}
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
