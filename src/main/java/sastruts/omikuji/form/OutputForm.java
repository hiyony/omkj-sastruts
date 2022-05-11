package sastruts.omikuji.form;

import java.io.Serializable;

public class OutputForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void setUnsei(){
	
	}
	public static String getUnsei() {
		return unsei;
	}
	public static void setUnsei(String unsei) {
		OutputForm.unsei = unsei;
	}
	public static String getNegaigoto() {
		return negaigoto;
	}
	public static void setNegaigoto(String negaigoto) {
		OutputForm.negaigoto = negaigoto;
	}
	public static String getAkinai() {
		return akinai;
	}
	public static void setAkinai(String akinai) {
		OutputForm.akinai = akinai;
	}
	public static String getGakumon() {
		return gakumon;
	}
	public static void setGakumon(String gakumon) {
		OutputForm.gakumon = gakumon;
	}
	
	protected static String unsei;
	protected static String negaigoto;
	protected static String akinai;
	protected static String gakumon;
	protected String omikujicode;
	
	
}
