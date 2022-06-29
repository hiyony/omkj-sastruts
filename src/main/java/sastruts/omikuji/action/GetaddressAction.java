package sastruts.omikuji.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.seasar.struts.annotation.Execute;

import sastruts.omikuji.dto.GetaddressDto;
import sastruts.omikuji.entity.Postinfo;
import sastruts.omikuji.service.PostinfoService;

/**
 * 住所から郵便番号取得Actionクラス。
 * Actionクラス、画面からの要求を制御するコントローラークラス。
 * 入力された住所から自動的に郵便番号の結果を取得する。
 * 
 * @author h_kim
 * @version 1.0
 */

public class GetaddressAction {
	
	/** Serviceクラス */
	@Resource
	protected PostinfoService postinfoService;
	
	/** HTTPリクエスト */
	@Resource
	protected HttpServletRequest request;
	
	/** HTTPリスポンス */
	@Resource
	protected HttpServletResponse response;
	
	/**
	 * 入力された住所から郵便番号の結果を検索しリストを取得する。
	 * 入力パラメーターはrequestから取得する。
	 * 結果が一件か複数件かによって検索するための文字列の長さを調節し処理する。
	 * 
	 * @throws IOException
	 */
	@Execute(validator = false)
	public void getaddress() throws IOException {
		
		//入力された住所を取得する
		String address = request.getParameter("address");
		
		String repaddress1 = address.replaceAll("[都道府県]", "#");
		//都道府県を取得して、無ければリターンする
		int index1 = repaddress1.indexOf("#", 2);
		if(index1 == -1){
			return;
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
		
		String repaddress2 = address.replaceAll("[ヶが]", "ケ");
		repaddress2 = address.replaceAll("[ノ之乃]", "の");
		String replaceaddress = repaddress2.substring(0, index2);
		
		List <Postinfo> zcode = postinfoService.getzipcodeSQLfromPinfo(address1, replaceaddress);
		
		Map<String, String> beforeMap = new HashMap<String, String>();
		Map<String, String> nowMap = new HashMap<String, String>();
		
		while(true){
			Iterator <Postinfo> iterator = zcode.iterator();
			GetaddressDto gadto = new GetaddressDto();
			
			while(iterator.hasNext()){
				Postinfo postinfo = (Postinfo) iterator.next();
				nowMap.put(postinfo.zipcode, postinfo.homeaddress);
				
			}
			
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
			} else if(nowMap.size() == 0){ //결과가 나오지 않았을 경우
				replaceaddress = replaceaddress.substring(0, replaceaddress.length()-1); //길이를 줄여서 재검색
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
		JSONObject json = new JSONObject(nowMap);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(json);
		
		String zipcode = null;
		String totaladdress = null;
		GetaddressDto gadto = new GetaddressDto();
		List <GetaddressDto> list = new ArrayList <GetaddressDto>();
		
		for(Map.Entry<String, String> entry : nowMap.entrySet()){
			zipcode = entry.getKey();
			totaladdress = entry.getValue();
			gadto.setZipcode(zipcode);
			gadto.setHomeaddress(totaladdress);
			list.add(gadto);
		}
		
		request.setAttribute("list", list);

	}
}
