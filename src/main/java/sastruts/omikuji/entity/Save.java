package sastruts.omikuji.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Saveエンティティクラス
 * 
 * @author h_kim
 * @version 1.0
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/05/31 17:03:55")
public class Save implements Serializable {

    private static final long serialVersionUID = 1L;

    /** nameプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String name;

    /** zipcodeプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String zipcode;

    /** homeaddressプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String homeaddress;

    /** emailaddressプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String emailaddress;
}