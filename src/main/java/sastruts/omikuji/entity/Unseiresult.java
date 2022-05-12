package sastruts.omikuji.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Unseiresultエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/05/10 14:44:18")
public class Unseiresult implements Serializable {

    private static final long serialVersionUID = 1L;

    /** uranaidateプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String uranaidate;

    /** birthdayプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String birthday;

    /** omikujicodeプロパティ */
    @ManyToOne
    @Column(length = 2147483647, nullable = true, unique = false)
    public String omikujicode;

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