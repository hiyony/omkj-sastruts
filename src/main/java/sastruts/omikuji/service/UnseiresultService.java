package sastruts.omikuji.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import sastruts.omikuji.entity.Unseiresult;

/**
 * {@link Unseiresult}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, 
			date = "2022/05/10 14:44:25")
public class UnseiresultService extends AbstractService<Unseiresult> {
	
	//ActionResult.java -> SELECT omikujicode, uranaidate, birthday
	//						 FROM unseiresult
	//						WHERE uranaidate = ? AND birthday = ?
	@Resource
	protected HttpServletRequest request;
	
	@Resource
	String birthday = (String) request.getAttribute("birthday");
	
	@Resource
	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Calendar today = Calendar.getInstance();
	String todayString = df.format(today);
	
	public List<Unseiresult> getRs5(Unseiresult result){
		List <Unseiresult> rs5 = jdbcManager.from(Unseiresult.class)
				.where("uranaidate = ?", todayString)
				.where("birthday = ?", birthday)
				.getResultList();
		return rs5;
	}
}