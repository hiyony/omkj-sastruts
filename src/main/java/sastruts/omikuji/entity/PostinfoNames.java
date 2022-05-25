package sastruts.omikuji.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Postinfo}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2022/05/24 14:50:01")
public class PostinfoNames {

    /**
     * postnumberのプロパティ名を返します。
     * 
     * @return postnumberのプロパティ名
     */
    public static PropertyName<String> postnumber() {
        return new PropertyName<String>("postnumber");
    }

    /**
     * homeaddress1のプロパティ名を返します。
     * 
     * @return homeaddress1のプロパティ名
     */
    public static PropertyName<String> homeaddress1() {
        return new PropertyName<String>("homeaddress1");
    }

    /**
     * homeaddress2のプロパティ名を返します。
     * 
     * @return homeaddress2のプロパティ名
     */
    public static PropertyName<String> homeaddress2() {
        return new PropertyName<String>("homeaddress2");
    }

    /**
     * homeaddress3のプロパティ名を返します。
     * 
     * @return homeaddress3のプロパティ名
     */
    public static PropertyName<String> homeaddress3() {
        return new PropertyName<String>("homeaddress3");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _PostinfoNames extends PropertyName<Postinfo> {

        /**
         * インスタンスを構築します。
         */
        public _PostinfoNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _PostinfoNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _PostinfoNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * postnumberのプロパティ名を返します。
         *
         * @return postnumberのプロパティ名
         */
        public PropertyName<String> postnumber() {
            return new PropertyName<String>(this, "postnumber");
        }

        /**
         * homeaddress1のプロパティ名を返します。
         *
         * @return homeaddress1のプロパティ名
         */
        public PropertyName<String> homeaddress1() {
            return new PropertyName<String>(this, "homeaddress1");
        }

        /**
         * homeaddress2のプロパティ名を返します。
         *
         * @return homeaddress2のプロパティ名
         */
        public PropertyName<String> homeaddress2() {
            return new PropertyName<String>(this, "homeaddress2");
        }

        /**
         * homeaddress3のプロパティ名を返します。
         *
         * @return homeaddress3のプロパティ名
         */
        public PropertyName<String> homeaddress3() {
            return new PropertyName<String>(this, "homeaddress3");
        }
    }
}