package sastruts.omikuji.form;

import java.io.Serializable;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.others.Checkbirthday;

/**
 * 初期画面から入力された値を保存するフォームクラスです。
 * 
 * @author h_kim
 * @version 1.0
 */
public class InputForm implements Serializable{
	
	/** 直列化 */
	@SuppressWarnings("unused")
	private static final long serialVerisionUID = 1L;
	
	/** 誕生日 */
	@Required
	public String birthday;
	
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
	 * 条件(yyyyMMdd方式)と違う場合エラーメッセージを表示する。
	 * @return エラーメッセージ errors
	 */
	public ActionErrors validate() {
		
		ActionErrors errors = new ActionErrors();
		Boolean checkbday = Checkbirthday.checkbday(birthday);
		
		if(checkbday.equals(false)) {
			errors.add("", new ActionMessage("errmsg.num", "Error"));
		}
		
		return errors;
	}
}
