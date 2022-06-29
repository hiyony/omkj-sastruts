package sastruts.omikuji.entity;

import javax.annotation.Generated;

import sastruts.omikuji.entity.FortunemasterNames._FortunemasterNames;
import sastruts.omikuji.entity.OmikujiiNames._OmikujiiNames;
import sastruts.omikuji.entity.PostinfoNames._PostinfoNames;
import sastruts.omikuji.entity.SaveNames._SaveNames;
import sastruts.omikuji.entity.UnseiresultNames._UnseiresultNames;

/**
 * 名前クラスの集約です。
 * 
 * @author h_kim
 * @version 1.0
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2022/06/21 13:39:18")
public class Names {

    /**
     * {@link Fortunemaster}の名前クラスを返します。
     * 
     * @return Fortunemasterの名前クラス
     */
    public static _FortunemasterNames fortunemaster() {
        return new _FortunemasterNames();
    }

    /**
     * {@link Omikujii}の名前クラスを返します。
     * 
     * @return Omikujiiの名前クラス
     */
    public static _OmikujiiNames omikujii() {
        return new _OmikujiiNames();
    }

    /**
     * {@link Postinfo}の名前クラスを返します。
     * 
     * @return Postinfoの名前クラス
     */
    public static _PostinfoNames postinfo() {
        return new _PostinfoNames();
    }

    /**
     * {@link Save}の名前クラスを返します。
     * 
     * @return Saveの名前クラス
     */
    public static _SaveNames save() {
        return new _SaveNames();
    }

    /**
     * {@link Unseiresult}の名前クラスを返します。
     * 
     * @return Unseiresultの名前クラス
     */
    public static _UnseiresultNames unseiresult() {
        return new _UnseiresultNames();
    }
}