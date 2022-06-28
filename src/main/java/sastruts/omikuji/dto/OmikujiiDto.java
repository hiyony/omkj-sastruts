package sastruts.omikuji.dto;

/**
 * OmikujiiテーブルからのDTOです。
 * @author h_kim
 * @version 1.0
 */

public class OmikujiiDto {

	private String omikuji;
	private String unseicode;
	private String negaigoto;
	private String akinai;
	private String gakumon;

	/**
	 * 値を受け取る。
	 * @return omikuji
	 */
	public String getOmikuji() {
		return omikuji;
	}

	/**
	 * 値をセットする。
	 * @param omikuji
	 */
	public void setOmikuji(String omikuji) {
		this.omikuji = omikuji;
	}

	/**
	 * 値を受け取る。
	 * @return unseicode
	 */
	public String getUnseicode() {
		return unseicode;
	}

	/**
	 * 値をセットする。
	 * @param unseicode
	 */
	public void setUnseicode(String unseicode) {
		this.unseicode = unseicode;
	}

	/**
	 * 値を受け取る。
	 * @return negaigoto
	 */
	public String getNegaigoto() {
		return negaigoto;
	}

	/**
	 * 値をセットする。
	 * @param negaigoto
	 */
	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}

	/**
	 * 値を受け取る。
	 * @return akinai
	 */
	public String getAkinai() {
		return akinai;
	}

	/**
	 * 値をセットする。
	 * @param akinai
	 */
	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}

	/**
	 * 値を受け取る。
	 * @return gakumon
	 */
	public String getGakumon() {
		return gakumon;
	}

	/**
	 * 値をセットする。
	 * @param gakumon
	 */
	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}

	/**
	 * オーバーライドする。
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