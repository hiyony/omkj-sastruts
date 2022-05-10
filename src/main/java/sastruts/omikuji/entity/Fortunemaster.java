package sastruts.omikuji.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Fortunemasterエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/05/10 14:44:18")
public class Fortunemaster implements Serializable {

    private static final long serialVersionUID = 1L;

    /** unseinameプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String unseiname;

    /** unseicodeプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String unseicode;

    /** renewalwriterプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String renewalwriter;

    /** renewaldateプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String renewaldate;

    /** unseiwriterプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String unseiwriter;

    /** unseiwritedateプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String unseiwritedate;
}