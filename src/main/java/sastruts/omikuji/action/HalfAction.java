package sastruts.omikuji.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.Execute;

import sastruts.omikuji.dto.HalfDto;
import sastruts.omikuji.entity.Unseiresult;
import sastruts.omikuji.service.UnseiresultService;

/**
 * 半年分の結果取得Actionクラス。
 * Actionクラス、画面からの要求を制御するコントローラークラス。
 * おみくじの半年前からの結果を一覧形式で取得します。
 * 
 * @author h_kim
 * @version 1.0
 */

public class HalfAction {
	
	/** Serviceクラス */
	@Resource
	protected UnseiresultService unseiresultService;
	
	/** HTTPリクエスト */
	@Resource
	protected HttpServletRequest request;
	
	/**
	 * 半年前の結果から今日の結果まで検索しリストを取得する。
	 * 入力パラメーターはrequestから取得をする (yyyyMMdd方式)
	 * 　入力パラメーターの日付から過去半年は自動的に計算し処理する。
	 * 
	 * @return half.jsp
	 */
	@Execute(validator = false)
	public String half() {
		
		String birthday = request.getParameter("birthday");
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		cal.add(Calendar.MONTH, -6);
		String checkdate = sdf.format(cal.getTime());
		
		List <HalfDto> list = new ArrayList<HalfDto>();
		
		List <Unseiresult> halfres = unseiresultService.getHalfyearResultSQL(birthday, checkdate);
		Iterator <Unseiresult> iterator = halfres.iterator();

		while(iterator.hasNext()){
			Unseiresult unseiresult = (Unseiresult) iterator.next();
			HalfDto halfdto = new HalfDto();
			
			halfdto.setUranaidate(unseiresult.uranaidate);
			halfdto.setBirthday(unseiresult.birthday);
			halfdto.setOmikujicode(unseiresult.omikujicode);
			halfdto.setRenewalwriter(unseiresult.renewalwriter);
			halfdto.setRenewaldate(unseiresult.renewaldate);
			halfdto.setUnseiwriter(unseiresult.unseiwriter);
			halfdto.setUnseiwritedate(unseiresult.unseiwritedate);
			list.add(halfdto);
		}
		
		request.setAttribute("list", list);
		
		return "half.jsp";
	}

}
