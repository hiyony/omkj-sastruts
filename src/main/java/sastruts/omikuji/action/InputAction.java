package sastruts.omikuji.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.form.InputForm;

/**
 * Company Practice
 * 最初画面と結果出力画面を繋ぐシステムです。
 * @author h_kim
 * @version 1.0
 */

public class InputAction {
	@Required
	@ActionForm
	protected InputForm inputform;
	
	@Resource
	protected HttpSession session;
	
	/**
	 * 最初画面を出力する。
	 * @return index.jsp
	 */
	
	@Execute(validator = false)
	public String index() {
		
		return "index.jsp";
	}
	
	/**
	 * 結果を出力ためにOutputActionに連結する。
	 * →　validatorがtrueだから条件に合ってない場合(yyyyMMddの形式以外)、index.jspにvalidateを実行する
	 * →　合う形式で入力したらOutputActionに連結する
	 * @return /output/
	 */
	
	@Execute(validator = true, validate = "validate", input = "index.jsp")
	public String output() {
		//return "output.jsp";
		return "/output/";
	}
	

}
