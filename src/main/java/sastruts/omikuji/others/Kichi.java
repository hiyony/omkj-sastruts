package sastruts.omikuji.others;

/**
 * 運勢をセットするクラスです。
 * 抽象クラスを相続している。
 * 
 * @author h_kim
 * @version 1.0
 */
public class Kichi extends Unsei{
	
	/**
	 * '吉'をセットする。
	 * 　オーバーラーイド
	 */
    @Override
    public void setUnsei() {
        unsei = "吉";
    }
}
