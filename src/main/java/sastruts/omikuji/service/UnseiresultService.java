package sastruts.omikuji.service;

import java.util.List;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import sastruts.omikuji.entity.Unseiresult;

/**
 * {@link Unseiresult}のサービスクラスです。
 * 
 * @author h_kim
 * @version 1.0
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, 
		date = "2022/05/18 15:14:29")
public class UnseiresultService extends AbstractService<Unseiresult> {
	
	/**
	 * 過去のおみくじ結果に同じ日付と誕生日がある場合、同じ結果を検索するクラスです。
	 * 
	 * @param todayString
	 * @param birthday
	 * @return SQL文の結果リスト　
	 */
	public List <Unseiresult> getcompareSQLfromUr(String todayString, String birthday){
		String today = todayString;
		String bday = birthday;
		
		List <Unseiresult> omkjid = jdbcManager
				.from(Unseiresult.class)
				.where(
					new SimpleWhere()
					.eq("uranaidate", today)
					.eq("birthday", bday))
				.getResultList();
		return omkjid;
	}
	
	/**
	 * 半年前の日付とお誕生日を条件で使っておみくじ結果を検索するクラスです。
	 * 
	 * @param birthday
	 * @param checkdate
	 * @return SQL文の結果リスト halfres
	 */
	public List <Unseiresult> getHalfyearResultSQL (String birthday, String checkdate) {
		String bday = birthday;
		String chkdate = checkdate;
		
		List <Unseiresult> halfres = jdbcManager
				.from(Unseiresult.class)
				.where(
					new SimpleWhere()
					.ge("uranaidate", chkdate)
					.eq("birthday", bday))
				.getResultList();
		return halfres;
	}
	
//	public List <Unseiresult> getHalfyearResultSQL (String birthday) {
//		String bday = birthday;
//		List <Unseiresult> halfres = jdbcManager
//				.selectBySql(Unseiresult.class, "SELECT * FROM unseiresult AS u " +
//												 "WHERE (SELECT CAST (u.uranaidate AS date) AS uradate) " +
//											   "BETWEEN CURRENT_TIMESTAMP - INTERVAL '6 months' AND CURRENT_TIMESTAMP " +
//											       "AND birthday = ? " +
//											  "ORDER BY u.uranaidate ASC", bday)
//				.getResultList();
//		return halfres;
//	}
}