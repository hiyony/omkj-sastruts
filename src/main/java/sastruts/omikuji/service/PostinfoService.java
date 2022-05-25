package sastruts.omikuji.service;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import sastruts.omikuji.entity.Postinfo;

/**
 * {@link Postinfo}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2022/05/24 14:50:04")
public class PostinfoService extends AbstractService<Postinfo> {
	
	public long countSQLfromPostinfo(Postinfo result) {
		long rs = jdbcManager
				.from(Postinfo.class)
				.getCount();
		
		return rs;
	}
	
	public Postinfo getresultSQLfromPinfo(String zipcode){
		String zcode = zipcode;
		
		Postinfo address = jdbcManager
				.from(Postinfo.class)
				.where(
					new SimpleWhere()
					.eq("postnumber", zcode))
				.getSingleResult();
		
		return address;
	}
}