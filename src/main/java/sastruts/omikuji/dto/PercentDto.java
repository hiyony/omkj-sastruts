package sastruts.omikuji.dto;

import java.io.Serializable;

/**
 * PercentActionに関するDTOです。
 * @author h_kim
 * @version 1.0
 */

public class PercentDto implements Serializable{
	
	/**
	 * 値を受け取る。
	 * @return fortunecode
	 */
	public String getFortunecode() {
		return fortunecode;
	}
	
	/**
	 * 値をセットする。
	 * @param fortunecode
	 */
	public void setFortunecode(String fortunecode) {
		this.fortunecode = fortunecode;
	}
	
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

	public String fortunecode;
	public String fortunename;
	public Integer fortunecount;
	public Integer totalpercent;

	/**
	 * コンストラクタ宣言
	 */
	public PercentDto() {
		super();
	}
	
	/**
	 * コンストラクタオーバーロード
	 * @param fortunecode
	 * @param fortunename
	 * @param fortunecount
	 * @param totalpercent
	 */
	public PercentDto(String fortunecode, String fortunename, Integer fortunecount, Integer totalpercent) {
		super();
		this.fortunecode = fortunecode;
		this.fortunename = fortunename;
		this.fortunecount = fortunecount;
		this.totalpercent = totalpercent;
	}
}
