package sastruts.omikuji.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import sastruts.omikuji.service.FortunemasterService;
import sastruts.omikuji.service.OmikujiiService;
import sastruts.omikuji.service.UnseiresultService;

/**
 * おみくじ結果取得Actionクラス。
 * Actionクラス、画面からの要求を制御するコントローラークラス。
 * おみくじデータベースから入力された誕生日のおみくじ結果を取得します。
 * 
 * @author h_kim
 * @version 1.0
 */

public class OutputAction {
	
	/** ActionFormクラス */
	@Required
	@ActionForm
	protected OutputForm outputForm;
	
	/** ActionFormクラス */
	@Required
	@ActionForm
	protected InputForm inputForm;
	
	/** Serviceクラス */
	@Resource
	protected FortunemasterService fortunemasterService;
	
	/** Serviceクラス */
	@Resource
	protected OmikujiiService omikujiiService;
	
	/** Serviceクラス */
	@Resource
	protected UnseiresultService unseiresultService;
	
	/** HTTPリクエスト */
	@Resource
	protected HttpServletRequest request;
	
	/** おみくじのCSVファイル */
	private static final String path = "/omkj-sastruts/csvomkj.csv";
	
	/**
	 * 入力されたお誕生日でおみくじの結果をランダムで取得する。
	 * 入力パラメーターはrequestから取得する(yyyyMMdd方式)
	 * 過去の結果の中に同じ誕生日と日付の結果がある場合、これを取得する。
	 * 新しい日付と誕生日の場合、ランダムで結果を取得する。
	 * 
	 * @return output.jsp
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	@Execute(validator = false)
	public String output() throws IOException {
		
		String birthday = request.getParameter("birthday");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar today = Calendar.getInstance();
		String todayString = df.format(today.getTime());
		
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		JdbcManager jdbcManager = (JdbcManager)container.getComponent(JdbcManager.class);
		
		BufferedReader br = null;
		List <Fortunemaster> fortuneList = fortunemasterService.getselectSQLfromFm(new Fortunemaster());
		
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
				fm.renewaldate = todayString;
				fm.unseiwriter = "ヒヨン";
				fm.unseiwritedate = todayString;
				
				int count = jdbcManager
						.insert(fm)
						.execute();
			}
		}
		
		int cnt = (int)omikujiiService.countSQLfromOmkj(new Omikujii());
		
		if (cnt == 0){
			String line;
			
			br = new BufferedReader(new FileReader(path));
			br.readLine();
			
			//jdbcManager.updateBySqlFile(INSERTSQL_OMKJ).execute();
			while ((line = br.readLine()) != null){
				//直したInsertの部分
				Omikujii omkj = new Omikujii();
				
				omkj.omikujicode = Integer.toString(cnt + 1);
				String [] values = line.split(",");
				omkj.unseicode = unseiMap.get(values[1]);
				omkj.negaigoto = values[2];
				omkj.akinai = values[3];
				omkj.gakumon = values[4];
				omkj.renewalwriter = "ヒヨン";
				omkj.renewaldate = todayString;
				omkj.unseiwriter = "ヒヨン";
				omkj.unseiwritedate = todayString;
				cnt++;
				
				int count = jdbcManager
						.insert(omkj)
						.execute();
			}
		}
		
		//omikujiIDを受け入れる
		//Unseiresult omkjid = new Unseiresult();
		//omkjid = unseiresultService.getcompareSQLfromUr(todayString, birthday);
		
		List <Unseiresult> omkjid = unseiresultService.getcompareSQLfromUr(todayString, birthday);
		
		Iterator <Unseiresult> it = omkjid.iterator();
		String omikujiID = null;
		
		while(it.hasNext()){
			Unseiresult unseiresult = (Unseiresult) it.next();
			omikujiID = unseiresult.omikujicode;
		}
		
		if(omikujiID == null){
			int rannum = new Random().nextInt(cnt) + 1;
			omikujiID = String.valueOf(rannum);
		}
		
		//Omikujii omkjgetcode = omikujiiService.findById(omikujiID);
		Omikujii omkjgetcode = omikujiiService.getresultSQLfromOmkj(omikujiID);
		
		Unseiresult result = new Unseiresult();
		result.uranaidate = todayString;
		result.birthday = birthday;
		result.omikujicode = omikujiID;
		result.renewalwriter = "ヒヨン";
		result.renewaldate = todayString;
		result.unseiwriter = "ヒヨン";
		result.unseiwritedate = todayString;
		
		int count = jdbcManager
				.insert(result)
				.execute();
		
		OmikujiiDto dto = new OmikujiiDto();
		dto.setOmikuji(omkjgetcode.fortunemaster.unseiname);
		dto.setNegaigoto(omkjgetcode.negaigoto);
		dto.setAkinai(omkjgetcode.akinai);
		dto.setGakumon(omkjgetcode.gakumon);
		request.setAttribute("dto", dto);
		
		
		return "output.jsp";
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
