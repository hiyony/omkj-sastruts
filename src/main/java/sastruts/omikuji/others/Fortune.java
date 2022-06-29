package sastruts.omikuji.others;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Fortune インターフェースです。
 * ResourceBundleを利用してプロパティファイルに接近する。
 * 
 * @author h_kim
 * @version 1.0
 */
public interface Fortune {
    ResourceBundle rb = ResourceBundle.getBundle("fortune");
    String DISP_STR = rb.getString("disp_str");
    String disp() throws IOException;
}



