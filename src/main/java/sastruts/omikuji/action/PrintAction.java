package sastruts.omikuji.action;

import org.seasar.struts.annotation.Execute;

public class PrintAction {
	@Execute(validator = false)
	public String print(){
		return "print.jsp";
	}
}
