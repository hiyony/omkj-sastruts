package sastruts.omikuji.dto;

public class PercentResDto {

	public String getFortunename() {
		return fortunename;
	}
	public void setFortunename(String fortunename) {
		this.fortunename = fortunename;
	}
	public Integer getFortunecount() {
		return fortunecount;
	}
	public void setFortunecount(Integer fortunecount) {
		this.fortunecount = fortunecount;
	}
	public Integer getTotalpercent() {
		return totalpercent;
	}
	public void setTotalpercent(Integer totalpercent) {
		this.totalpercent = totalpercent;
	}
	
	private Integer fortunecount;
	private Integer totalpercent;
	private String fortunename;
	

}
