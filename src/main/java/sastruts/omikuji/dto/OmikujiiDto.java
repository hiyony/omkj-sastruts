package sastruts.omikuji.dto;

public class OmikujiiDto {

	private String omikuji;
	private String unseicode;
	private String negaigoto;
	private String akinai;
	private String gakumon;

	public String getOmikuji() {
		return omikuji;
	}

	public void setOmikuji(String omikuji) {
		this.omikuji = omikuji;
	}

	public String getUnseicode() {
		return unseicode;
	}

	public void setUnseicode(String unseicode) {
		this.unseicode = unseicode;
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