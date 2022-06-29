package sastruts.omikuji.others;

/**
 * 運勢の抽象クラスです。
 * 
 * @author h_kim
 * @version 1.0
 */
public abstract class Unsei implements Fortune{
	
	/** 運勢名 */
    protected String unsei;
	
	/** 願い事 */
    protected String negaigoto;
	
	/** 商い */
    protected String akinai;
	
	/** 学問 */
    protected String gakumon;
	
	/** おみくじコード */
    protected String omikujicode;
	
	/** 抽象メソッド */
    public abstract void setUnsei();

    /**
     * 運勢名を取得します。
     * @return　運勢名
     */
    public String getUnsei(){
        return unsei;
    }
    
    /**
     * 運勢名をセットします。
     * @param unsei　運勢名
     */
    public void setUnsei(String unsei) {
        this.unsei=unsei;
    }
    
    /**
     * 願い事を取得します。
     * @return　願い事
     */
    public String getNegaigoto(){
        return negaigoto;
    }
    
    /**
     * 願い事をセットします。
     * @param negaigoto　願い事
     */
    public void setNegaigoto(String negaigoto) {
        this.negaigoto=negaigoto;
    }

    /**
     * 商いを取得します。
     * @return　商い
     */
    public String getAkinai(){
        return akinai;
    }
    
    /**
     * 商いをセットします。
     * @param akinai 商い
     */
    public void setAkinai(String akinai) {
        this.akinai=akinai;
    }

    /**
     * 学問を取得します。
     * @return 学問
     */
    public String getGakumon(){
        return gakumon;
    }
    
    /**
     * 学問をセットします。
     * @param gakumon 学問
     */
    public void setGakumon(String gakumon) {
        this.gakumon=gakumon;
    }

    /**
     * おみくじコードを取得します。
     * @return　おみくじコード
     */
    public String getOmikujicode(){
        return omikujicode;
    }
    
    /**
     * おみくじコードをセットします。
     * @param omikujicode　おみくじコード
     */
    public void setOmikujicode(String omikujicode){
        this.omikujicode=omikujicode;
    }

    /**
     * インターフェースから相続される。
     * @return Stringフォマットのおみくじ結果
     */
    public String disp() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(DISP_STR, getUnsei()));
        sb.append("\n願い事 : ");
        sb.append(getNegaigoto());
        sb.append("\n商い : ");
        sb.append((getAkinai()));
        sb.append("\n学問 : ");
        sb.append(getGakumon());
        return sb.toString();
    }
}



