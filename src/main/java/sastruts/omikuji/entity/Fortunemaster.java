package sastruts.omikuji.entity;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Fortunemasterエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2022/05/18 15:14:22")
public class Fortunemaster implements Serializable {

    private static final long serialVersionUID = 1L;

    /** unseinameプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String unseiname;

    /** unseicodeプロパティ */
    @Id
    @Column(length = 2147483647, nullable = false, unique = true)
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

    /** omikujiiList関連プロパティ */
    @OneToMany(mappedBy = "fortunemaster")
    public List<Omikujii> omikujiiList;
}