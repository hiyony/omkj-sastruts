package sastruts.omikuji.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;
import org.seasar.struts.util.ResponseUtil;

import sastruts.omikuji.dto.InfoDto;
import sastruts.omikuji.entity.Postinfo;
import sastruts.omikuji.form.InfoForm;
import sastruts.omikuji.form.OutputForm;
import sastruts.omikuji.service.PostinfoService;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InfoAction {
	@Required
	@ActionForm
	protected InfoForm infoForm;
	
	@ActionForm
	protected OutputForm outputForm;
	
	@Resource
	protected PostinfoService postinfoService;
	
	@Resource
	protected HttpServletRequest request;
	
	private static final String path = "/Users/h_kim/Documents/workspace/omkj-sastruts/postnumber.CSV";
	
	@SuppressWarnings("resource")
	@Execute(validator = false)
	public String info() throws IOException {
		
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		JdbcManager jdbcManager = (JdbcManager)container.getComponent(JdbcManager.class);
		
		BufferedReader br = null;
		
		int cnt = (int)postinfoService.countSQLfromPostinfo(new Postinfo());
		
		if (cnt == 0) {
			String line;
			
			br = new BufferedReader(new FileReader(path));
			
			while ((line = br.readLine()) != null){
				String [] values = line.split(",");
				Postinfo post = new Postinfo();
				//2,6,7,8
				post.postnumber = values[2];
				post.homeaddress1 = values[6];
				post.homeaddress2 = values[7];
				post.homeaddress3 = values[8];
				
				int count = jdbcManager
						.insert(post)
						.execute();
				
			}
		}
		
		
		String zipcode = request.getParameter("postnumber");
		Postinfo address = postinfoService.getresultSQLfromPinfo(zipcode);
		String fulladdress = address.homeaddress1 + address.homeaddress2 + address.homeaddress3;
		
		InfoDto dto = new InfoDto();
		dto.zipcode = zipcode;
		dto.address = fulladdress;
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dto);
		ResponseUtil.write(json, "application/json", "Shift_JIS");
		
		return null;
	}

}
