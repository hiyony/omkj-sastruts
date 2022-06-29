package sastruts.omikuji.form;

import java.io.Serializable;

/**
 * おみくじの結果と入力された個人情報を保存するフォームクラスです。
 * 
 * @author h_kim
 * @version 1.0
 */
public class OutputForm implements Serializable{

	/** 直列化 */
	private static final long serialVersionUID = 1L;
	
	/** 運勢名 */
	protected String unsei;
	
	/** 願い事 */
	protected String negaigoto;
	
	/** 商い */
	protected String akinai;
	
	/** 学問 */
	protected String gakumon;
	
	/** おみくじコード */
	protected String omikujicode;

	/** 名前 */
	public String name;
	
	/** 郵便番号 */
	public String postnumber;
	
	/** 住所 */
	public String homeaddress;
	
	/** メールアドレス */
	public String emailaddress;

	
	public void setUnsei(){}
	
	/**
	 * 運勢名を受け取る。
	 * @return 運勢名
	 */
	public String getUnsei() {
		return unsei;
	}
	
	/**
	 * 運勢名をセットする。
	 * @param unsei　運勢名
	 */
	public void setUnsei(String unsei) {
		this.unsei = unsei;
	}
	
	/**
	 * 願い事を受け取る。
	 * @return 願い事
	 */
	public String getNegaigoto() {
		return negaigoto;
	}
	
	/**
	 * 願い事をセットする。
	 * @param negaigoto　願い事
	 */
	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}
	
	/**
	 * 商いを受け取る。
	 * @return 商い
	 */
	public String getAkinai() {
		return akinai;
	}
	
	/**
	 * 商いをセットする。
	 * @param akinai　商い
	 */
	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}
	
	/**
	 * 学問を受け取る。
	 * @return 学問
	 */
	public String getGakumon() {
		return gakumon;
	}
	
	/**
	 * 学問をセットする。
	 * @param gakumon　学問
	 */
	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}

	/**
	 * 名前を受け取る。
	 * @return 名前
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 名前をセットする。
	 * @param name　名前
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 郵便番号を受け取る。
	 * @return 郵便番号
	 */
	public String getPostnumber() {
		return postnumber;
	}
	
	/**
	 * 郵便番号をセットする。
	 * @param postnumber　郵便番号
	 */
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}
	
	/**
	 * 住所を受け取る。
	 * @return 住所
	 */
	public String getHomeaddress() {
		return homeaddress;
	}
	
	/**
	 * 住所をセットする。
	 * @param homeaddress　住所
	 */
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	
	/**
	 * メールアドレスを受け取る。
	 * @return メールアドレス
	 */
	public String getEmailaddress() {
		return emailaddress;
	}
	
	/**
	 * メールアドレスをセットする。
	 * @param emailaddress　メールアドレス
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
}
