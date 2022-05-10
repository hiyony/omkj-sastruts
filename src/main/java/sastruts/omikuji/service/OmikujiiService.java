package sastruts.omikuji.service;

import java.util.List;

import javax.annotation.Generated;

import sastruts.omikuji.entity.Omikujii;

/**
 * {@link Omikujii}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, 
					date = "2022/05/10 14:44:25")
public class OmikujiiService extends AbstractService<Omikujii> {
	
	//ActionResult.java -> SELECT COUNT(*) FROM omikujii
	public long getRs3(Omikujii result){
		long rs3 = jdbcManager.from(Omikujii.class)
					.getCount();
		return rs3;
	}
	
	public List <Omikujii> getRs6(Omikujii result){
		String omikujiID = "";
		
		List <Omikujii> rs6 = jdbcManager.from(Omikujii.class)
				.innerJoin("fortunemaster")
				.where("omikujii.omikujicode = ?", omikujiID)
				.getResultList();
		
		return rs6;
	}
}