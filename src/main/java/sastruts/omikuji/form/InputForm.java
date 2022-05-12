package sastruts.omikuji.form;

import java.io.Serializable;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.others.Checkbirthday;

public class InputForm implements Serializable{
	@SuppressWarnings("unused")
	private static final long serialVerisionUID = 1L;
	
	@Required
	public String birthday;

	public ActionErrors validate() {
		
		ActionErrors errors = new ActionErrors();
		Boolean checkbday = Checkbirthday.checkbday(birthday);
		
		if(checkbday.equals(false)) {
			errors.add("", new ActionMessage("errmsg.num", "Error! "));
		}
		
		return errors;
	}
}
