package sastruts.omikuji.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.dto.HalfDto;
import sastruts.omikuji.entity.Unseiresult;
import sastruts.omikuji.form.HalfForm;
import sastruts.omikuji.service.UnseiresultService;

/**
 * Company Practice
 * おみくじの半年前からの結果を検索システムです。
 * 
 * @author h_kim
 * @version 1.0
 */

public class HalfAction {
	
	@Required
	@ActionForm
	protected HalfForm halfForm;
	
	@Resource
	protected UnseiresultService unseiresultService;
	
	@Resource
	protected HttpServletRequest request;
	
	/**
	 * 半年前の結果から今日の結果まで検索。s
	 * →　今日の日付から半年前の日付を計算して結果をリストに入れる
	 * @return half.jsp
	 */
	
	@Execute(validator = false)
	public String half() {
		
		String birthday = request.getParameter("birthday");
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		cal.add(Calendar.DATE, -182);
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
