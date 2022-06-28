package sastruts.omikuji.form;

import java.io.Serializable;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.others.Checkbirthday;

/**
 * InputActionに関するフォームです。
 * @author h_kim
 * @version 1.0
 */


public class InputForm implements Serializable{
	@SuppressWarnings("unused")
	private static final long serialVerisionUID = 1L;
	
	@Required
	public String birthday;
	
	/**
	 * 値を受け取る。
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 値をセットする。
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 条件と違う場合エラーメッセージを表示する。
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
