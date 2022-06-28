package sastruts.omikuji.dto;

/**
 * PercentActionに関するDTOです。s
 * @author h_kim
 * @version 1.0
 */

public class PercentResDto {
	
	/**
	 * 値を受け取る。
	 * @return fortunename
	 */
	public String getFortunename() {
		return fortunename;
	}
	
	/**
	 * 値をセットする。
	 * @param fortunename
	 */
	public void setFortunename(String fortunename) {
		this.fortunename = fortunename;
	}
	
	/**
	 * 値を受け取る。
	 * @return fortunecount
	 */
	public Integer getFortunecount() {
		return fortunecount;
	}
	
	/**
	 * 値をセットする。
	 * @param fortunecount
	 */
	public void setFortunecount(Integer fortunecount) {
		this.fortunecount = fortunecount;
	}
	
	/**
	 * 値を受け取る。
	 * @return totalpercent
	 */
	public Integer getTotalpercent() {
		return totalpercent;
	}
	
	/**
	 * 値をセットする。
	 * @param totalpercent
	 */
	public void setTotalpercent(Integer totalpercent) {
		this.totalpercent = totalpercent;
	}
	
	private Integer fortunecount;
	private Integer totalpercent;
	private String fortunename;
	

}
