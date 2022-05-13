package sastruts.omikuji.service;

import javax.annotation.Generated;
import javax.annotation.Resource;

import sastruts.omikuji.dto.OmikujiiDto;
import sastruts.omikuji.entity.Omikujii;

/**
 * {@link Omikujii}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, 
					date = "2022/05/10 14:44:25")
public class OmikujiiService extends AbstractService<Omikujii> {
	
	@Resource
	public OmikujiiDto omkjdto;
	
	//ActionResult.java -> SELECT COUNT(*) FROM omikujii
	public long countSQLfromOmkj(Omikujii result){
		long rs3 = jdbcManager.from(Omikujii.class)
					.getCount();
		return rs3;
	}
	
	//ActionResult.java -> SELECT f.unseiname, o.negaigoto, o.akinai, o.gakumon
	//						 FROM omikujii o JOIN fortunemaster f ON f.unseicode = o.unseicode
	//						WHERE o.omikujicode = ?
	
	public Omikujii findById(String unseicode){
		return select().id(unseicode).getSingleResult();
	}
	
//	public List<Omikujii> findAllOrderById(){
//		return select().orderBy(asc(unseicode())).getResultList();
//	}


//	public List <Omikujii> getresultSQLfromOmkj(Omikujii result){
//		
//		List <Omikujii> rs6 = jdbcManager.from(Omikujii.class)
//				.innerJoin("fortunemaster")
//				.where("omikujii.omikujicode = ?", OmikujiiDto.omikujiID)
//				.getResultList();
//		
////		Omikujii omkjcode = jdbcManager.from(Omikujii.class)
////				.innerJoin("fortunemaster")
////				.where("omikujii.omikujicode = ?", OmikujiiDto.omikujiID)
////				.getSingleResult();
//		
//		return rs6;
//	}
}