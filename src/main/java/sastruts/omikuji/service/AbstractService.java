package sastruts.omikuji.service;

import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * サービスの抽象クラスです。
 * 
 * @param <ENTITY>
 *            エンティティの型 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.AbstServiceModelFactoryImpl"}, date = "2022/05/10 14:44:25")
public abstract class AbstractService<ENTITY> extends S2AbstractService<ENTITY> {
	
	@Resource(name = "JdbcManager")
	public void setJdbcManager(JdbcManager jdbcManager){
		this.jdbcManager = jdbcManager;
	}
}