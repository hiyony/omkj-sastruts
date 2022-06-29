package sastruts.omikuji.dto;

/**
 * おみくじ結果の割合をリストで表示する内容を保存するDTOクラスです。
 * DTOクラス＝単純データ移送クラス。
 * 
 * @author h_kim
 * @version 1.0
 */

public class PercentResDto {
	
	/** 運勢数 */
	private Integer fortunecount;
	
	/** 割合 */
	private Integer totalpercent;
	
	/** 運勢名 */
	private String fortunename;
	
	
	/**
	 * 運勢名を受け取る。
	 * @return 運勢名
	 */
	public String getFortunename() {
		return fortunename;
	}
	
	/**
	 * 運勢名をセットする。
	 * @param fortunename　運勢名
	 */
	public void setFortunename(String fortunename) {
		this.fortunename = fortunename;
	}
	
	/**
	 * 運勢数を受け取る。
	 * @return 運勢数
	 */
	public Integer getFortunecount() {
		return fortunecount;
	}
	
	/**
	 * 運勢数をセットする。
	 * @param fortunecount　運勢数
	 */
	public void setFortunecount(Integer fortunecount) {
		this.fortunecount = fortunecount;
	}
	
	/**
	 * 割合を受け取る。
	 * @return 割合
	 */
	public Integer getTotalpercent() {
		return totalpercent;
	}
	
	/**
	 * 割合をセットする。
	 * @param totalpercent　割合
	 */
	public void setTotalpercent(Integer totalpercent) {
		this.totalpercent = totalpercent;
	}


}
