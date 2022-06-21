package sastruts.omikuji.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public String getaddress() throws IOException {
		
		String address = request.getParameter("address");
		
		//都道府県
		String repaddress1 = address.replaceAll("[都道府県]", "#");
		int index1 = repaddress1.indexOf("#", 2);
		if(index1 == -1){
			return null;
		}
		String address1 = address.substring(0, index1+1);
		
		//市区町村
		repaddress1 = address.replaceAll("[市区町村]", "@");
		int index2 = repaddress1.indexOf("@", address1.length()+1);
		//시구정촌을 포함하고 있지 않거나 입력한 주소의 길이가 짧은 경우 
		if(index2 == -1 || (index2 + 3 >= address.length())){ 
			index2 = address.length();
		} else{
			index2 += 3;
		}
		
		//表記揺れ
		String repaddress2 = address.replaceAll("[ヶが]", "ケ");
		repaddress2 = address.replaceAll("[ノ之乃]", "の");
		String replaceaddress = repaddress2.substring(0, index2);
		
		
		//List <GetaddressDto> save = new ArrayList<GetaddressDto>();
		//List <GetaddressDto> list = new ArrayList<GetaddressDto>();
		
		List <Postinfo> zcode = postinfoService.getzipcodeSQLfromPinfo(address1, replaceaddress);
		
		Map<String, String> beforeMap = new HashMap<String, String>();
		Map<String, String> nowMap = new HashMap<String, String>();
		
		while(true){
			Iterator <Postinfo> iterator = zcode.iterator();
			GetaddressDto gadto = new GetaddressDto();
			
			while(iterator.hasNext()){
				Postinfo postinfo = (Postinfo) iterator.next();
				nowMap.put(postinfo.zipcode, postinfo.homeaddress);
				
//				gadto.setZipcode(postinfo.zipcode);
//				gadto.setHomeaddress(postinfo.homeaddress);
//				list.add(gadto);
			}
			
//			if(list.size() == 1){
//				break;
//			} else if(list.size() > 1){
//				index2 += 1;
//				if(address.length() == replaceaddress.length()){
//					break;
//				}
//				replaceaddress = repaddress2.substring(0, index2);
//				
//				save.clear();
//				save.addAll(list);
//				list.clear();
//			} else if(list.size() == 0){
//				replaceaddress = replaceaddress.substring(0, replaceaddress.length()-1);
//				if(replaceaddress.length() <= address1.length()){
//					break;
//				}
//				if(save.size() > 0){
//					list.clear();
//					list.addAll(save);
//					save.clear();
//					break;
//				}
//			}
			
			//1건의 결과가 나왔을 경우
			if(nowMap.size() == 1){
				break;
			} else if(nowMap.size() > 1){ //1건의 결과보다 많은 결과가 나왔을 경우
				index2 = index2 + 1; //문자열을 하나 더 늘려서 검색
				if(address.length() == replaceaddress.length()){ //더이상 추가할 문자열이 존재하지 않을 경우
					break;
				}
				replaceaddress = repaddress2.substring(0, index2);
				
				beforeMap.clear();
				beforeMap.putAll(nowMap);
				nowMap.clear();
			} else if(nowMap.size() == 0){
				replaceaddress = replaceaddress.substring(0, replaceaddress.length()-1);
				if(replaceaddress.length() <= address1.length()){
					break;
				}
				if(beforeMap.size() > 0){
					nowMap.clear();
					nowMap.putAll(beforeMap);
					beforeMap.clear();
					break;
				}
			}
		}
		
		String zipcode = null;
		String totaladdress = null;
		for(Map.Entry<String, String> entry : nowMap.entrySet()){
			zipcode = entry.getKey();
			totaladdress = entry.getValue();
		}

		GetaddressDto gadto = new GetaddressDto();
		gadto.zipcode = zipcode;
		gadto.homeaddress = totaladdress;
		
		
		response.setContentType("application/text; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(gadto.zipcode);
		
		return null;
	}
}
