package sastruts.omikuji.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;

import sastruts.omikuji.service.PostinfoService;

public class AddressAction {
	
	@Resource
	protected PostinfoService postinfoService;

	@Resource
	protected HttpServletRequest request;
	
	@Resource
	protected HttpServletResponse response;
	
	@Execute(validator = false)
	public String address() {
		
		return "address.jsp";
	}
}
