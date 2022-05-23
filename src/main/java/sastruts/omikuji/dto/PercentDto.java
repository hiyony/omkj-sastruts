package sastruts.omikuji.dto;

import java.io.Serializable;

public class PercentDto implements Serializable{
	
	public String getFortunecode() {
		return fortunecode;
	}

	public void setFortunecode(String fortunecode) {
		this.fortunecode = fortunecode;
	}

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

	public String fortunecode;
	public String fortunename;
	public Integer fortunecount;
	public Integer totalpercent;


	public PercentDto() {
		super();
	}
	
	public PercentDto(String fortunecode, String fortunename, Integer fortunecount, Integer totalpercent) {
		super();
		this.fortunecode = fortunecode;
		this.fortunename = fortunename;
		this.fortunecount = fortunecount;
		this.totalpercent = totalpercent;
	}
}
