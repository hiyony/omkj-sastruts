package sastruts.omikuji.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;

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
		
		address = address.replaceAll("[ヶケが]", "ケ");
		address = address.replaceAll("[ノの之乃]", "の");
		
		String address1 = address.replaceAll("[都道府県]", "#");
		String address2 = ""; String address3 = "";
		int index1 = 0;
		
		if(address1.contains("#")){
			index1 = address1.indexOf("#");
			address2 = address.substring(0, index1+1);
			address3 = address.substring(index1+1);
		}
		
		String address4 = address3.replaceAll("[市区町村]", "@");
		String address5 = ""; String address6 = ""; String address7 = "";
		int index2 = 0; int index3 = 0;
		
		if(address4.contains("@")){
			index2 = address4.indexOf("@");
			address5 = address3.substring(0, index2+1);
			address6 = address3.substring(index2+1);
			
			if(address6.length() > 2){
				index3 += 2;
				address7 = address6.substring(0, index3);
			} else{
				index3 += 1;
				address7 = address6.substring(0, index3);
			}
		} else {
			if(address3.length() > 2){
				index2 += 2;
				address5 = address3.substring(0, index2+1);
			} else{
				index2 += 1;
				address5 = address3.substring(0, index2);
			}
		}
		
		String homeaddress = address2 + address5 + address7;
		
		List <Postinfo> zcode = postinfoService.getzipcodeSQLfromPinfo(homeaddress);
		
		
		return null;
	}

}
