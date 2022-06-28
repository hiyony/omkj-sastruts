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
import sastruts.omikuji.service.PostinfoService;

/**
 * Company Practice
 * 住所自動入力システムです。
 * →　郵便番号から住所を取得する
 * @author h_kim
 * @version 1.0
 */

public class InfoAction {
	@Required
	@ActionForm
	protected InfoForm infoForm;
	
	@Resource
	protected PostinfoService postinfoService;
	
	@Resource
	protected HttpServletRequest request;
	
	@Resource 
	protected HttpServletResponse response;
	
	/**
	 * 郵便番号から住所を検索する処理。
	 * →　入力された郵便番号を受けて、その郵便番号を使って住所を検索
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
