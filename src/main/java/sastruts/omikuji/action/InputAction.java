package sastruts.omikuji.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.form.InputForm;

public class InputAction {
	@Required
	@ActionForm
	protected InputForm inputform;
	
	@Resource
	protected HttpSession session;
	
	@Execute(validator = false)
	public String index() {
		
		return "index.jsp";
	}
	
	@Execute(validator = true, validate = "validate", input = "index.jsp")
	public String output() {
		//return "output.jsp";
		return "/output/";
	}
	

}
