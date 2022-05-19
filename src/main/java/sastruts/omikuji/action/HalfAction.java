package sastruts.omikuji.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.dto.HalfDto;
import sastruts.omikuji.form.HalfForm;

public class HalfAction {
	
	@Required
	@ActionForm
	protected HalfForm halfForm;
	
	@Resource
	protected HttpServletRequest request;
	
	@Execute(validator = false)
	public String half() {
		
		String birthday = request.getParameter("birthday");
		
		List <HalfDto> list = new ArrayList <HalfDto>();
		
		return "half.jsp";
	}

}
