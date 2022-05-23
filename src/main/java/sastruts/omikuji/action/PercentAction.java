package sastruts.omikuji.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.dto.PercentDto;
import sastruts.omikuji.dto.PercentResDto;
import sastruts.omikuji.form.PercentForm;
import sastruts.omikuji.service.OmikujiiService;

public class PercentAction {
	
	@Required
	@ActionForm
	protected PercentForm percentForm;
	
	@Resource
	protected OmikujiiService omikujiiService;
	
	@Resource
	protected HttpServletRequest request;
	
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
