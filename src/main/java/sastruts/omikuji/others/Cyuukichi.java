package sastruts.omikuji.others;


/**
 * 運勢をセットするクラスです。
 * 抽象クラスを相続している。
 * 
 * @author h_kim
 * @version 1.0
 */
public class Cyuukichi extends Unsei{
	
	/**
	 * オーバーラーイド
	 * '中吉'をセットする。
	 */
    @Override
    public void setUnsei() {
        unsei = "中吉";
    }
}
