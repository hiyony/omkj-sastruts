package sastruts.omikuji.action;

import java.io.IOException;
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

import sastruts.omikuji.dto.SaveDto;
import sastruts.omikuji.dto.SavingDto;
import sastruts.omikuji.entity.Save;
import sastruts.omikuji.form.SaveForm;
import sastruts.omikuji.service.SaveService;

/**
 * Company Practice
 * 個人情報保存システムです。
 * @author h_kim
 * @version 1.0
 */

public class SaveAction {
	@Required
	@ActionForm
	protected SaveForm saveForm;
	
	@Resource
	protected SaveService saveService;

	@Resource
	protected HttpServletRequest request;
	
	/**
	 * 入力された名前、郵便番号、住所、メールアドレスをデータベースに保存して画面に出力する。
	 * @return save.jsp
	 * @throws IOException
	 */
	
	@Execute(validator = false)
	public String save() throws IOException {
		request.setCharacterEncoding("UTF-8");

		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		JdbcManager jdbcManager = (JdbcManager)container.getComponent(JdbcManager.class);
		
		String name = request.getParameter("name");
		String zipcode = request.getParameter("postnumber");
		String homeaddress = request.getParameter("homeaddress");
		String emailaddress = request.getParameter("emailaddress");
		
		List <SaveDto> savelist = new ArrayList <SaveDto> ();
		
		Save save = new Save();
		save.name = name;
		save.zipcode = zipcode;
		save.homeaddress = homeaddress;
		save.emailaddress = emailaddress;
		
		SaveDto saveDto = new SaveDto();
		saveDto.setName(name);
		saveDto.setZipcode(zipcode);
		saveDto.setHomeaddress(homeaddress);
		saveDto.setEmailaddress(emailaddress);
		
		savelist.add(saveDto);
		
		int count = jdbcManager
				.insert(save)
				.execute();
		
		List <SavingDto> list = new ArrayList<SavingDto>();
		List <Save> result = saveService.getresultjSQLfromSave();
		Iterator <Save> iterator = result.iterator();
		
		while(iterator.hasNext()){
			Save savings = (Save) iterator.next();
			SavingDto sdto = new SavingDto();
			
			sdto.setName(savings.name);
			sdto.setZipcode(savings.zipcode);
			sdto.setHomeaddress(savings.homeaddress);
			sdto.setEmailaddress(savings.emailaddress);
			list.add(sdto);
		}
		
		
		request.setAttribute("list", list);
		
		return "save.jsp";
	}
	
}
