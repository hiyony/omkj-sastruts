package sastruts.omikuji.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Postinfoエンティティクラス
 * 
 * @author h_kim
 * @version 1.0
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/06/21 13:39:14")
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

    /** homeaddressプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String homeaddress;
}