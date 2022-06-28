package sastruts.omikuji.others;

/**
 * 抽象クラスをセットします。
 * @author h_kim
 * @version 1.0
 */
public abstract class Unsei implements Fortune{
    protected String unsei;
    protected String negaigoto;
    protected String akinai;
    protected String gakumon;
    protected String omikujicode;
    public abstract void setUnsei();

    /**
     * 値を取得します。
     * @return
     */
    public String getUnsei(){
        return unsei;
    }
    
    /**
     * 値をセットします。
     * @param unsei
     */
    public void setUnsei(String unsei) {
        this.unsei=unsei;
    }
    
    /**
     * 値を取得します。
     * @return
     */
    public String getNegaigoto(){
        return negaigoto;
    }
    
    /**
     * 値をセットします。
     * @param unsei
     */
    public void setNegaigoto(String negaigoto) {
        this.negaigoto=negaigoto;
    }

    /**
     * 値を取得します。
     * @return
     */
    public String getAkinai(){
        return akinai;
    }
    
    /**
     * 値をセットします。
     * @param unsei
     */
    public void setAkinai(String akinai) {
        this.akinai=akinai;
    }

    /**
     * 値を取得します。
     * @return
     */
    public String getGakumon(){
        return gakumon;
    }
    
    /**
     * 値をセットします。
     * @param unsei
     */
    public void setGakumon(String gakumon) {
        this.gakumon=gakumon;
    }

    /**
     * 値を取得します。
     * @return
     */
    public String getOmikujicode(){
        return omikujicode;
    }
    
    /**
     * 値をセットします。
     * @param unsei
     */
    public void setOmikujicode(String omikujicode){
        this.omikujicode=omikujicode;
    }

    /**
     * インターフェースから相続されます。
     * @return sb.toString()
     */
    public String disp() {
//인터페이스로만 읽어들여야 하므로 추상클래스에서는 프로퍼티를 읽어오지 않아도 OK!
//        Properties p = new Properties();
//        String path = Unsei.class.getResource("fortune.properties").getPath();
//        p.load(new FileReader(path));
//        String DISP_STR = p.getProperty("disp_str");

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



