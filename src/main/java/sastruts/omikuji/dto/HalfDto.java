package sastruts.omikuji.dto;

import java.io.Serializable;

/**
 * 
 * 占い結果をリストで表示する内容を保持するDTOクラスです。
 * DTOクラス＝単純データ移送クラス。
 * 
 * @author h_kim
 * @version 1.0
 */
public class HalfDto implements Serializable{
	
	/** 占い日 */
	private String uranaidate;
	/** 誕生日 */
	private String birthday;
	/** おみくじコード */
	private String omikujicode;
	/** 更新者 */
	private String renewalwriter;
	/** 更新日 */
	private String renewaldate;
	/** 登録日 */
	private String unseiwriter;
	/** 登録日 */
	private String unseiwritedate;
	
	/**
	 * デフォルトコンストラクタ。
	 * 親のデフォルトコンストラクタを呼び出す。
	 */
	public HalfDto(){
		super();
	}
	
	/**
	 * コンストラクタオーバーロード (値の初期設定)。
	 * 初期化時点で、引数で受け取った値を設定する。
	 * 
	 * @param uranaidate　占い日
	 * @param birthday　誕生日
	 * @param omikujicode　おみくじコード
	 * @param renewalwriter　更新者
	 * @param renewaldate　更新日
	 * @param unseiwriter　登録者
	 * @param unseiwritedate　登録日
	 */
	public HalfDto(String uranaidate, String birthday, String omikujicode, String renewalwriter, String renewaldate, 
			String unseiwriter, String unseiwritedate){
		super();
		this.uranaidate = uranaidate;
		this.birthday = birthday;
		this.omikujicode = omikujicode;
		this.renewalwriter = renewalwriter;
		this.renewaldate = renewaldate;
		this.unseiwriter = unseiwriter;
		this.unseiwritedate = unseiwritedate;
	}

	/**
	 * 占い日を受け取る。
	 * @return 占い日
	 */
	public String getUranaidate() {
		return uranaidate;
	}
	
	/**
	 * 占い日をセットする。
	 * @param uranaidate　占い日
	 */
	public void setUranaidate(String uranaidate) {
		this.uranaidate = uranaidate;
	}
	
	/**
	 * 誕生日を受け取る。
	 * @return 誕生日
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * 誕生日をセットする。
	 * @param birthday　誕生日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * おみくじコードを受け取る。
	 * @return おみくじコード
	 */
	public String getOmikujicode() {
		return omikujicode;
	}
	
	/**
	 * おみくじコードをセットする。
	 * @param omikujicode　おみくじコード
	 */
	public void setOmikujicode(String omikujicode) {
		this.omikujicode = omikujicode;
	}
	
	/**
	 * 更新者を受け取る。
	 * @return 更新者
	 */
	public String getRenewalwriter() {
		return renewalwriter;
	}
	
	/**
	 * 更新者をセットする。
	 * @param renewalwriter　更新者
	 */
	public void setRenewalwriter(String renewalwriter) {
		this.renewalwriter = renewalwriter;
	}
	
	/**
	 * 更新日を受け取る。
	 * @return 更新日
	 */
	public String getRenewaldate() {
		return renewaldate;
	}
	
	/**
	 * 更新日をセットする。
	 * @param renewaldate　更新日
	 */
	public void setRenewaldate(String renewaldate) {
		this.renewaldate = renewaldate;
	}
	
	/**
	 * 登録者を受け取る。
	 * @return 登録者
	 */
	public String getUnseiwriter() {
		return unseiwriter;
	}
	
	/**
	 * 登録者をセットする。
	 * @param unseiwriter　登録者
	 */
	public void setUnseiwriter(String unseiwriter) {
		this.unseiwriter = unseiwriter;
	}
	
	/**
	 * 登録日を受け取る。
	 * @return 登録日
	 */
	public String getUnseiwritedate() {
		return unseiwritedate;
	}
	
	/**
	 * 登録日をセットする。
	 * @param unseiwritedate　登録日
	 */
	public void setUnseiwritedate(String unseiwritedate) {
		this.unseiwritedate = unseiwritedate;
	}	
	

}
