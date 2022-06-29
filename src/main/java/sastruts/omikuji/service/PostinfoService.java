package sastruts.omikuji.service;

import java.util.List;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import sastruts.omikuji.entity.Postinfo;

/**
 * {@link Postinfo}のサービスクラスです。
 * 
 * @author h_kim
 * @version 1.0
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2022/05/30 17:07:09")
public class PostinfoService extends AbstractService<Postinfo> {
	
	/**
	 * 郵便番号を使用して住所を検索するクラスです。
	 * 
	 * @param zipcode
	 * @return SQL文の結果リスト
	 */
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
	
	/**
	 * 都道府県などで区分された住所をSQL文の条件で検索するクラスです。
	 * 
	 * @param homeaddress
	 * @param replaceaddress
	 * @return SQL文の結果リスト
	 */
	public List<Postinfo> getzipcodeSQLfromPinfo(String homeaddress, String replaceaddress){
		String address1 = homeaddress;
		String address2 = replaceaddress;
		
		List<Postinfo> zipcode = jdbcManager
				.from(Postinfo.class)
				.where(
					new SimpleWhere()
					.eq("homeaddress1", address1)
					.contains("homeaddress", address2))
			.getResultList();
		
		return zipcode;
	}
}