package sastruts.omikuji.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.form.InputForm;

/**
 * 最初画面と結果出力画面を繋ぐActionクラス。
 * Actionクラス、画面からの要求を制御するコントローラークラス。
 * 
 * @author h_kim
 * @version 1.0
 */

public class InputAction {
	
	/** ActionFormクラス */
	@Required
	@ActionForm
	protected InputForm inputform;
	
	/** HTTPセッション */
	@Resource
	protected HttpSession session;
	
	/**
	 * 最初画面を出力する。
	 * 
	 * @return index.jsp
	 */
	@Execute(validator = false)
	public String index() {
		
		return "index.jsp";
	}
	
	/**
	 * 結果を出力ためにOutputActionに連結する。
	 * 条件に合ってない場合(yyyyMMddの方式以外)はvalidateでエラーを呼び出す。
	 * 合っている場合はOutputActionに連結する。
	 * 
	 * @return /output/
	 */
	@Execute(validator = true, validate = "validate", input = "index.jsp")
	public String output() {
		//return "output.jsp";
		return "/output/";
	}
	

}
