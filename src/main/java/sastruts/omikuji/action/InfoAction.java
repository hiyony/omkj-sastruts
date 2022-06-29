package sastruts.omikuji.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;

import sastruts.omikuji.dto.InfoDto;
import sastruts.omikuji.entity.Postinfo;
import sastruts.omikuji.service.PostinfoService;

/**
 * 郵便番号から住所取得Actionクラス。
 * Actionクラス、画面からの要求を制御するコントローラークラス。
 * 入力された郵便番号から自動的に住所の結果を取得します。
 * 
 * @author h_kim
 * @version 1.0
 */

public class InfoAction {
	
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
	 * 郵便番号から住所を検索し住所を取得する。
	 * 入力パラメーターはrequestから取得する。
	 * 
	 * @return null
	 * @throws IOException
	 */
	
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
