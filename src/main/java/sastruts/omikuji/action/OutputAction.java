package sastruts.omikuji.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import sastruts.omikuji.others.Selectunsei;
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
	
//	@Resource
//	private static final String INSERTSQL_FM = "sastruts/omikuji/entity/FortunemasterInsert.sql";
//	private static final String INSERTSQL_OMKJ = "sastruts/omikuji/entity/OmikujiiInsert.sql";
//	private static final String INSERTSQL_UR = "sastruts/omikuji/entity/UnseiresultInsert.sql";
	
	@SuppressWarnings("resource")
	@Execute(validator = false)
	public String output() throws IOException {
		
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		JdbcManager jdbcManager = (JdbcManager)container.getComponent(JdbcManager.class);
		
		BufferedReader br = null;
		List <Fortunemaster> fortuneList = fmservice.getselectSQLfromFm(new Fortunemaster());
		
		Map<String, String> unseiMap = new HashMap<String, String>();
		Iterator <Fortunemaster> iterator = fortuneList.iterator();
		
		while (iterator.hasNext()){
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
			
			//jdbcManager.updateBySqlFile(INSERTSQL_FM).execute();   
			//fortunemaster テーブルに値セットする
			for (Map.Entry<String, String> entry : unseiMap.entrySet()) {
				//直したInsertの部分
				Fortunemaster fm = new Fortunemaster();
				fm.unseiname = entry.getKey();
				fm.unseicode = entry.getValue();
				fm.renewalwriter = "ヒヨン";
				fm.renewaldate = OmikujiiDto.todayString;
				fm.unseiwriter = "ヒヨン";
				fm.unseiwritedate = OmikujiiDto.todayString;
				
				int count = jdbcManager
						.insert(fm)
						.execute();
			}
		}
		
		int cnt = (int) omkjservice.countSQLfromOmkj(new Omikujii());
		
		if (cnt == 0){
			String line;
			
			br = new BufferedReader(new FileReader(path));
			br.readLine();
			
			//jdbcManager.updateBySqlFile(INSERTSQL_OMKJ).execute();
			while ((line = br.readLine()) != null){
				//直したInsertの部分
				Omikujii omkj = new Omikujii();
				
				String [] values = line.split(",");
				
				omkj.omikujicode = Integer.toString(cnt + 1);
				omkj.unseicode = unseiMap.get(values[1]);
				omkj.negaigoto = values[2];
				omkj.akinai = values[3];
				omkj.gakumon = values[4];
				omkj.renewalwriter = "ヒヨン";
				omkj.renewaldate = OmikujiiDto.todayString;
				omkj.unseiwriter = "ヒヨン";
				omkj.unseiwritedate = OmikujiiDto.todayString;
				cnt++;
				
				int count = jdbcManager
						.insert(omkj)
						.execute();
			}
		}
		
		List <Unseiresult> compareList = unseiservice.getcompareSQLfromUr(new Unseiresult());
		
		Unseiresult unseirs = new Unseiresult();
		
		Iterator<Unseiresult> iterator2 = compareList.iterator();
		while(iterator2.hasNext()){
			OmikujiiDto.omikujiID = unseirs.omikujicode; //エラーかも
		}
		
		if(OmikujiiDto.omikujiID.isEmpty()){
			int rannum = new Random().nextInt(cnt) + 1;
			OmikujiiDto.omikujiID = String.valueOf(rannum);
		}
		
		List <Omikujii> resultList = omkjservice.getresultSQLfromOmkj(new Omikujii());
		Iterator <Omikujii> iterator3 = resultList.iterator();
		
		Unsei unsei = null;
		while (iterator3.hasNext()){
			Omikujii omkj = (Omikujii) iterator3.next();
			Fortunemaster fm = new Fortunemaster(); //エラーかも
			unsei = Selectunsei.selectUnsei(fm.unseiname); //エラーかも
			unsei.setOmikujicode(OmikujiiDto.omikujiID);
			unsei.setUnsei();
			unsei.setNegaigoto(omkj.negaigoto);
			unsei.setAkinai(omkj.akinai);
			unsei.setGakumon(omkj.gakumon);
			
			//jdbcManager.updateBySqlFile(INSERTSQL_UR).execute();
			Unseiresult ur = new Unseiresult();
			
			ur.uranaidate = OmikujiiDto.todayString;
			ur.birthday = OmikujiiDto.birthday;
			ur.omikujicode = OmikujiiDto.omikujiID;
			ur.renewalwriter = "ヒヨン";
			ur.renewaldate = OmikujiiDto.todayString;
			ur.unseiwriter = "ヒヨン";
			ur.unseiwritedate = OmikujiiDto.todayString;
			
			int count = jdbcManager
					.insert(ur)
					.execute();
		}
		
		OutputForm.setUnsei(unsei.getUnsei());
		OutputForm.setNegaigoto(unsei.getNegaigoto());
		OutputForm.setAkinai(unsei.getAkinai());
		OutputForm.setGakumon(unsei.getGakumon());
		
		return "output.jsp";
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
