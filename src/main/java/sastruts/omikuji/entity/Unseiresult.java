package sastruts.omikuji.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Unseiresultエンティティクラス
 * 
 * @author h_kim
 * @version 1.0
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/05/18 15:14:22")
public class Unseiresult implements Serializable {

    private static final long serialVersionUID = 1L;

    /** uranaidateプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String uranaidate;

    /** birthdayプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String birthday;

    /** omikujicodeプロパティ */
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

    /** omikujii関連プロパティ */
    @ManyToOne
    @JoinColumn(name = "omikujicode", referencedColumnName = "omikujicode")
    public Omikujii omikujii;
}