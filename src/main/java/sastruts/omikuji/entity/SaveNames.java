package sastruts.omikuji.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Save}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2022/05/31 17:03:59")
public class SaveNames {

    /**
     * nameのプロパティ名を返します。
     * 
     * @return nameのプロパティ名
     */
    public static PropertyName<String> name() {
        return new PropertyName<String>("name");
    }

    /**
     * zipcodeのプロパティ名を返します。
     * 
     * @return zipcodeのプロパティ名
     */
    public static PropertyName<String> zipcode() {
        return new PropertyName<String>("zipcode");
    }

    /**
     * homeaddressのプロパティ名を返します。
     * 
     * @return homeaddressのプロパティ名
     */
    public static PropertyName<String> homeaddress() {
        return new PropertyName<String>("homeaddress");
    }

    /**
     * emailaddressのプロパティ名を返します。
     * 
     * @return emailaddressのプロパティ名
     */
    public static PropertyName<String> emailaddress() {
        return new PropertyName<String>("emailaddress");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _SaveNames extends PropertyName<Save> {

        /**
         * インスタンスを構築します。
         */
        public _SaveNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _SaveNames(final String name) {
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
        public _SaveNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * nameのプロパティ名を返します。
         *
         * @return nameのプロパティ名
         */
        public PropertyName<String> name() {
            return new PropertyName<String>(this, "name");
        }

        /**
         * zipcodeのプロパティ名を返します。
         *
         * @return zipcodeのプロパティ名
         */
        public PropertyName<String> zipcode() {
            return new PropertyName<String>(this, "zipcode");
        }

        /**
         * homeaddressのプロパティ名を返します。
         *
         * @return homeaddressのプロパティ名
         */
        public PropertyName<String> homeaddress() {
            return new PropertyName<String>(this, "homeaddress");
        }

        /**
         * emailaddressのプロパティ名を返します。
         *
         * @return emailaddressのプロパティ名
         */
        public PropertyName<String> emailaddress() {
            return new PropertyName<String>(this, "emailaddress");
        }
    }
}