package sastruts.omikuji.form;

import java.util.List;

import sastruts.omikuji.dto.HalfDto;

/**
 * HalfActionに関するフォームです。
 * @author h_kim
 * @version 1.0
 */

public class HalfForm {
	
	protected List <HalfDto> hfresultlist;
	
	/**
	 * リストを受け取る。
	 * @return HalfDto形のリスト　hfresultlist
	 */
	public List<HalfDto> getHfresultlist() {
		return hfresultlist;
	}
	
	/**
	 * リストをセットする。
	 * @param hfresultlist
	 */
	public void setHfresultlist(List<HalfDto> hfresultlist) {
		this.hfresultlist = hfresultlist;
	}
	
}
