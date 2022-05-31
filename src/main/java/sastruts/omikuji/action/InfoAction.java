package sastruts.omikuji.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.dto.InfoDto;
import sastruts.omikuji.entity.Postinfo;
import sastruts.omikuji.form.InfoForm;
import sastruts.omikuji.form.OutputForm;
import sastruts.omikuji.service.PostinfoService;

public class InfoAction {
	@Required
	@ActionForm
	protected InfoForm infoForm;
	
	@ActionForm
	protected OutputForm outputForm;
	
	@Resource
	protected PostinfoService postinfoService;
	
	@Resource
	protected HttpServletRequest request;
	
	@Resource 
	protected HttpServletResponse response;
	
	@Execute(validator = false)
	public String info() throws IOException {
		
		String zcode = request.getParameter("zcode");
		
		List<Postinfo> address = postinfoService.getresultSQLfromPinfo(zcode);
		Iterator<Postinfo> iterator = address.iterator();
		
		String homeaddress = null;
		while(iterator.hasNext()){
			Postinfo postinfo = (Postinfo) iterator.next();
			homeaddress = postinfo.homeaddress1 + postinfo.homeaddress2 + postinfo.homeaddress3;
		}
		
		InfoDto dto = new InfoDto();
		dto.zipcode = zcode;
		dto.address = homeaddress;
		
		response.setContentType("application/text; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(dto.address);
		
		return null;
	}

}
