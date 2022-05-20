package sastruts.omikuji.dto;

import java.io.Serializable;

public class PercentDto implements Serializable{
	
	private String unseiname;
	private Integer cnt;
	private Integer per;
	
	public String getUnseiname() {
		return unseiname;
	}

	public void setUnseiname(String unseiname) {
		this.unseiname = unseiname;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public Integer getPer() {
		return per;
	}

	public void setPer(Integer per) {
		this.per = per;
	}

	public PercentDto() {
		super();
	}
	
	public PercentDto(String unseiname, Integer cnt, Integer per) {
		super();
		this.unseiname = unseiname;
		this.cnt = cnt;
		this.per = per;
	}
}
