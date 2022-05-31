package sastruts.omikuji.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Postinfoエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/05/30 17:07:01")
public class Postinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** zipcodeプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String zipcode;

    /** homeaddress1プロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String homeaddress1;

    /** homeaddress2プロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String homeaddress2;

    /** homeaddress3プロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String homeaddress3;
}