package sastruts.omikuji.dto;

/**
 * Omikujiiテーブルのデータを受け取るDTOです。
 * DTOクラス＝単純データ移送クラス。
 * 
 * @author h_kim
 * @version 1.0
 */

public class OmikujiiDto {

	/** 運勢名 */
	private String omikuji;
	
	/** 運勢コード */
	private String unseicode;
	
	/** 願い事 */
	private String negaigoto;
	
	/** 商い */
	private String akinai;
	
	/** 学問 */
	private String gakumon;

	/**
	 * 運勢名を受け取る。
	 * @return 運勢名
	 */
	public String getOmikuji() {
		return omikuji;
	}

	/**
	 * 運勢名をセットする。
	 * @param omikuji　運勢名
	 */
	public void setOmikuji(String omikuji) {
		this.omikuji = omikuji;
	}

	/**
	 * 運勢コードを受け取る。
	 * @return 運勢コード
	 */
	public String getUnseicode() {
		return unseicode;
	}

	/**
	 * 運勢コードをセットする。
	 * @param unseicode　運勢コード
	 */
	public void setUnseicode(String unseicode) {
		this.unseicode = unseicode;
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
	 * @param negaigoto 願い事
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
	 * オーバーライドする。
	 * Stringフォマットでおみくじの結果を取得する。
	 * 
	 * @return Stringフォマットの結果
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OmikujiiDto [omikujicode=");
		builder.append(omikuji);
		builder.append(", unsei=");
		builder.append(unseicode);
		builder.append(", negaigoto=");
		builder.append(negaigoto);
		builder.append(", akinai=");
		builder.append(akinai);
		builder.append(", gakumon=");
		builder.append(gakumon);
		builder.append("]");
		return builder.toString();
	}

}