package sastruts.omikuji.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
	
	@Resource
	String birthday = inputform.birthday;
	
	@Resource
	public OmikujiiDto omkjdto;
	
	@Resource
	DateFormat df = new SimpleDateFormat("yyyyMMdd");
	Calendar today = Calendar.getInstance();
	String todayString = df.format(today);

	//DTO?
	public List<Unseiresult> getcompareSQLfromUr(Unseiresult result){
		List <Unseiresult> rs5 = jdbcManager.from(Unseiresult.class)
				.where("uranaidate = ?", todayString)
				.where("birthday = ?", birthday)
				.getResultList();
		
		Iterator<Unseiresult> iterator = rs5.iterator();
		while(iterator.hasNext()){
			omkjdto.omikujiID = String.valueOf(iterator.next());
		}
		
		if(omkjdto.omikujiID.isEmpty()){
			int rannum = new Random().nextInt(/*cnt*/) + 1;
			omkjdto.omikujiID = String.valueOf(rannum);
		}
		return rs5;
	}
	
}