package sastruts.omikuji.action;

import java.io.IOException;
import java.util.ArrayList;
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
import sastruts.omikuji.entity.Save;
import sastruts.omikuji.form.SaveForm;

public class SaveAction {
	@Required
	@ActionForm
	protected SaveForm saveForm;

	@Resource
	protected HttpServletRequest request;
	
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
		
		List <SaveDto> list = new ArrayList <SaveDto> ();
		
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
		
		list.add(saveDto);
		
		int count = jdbcManager
				.insert(save)
				.execute();
		
		request.setAttribute("list", list);
		
		return "save.jsp";
	}
	
}
