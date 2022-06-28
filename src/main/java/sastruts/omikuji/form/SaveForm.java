package sastruts.omikuji.form;

import java.util.List;

import sastruts.omikuji.dto.SaveDto;

/**
 * SaveActionに関するフォームです。
 * @author h_kim
 * @version 1.0
 */


public class SaveForm {
	protected List <SaveDto> list;

	/**
	 * リストを受け取る。
	 * @return SaveDto形のリスト list
	 */
	public List<SaveDto> getList() {
		return list;
	}

	/**
	 * リストをセットする。
	 * @param list
	 */
	public void setList(List<SaveDto> list) {
		this.list = list;
	}
	
}
