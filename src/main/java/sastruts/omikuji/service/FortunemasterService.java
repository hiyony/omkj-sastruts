package sastruts.omikuji.service;

import static org.seasar.extension.jdbc.operation.Operations.*;
import static sastruts.omikuji.entity.FortunemasterNames.*;

import java.util.List;

import javax.annotation.Generated;

import sastruts.omikuji.entity.Fortunemaster;

/**
 * {@link Fortunemaster}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2022/05/18 15:14:28")
public class FortunemasterService extends AbstractService<Fortunemaster> {

	public List<Fortunemaster> getselectSQLfromFm(Fortunemaster result){
		List <Fortunemaster> rs1 = jdbcManager
				.from(Fortunemaster.class)
				.getResultList();
		
		return rs1;
	}
	
    /**
     * 識別子でエンティティを検索します。
     * 
     * @param unseicode
     *            識別子
     * @return エンティティ
     */
    public Fortunemaster findById(String unseicode) {
        return select().id(unseicode).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Fortunemaster> findAllOrderById() {
        return select().orderBy(asc(unseicode())).getResultList();
    }
}