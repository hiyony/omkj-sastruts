package sastruts.omikuji.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.annotation.Required;

import sastruts.omikuji.dto.OmikujiiDto;
import sastruts.omikuji.entity.Fortunemaster;
import sastruts.omikuji.entity.Omikujii;
import sastruts.omikuji.entity.Unseiresult;
import sastruts.omikuji.form.InputForm;
import sastruts.omikuji.form.OutputForm;
import sastruts.omikuji.others.Unsei;
import sastruts.omikuji.service.FortunemasterService;
import sastruts.omikuji.service.OmikujiiService;
import sastruts.omikuji.service.UnseiresultService;

public class OutputAction {
	
	@Required
	@ActionForm
	protected OutputForm outputform;
	protected InputForm inputform;
	
	@Resource
	protected FortunemasterService fmservice;
	protected OmikujiiService omkjservice;
	protected UnseiresultService unseiservice;

	@Resource
	private static final String path = "/omkj-sastruts/csvomkj.csv";
	
	@Resource
	private static final String INSERTSQL_FM = "sastruts/omikuji/entity/FortunemasterInsert.sql";
	private static final String INSERTSQL_OMKJ = "sastruts/omikuji/entity/OmikujiiInsert.sql";
	private static final String INSERTSQL_UR = "sastruts/omikuji/entity/UnseiresultInsert.sql";
	
	@SuppressWarnings("resource")
	@Execute(validator = false)
	public String output() throws IOException {
		
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		JdbcManager jdbcManager = (JdbcManager)container.getComponent(JdbcManager.class);
		
		BufferedReader br = null;
		List <Fortunemaster> fortuneList = fmservice.getselectSQLfromFm(new Fortunemaster());
		
		Map<String, String> unseiMap = new HashMap<String, String>();
		
		for (Iterator <Fortunemaster> iterator = fortuneList.iterator(); iterator.hasNext();){
			Fortunemaster fortunemaster = (Fortunemaster) iterator.next();
			unseiMap.put(fortunemaster.unseiname, fortunemaster.unseicode);
		}
		if(unseiMap.isEmpty()){
			String line;
			br = new BufferedReader(new FileReader(path));
			br.readLine();
			
			while((line = br.readLine()) != null) {
				String [] values = line.split(",");
				if(!unseiMap.keySet().contains(values[1])) {
					unseiMap.put(values[1], values[0]);
				}
			}
			
			jdbcManager.updateBySqlFile(INSERTSQL_FM).execute();   
			for (Map.Entry<String, String> entry : unseiMap.entrySet()) {
				//後でまた試しましょう
			}
		}
		
		int cnt = (int) omkjservice.countSQLfromOmkj(new Omikujii());
		if (cnt == 0){
			String line;
			
			br = new BufferedReader(new FileReader(path));
			br.readLine();
			
			jdbcManager.updateBySqlFile(INSERTSQL_OMKJ).execute();
			while ((line = br.readLine()) != null){
				//後でまた試しましょう
			}
		}
		
		List <Unseiresult> compareList = unseiservice.getcompareSQLfromUr(new Unseiresult());
		
		List <Omikujii> resultList = omkjservice.getresultSQLfromOmkj(new Omikujii());
		Unsei unsei = null;
		for (Iterator <Omikujii> iterator = resultList.iterator(); iterator.hasNext();){
			Omikujii omikuji = (Omikujii) iterator.next();
			//unsei = Selectunsei.selectUnsei(omikuji.unseiname);
			unsei.setOmikujicode(OmikujiiDto.omikujiID);
			unsei.setUnsei();
			unsei.setNegaigoto(omikuji.negaigoto);
			unsei.setAkinai(omikuji.akinai);
			unsei.setGakumon(omikuji.gakumon);
			
			jdbcManager.updateBySqlFile(INSERTSQL_UR).execute();
			//後でまた試しましょう
		}
		return "output.jsp";
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
