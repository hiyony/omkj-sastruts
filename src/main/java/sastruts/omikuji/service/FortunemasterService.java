package sastruts.omikuji.service;

import static org.seasar.extension.jdbc.parameter.Parameter.*;

import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;

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
	public String unseiname;
	public String unseicode;
	
	public List<Fortunemaster> getRs1(Fortunemaster result){
		//List <Fortunemaster> rs1 = jdbcManager.from(Fortunemaster.class)
		//						.getResultList();
		
		//流れるようなインタフェースでMapを組み立てる
		List <Fortunemaster> rs1 = jdbcManager.from(Fortunemaster.class)
				   .where(
						   params("unseiname", unseiname)
						   .$("unseicode", unseicode)
						   .$())
				   .getResultList();
		
		return rs1;
	}
}