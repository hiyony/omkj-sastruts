package sastruts.omikuji.service;

import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;

import sastruts.omikuji.dto.FortunemasterDto;
import sastruts.omikuji.entity.Fortunemaster;

/**
 * {@link Fortunemaster}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, 
					date = "2022/05/10 14:44:25")
public class FortunemasterService extends AbstractService<Fortunemaster> {
	
	//ActionResult.java -> SELECT unseicode, unseiname FROM fortunemaster
	@Resource
	public FortunemasterDto fmdto;
	
	public List<Fortunemaster> getselectSQLfromFm(Fortunemaster result){
		//Dtoファイルを使ってSQL文作成する
		List <Fortunemaster> rs1 = jdbcManager
				.from(Fortunemaster.class)
				//.includes("unseiname", "unseicode")
				.getResultList();
		
		//流れるようなインタフェースでMapを組み立てる
//		List<Fortunemaster> rs1 = jdbcManager.from(Fortunemaster.class)
//				   .where(
//						   params("unseiname", fmdto.unseiname)
//						   .$("unseicode", fmdto.unseicode)
//						   .$())
//				   .getResultList();
		return rs1;
	}
}