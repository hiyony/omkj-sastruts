package sastruts.omikuji.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Generated;
import javax.annotation.Resource;

import sastruts.omikuji.dto.OmikujiiDto;
import sastruts.omikuji.entity.Unseiresult;
import sastruts.omikuji.form.InputForm;

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
	protected InputForm inputform;

	//DTO?
	public Unseiresult getcompareSQLfromUr(Unseiresult result){
		OmikujiiDto.birthday = inputform.birthday;
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar today = Calendar.getInstance();
		OmikujiiDto.todayString = df.format(today);
		
		Unseiresult omkjid = jdbcManager.from(Unseiresult.class)
				.where("uranaidate = ?", OmikujiiDto.todayString)
				.where("birthday = ?", OmikujiiDto.birthday)
				.getSingleResult();
		
		return omkjid;
	}
	
}