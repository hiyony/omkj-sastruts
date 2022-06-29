package sastruts.omikuji.dto;

import java.io.Serializable;

/**
 * おみくじ結果の割合と数を保存するDTOクラスです。
 * DTOクラス＝単純データ移送クラス。
 * 
 * @author h_kim
 * @version 1.0
 */

public class PercentDto implements Serializable{
	
	/**　運勢コード */
	public String fortunecode;
	
	/** 運勢名　*/
	public String fortunename;
	
	/** 運勢数　*/
	public Integer fortunecount;
	
	/** 割合 */
	public Integer totalpercent;

	/**
	 * でフォルトコンストラクタ。
	 * 親のでフォルトコンストラクタを呼び出す。
	 */
	public PercentDto() {
		super();
	}
	
	/**
	 * コンストラクタオーバーロード(値の初期設定)。
	 * 初期化時点で、引数で受け取った値を設定する。
	 * 
	 * @param fortunecode　運勢コード
	 * @param fortunename　運勢名
	 * @param fortunecount　運勢数
	 * @param totalpercent　割合
	 */
	public PercentDto(String fortunecode, String fortunename, Integer fortunecount, Integer totalpercent) {
		super();
		this.fortunecode = fortunecode;
		this.fortunename = fortunename;
		this.fortunecount = fortunecount;
		this.totalpercent = totalpercent;
	}
	
	
	/**
	 * 運勢コードを受け取る。
	 * @return 運勢コード
	 */
	public String getFortunecode() {
		return fortunecode;
	}
	
	/**
	 * 運勢コードをセットする。
	 * @param fortunecode　運勢コード
	 */
	public void setFortunecode(String fortunecode) {
		this.fortunecode = fortunecode;
	}
	
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
