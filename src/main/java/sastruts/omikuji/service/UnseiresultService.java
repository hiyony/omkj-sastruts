package sastruts.omikuji.service;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import sastruts.omikuji.entity.Unseiresult;

/**
 * {@link Unseiresult}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2022/05/18 15:14:29")
public class UnseiresultService extends AbstractService<Unseiresult> {
	public Unseiresult getcompareSQLfromUr(String todayString, String birthday){
		String today = todayString;
		String bday = birthday;
		
		Unseiresult omkjid = jdbcManager
				.from(Unseiresult.class)
				.where(
					new SimpleWhere()
					.eq("uranaidate", today)
					.eq("birthday", bday))
				.getSingleResult();
		
		return omkjid;
	}
}