package sastruts.omikuji.service;

import static org.seasar.extension.jdbc.operation.Operations.*;
import static sastruts.omikuji.entity.OmikujiiNames.*;

import java.util.List;

import javax.annotation.Generated;

import sastruts.omikuji.entity.Omikujii;

/**
 * {@link Omikujii}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2022/05/18 15:14:29")
public class OmikujiiService extends AbstractService<Omikujii> {

	/**
	 * Omikujiiテーブルのデータ数を数えます。
	 * @param result
	 * @return SQL文の結果long rs3
	 */
	
	public long countSQLfromOmkj(Omikujii result){
		long rs3 = jdbcManager
				.from(Omikujii.class)
				.getCount();
		
		return rs3;
	}
	
	/**
	 * ランダムで選んだおみくじコードを使って運勢を検索します。
	 * @param code
	 * @return SQL文の結果リスト omkjcode
	 */
	
	public Omikujii getresultSQLfromOmkj(String code){
		String omkjid = code;
		
		Omikujii omkjcode = jdbcManager
				.from(Omikujii.class)
				.innerJoin("fortunemaster")
				.where("omikujicode = ?", omkjid)
				.getSingleResult();
					
		return omkjcode;
	}
	
    /**
     * 識別子でエンティティを検索します。
     * 
     * @param omikujicode
     *            識別子
     * @return エンティティ
     */
    public Omikujii findById(String omikujicode) {
        return select().id(omikujicode).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Omikujii> findAllOrderById() {
        return select().orderBy(asc(omikujicode())).getResultList();
    }
}