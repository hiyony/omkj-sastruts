package sastruts.omikuji.others;

/**
 * 運勢をセットするクラスです。
 * 抽象クラスを相続している。
 * 
 * @author h_kim
 * @version 1.0
 */
public class Daikichi extends Unsei{
	
	/**
	 * '大吉'をセットする。
	 * オーバーラーイド
	 */
    @Override
    public void setUnsei() {
        unsei = "大吉";
    }
}

