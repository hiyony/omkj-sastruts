package sastruts.omikuji.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Omikujiiエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/05/10 14:44:18")
public class Omikujii implements Serializable {

    private static final long serialVersionUID = 1L;

    /** omikujicodeプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String omikujicode;

    /** unseicodeプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String unseicode;

    /** negaigotoプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String negaigoto;

    /** akinaiプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String akinai;

    /** gakumonプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String gakumon;

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