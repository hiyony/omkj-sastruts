package sastruts.omikuji.form;

import java.util.List;

import sastruts.omikuji.dto.PercentResDto;

/**
 * PercentActionに関するフォームです。
 * @author h_kim
 * @version 1.0
 */


public class PercentForm {
	
	protected List <PercentResDto> perresultlist;
	
	/**
	 * リストを受け取る。
	 * @return PercentResDto形のリスト perresultlist
	 */
	public List<PercentResDto> getPerresultlist() {
		return perresultlist;
	}

	/**
	 * リストをセットする。
	 * @param perresultlist
	 */
	public void setPerresultlist(List<PercentResDto> perresultlist) {
		this.perresultlist = perresultlist;
	}

}
