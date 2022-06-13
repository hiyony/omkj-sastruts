package sastruts.omikuji.service;

import java.util.List;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import sastruts.omikuji.entity.Postinfo;

/**
 * {@link Postinfo}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2022/05/30 17:07:09")
public class PostinfoService extends AbstractService<Postinfo> {
	public List<Postinfo> getresultSQLfromPinfo(String zipcode){
		String zcode = zipcode;
		
		List<Postinfo> address = jdbcManager
				.from(Postinfo.class)
				.where(
					new SimpleWhere()
					.eq("zipcode", zcode))
				.getResultList();
		
		return address;
	}
	
	public List<Postinfo> getzipcodeSQLfromPinfo(String address1, String address2){
		String a1 = address1;
		String a2 = address2;
		
		List<Postinfo> zipcode = jdbcManager
				.from(Postinfo.class)
				.where(
					new SimpleWhere()
					.eq("homeaddress1", a1)
					.contains("homeaddress2", a2))
				.getResultList();
		
		return zipcode;
	}
}