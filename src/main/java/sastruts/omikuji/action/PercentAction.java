package sastruts.omikuji.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.struts.annotation.Execute;

import sastruts.omikuji.dto.PercentDto;
import sastruts.omikuji.dto.PercentResDto;
import sastruts.omikuji.service.OmikujiiService;

/**
 * 今までのおみくじ割合取得Actionクラス。
 * Actionクラス、画面からの要求を制御するコントローラークラス。
 * 今までのおみくじ結果の割合を取得します。
 * 
 * @author h_kim
 * @version 1.0
 */

public class PercentAction {
	
	/** Serviceクラス */
	@Resource
	protected OmikujiiService omikujiiService;
	
	/** HTTPリクエスト */
	@Resource
	protected HttpServletRequest request;
	
	/**
	 * 誕生日の今までのおみくじ割合と数を検索しリストを取得する。
	 * 入力パラメーターはrequestから取得する
	 * 入力された誕生日のおみくじ結果に関して項目それぞれの数と割合を自動的に計算し処理する。
	 * 
	 * @return percent.jsp
	 */
	@Execute(validator = false)
	public String percent() {
		
		String birthday = request.getParameter("birthday");
		
		List <PercentResDto> list = new ArrayList <PercentResDto> ();
		
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		JdbcManager jdbcManager = (JdbcManager)container.getComponent(JdbcManager.class);
		
//		List <Omikujii> perres = omikujiiService.getPercentResultSQL(birthday);
//		Iterator <Omikujii> iterator = perres.iterator();
//		
//		while(iterator.hasNext()){
//			Omikujii omikujii = (Omikujii) iterator.next();
//			PercentDto perdto = new PercentDto();
//			
//		}
//		
		List <PercentDto> perres = jdbcManager
				.selectBySqlFile(PercentDto.class, 
						"sastruts/omikuji/service/getPercentResultList.sql", birthday)
					.getResultList();
		
		Iterator <PercentDto> iterator = perres.iterator();
		
		while(iterator.hasNext()){
			PercentDto percentDto = (PercentDto) iterator.next();
			PercentResDto percentres = new PercentResDto();
			
			if(percentDto.fortunecount == null && percentDto.totalpercent == null){
				percentDto.fortunecount = 0;
				percentDto.totalpercent = 0;
			}
			
			percentres.setFortunename(percentDto.fortunename);
			percentres.setFortunecount(percentDto.fortunecount);
			percentres.setTotalpercent(percentDto.totalpercent);
			list.add(percentres);
		}
		
		request.setAttribute("list", list);
		
		return "percent.jsp";
	}

}
