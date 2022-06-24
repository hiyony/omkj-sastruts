package sastruts.omikuji.service;

import java.util.List;

import javax.annotation.Generated;

import sastruts.omikuji.entity.Save;

/**
 * {@link Save}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2022/05/31 17:04:03")
public class SaveService extends AbstractService<Save> {
	public List<Save> getresultjSQLfromSave(){
		List<Save> list = jdbcManager
				.from(Save.class)
				.getResultList();
		return list;
	}
}