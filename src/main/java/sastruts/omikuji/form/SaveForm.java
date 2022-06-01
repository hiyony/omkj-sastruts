package sastruts.omikuji.form;

import java.util.List;

import sastruts.omikuji.dto.SaveDto;

public class SaveForm {
	protected List <SaveDto> list;

	public List<SaveDto> getList() {
		return list;
	}

	public void setList(List<SaveDto> list) {
		this.list = list;
	}
	
}
