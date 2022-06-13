package sastruts.omikuji.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;

import sastruts.omikuji.dto.GetaddressDto;
import sastruts.omikuji.entity.Postinfo;
import sastruts.omikuji.service.PostinfoService;

public class GetaddressAction {
	
	@Resource
	protected PostinfoService postinfoService;
	
	@Resource
	protected HttpServletRequest request;
	
	@Resource
	protected HttpServletResponse response;
	
	@Execute(validator = false)
	public String getaddress() {
		
		String address = request.getParameter("address");
		
		
		
		int index = 0;
		if(address.contains("都")){
			index = address.indexOf("都");
		} else if(address.contains("道")){
			index = address.indexOf("道");
		} else if(address.contains("府")){
			index = address.indexOf("府");
		} else if(address.contains("県")){
			index = address.indexOf("県");
		}
		
		String todouhuken = address.substring(0, index + 1);
		String address2 = address.substring(index + 1, index + 3);
		
		List <GetaddressDto> list = new ArrayList<GetaddressDto>();
		
		List <Postinfo> result = postinfoService.getzipcodeSQLfromPinfo(todouhuken, address2);
		Iterator <Postinfo> iterator = result.iterator();
		
		while(iterator.hasNext()){
			Postinfo postinfo = (Postinfo) iterator.next();
			GetaddressDto getaddressdto = new GetaddressDto(postinfo.zipcode, postinfo.homeaddress1, 
					postinfo.homeaddress2, postinfo.homeaddress3);
			
			getaddressdto.setZipcode(postinfo.zipcode);
			getaddressdto.setHomeaddress1(postinfo.homeaddress1);
			getaddressdto.setHomeaddress2(postinfo.homeaddress2);
			getaddressdto.setHomeaddress3(postinfo.homeaddress3);
			list.add(getaddressdto);
		}
		request.setAttribute("list", list);
		
		return null;
	}

}
