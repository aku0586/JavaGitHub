/**
 * Date : 2007-02-25
 * Author :  Choi heenam
 * 
 * Description : AS400과 통신하는 클래스 
 *  
 *//*
package com.amway.abnm.ma.conn;

import java.util.List;


import com.amway.abnm.ma.handler.dao.RPGParameter;
import com.amway.abnm.ma.handler.dao.RPGSpec;
import com.amway.abnm.ma.log.LogManager;
import com.amway.abnm.ma.model.BaseModel;
import com.amway.abnm.ma.util.ConfigurationUtil;
import com.amway.abnm.ma.util.LoggerUtil;
import com.amway.abnm.ma.util.StringUtil;

import com.ibm.as400.access.AS400ConnectionPool;
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400PackedDecimal;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ProgramParameter;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.AS400Message;


public class RPGConnector extends ABNConnector {
	
	private RPGSpec rpgSpec;
	
	static boolean usePool = true;
	public static AS400ConnectionPool pool = new AS400ConnectionPool();
	static int connectionCount = 0;
		
	private final String I_SYSTEM = "10.181.194.31";		// 기본 값 server ip
	
	// 실서버
//	private final String I_USER_ID = "INTER194";
//	private final String I_PASSWORD = "EASY194";
	
	// 테스트용 
	private final String I_USER_ID = "INTER101";			// 기본 값 유저 id
	private final String I_PASSWORD = "EASY101";		// 기본 값 유저 pw 
	
	private String system;		//AS/400 시스템의 IP주소
	private String userId;			//유저 아이디
	private String password;	//비밀번호
	 
	String message = "";
	
	static {
		
		// 클래스가 처음 로딩될시 이 메서드를 호출한다.
		// (이 static 메서드는 한번 호출이 되면 더이상 호출이 안되므로 설정에서 Reload를 반드시 해줘야 한다.
		 
		initConnectionPool();
		
	}

	public RPGConnector( LogManager logManager, BaseModel baseModel) {
		
		super( logManager , baseModel);
		
	}
	
	*//**
	 * abnmodule.property 로부터 AS400 connection 설정을 load 한다 
	 * 아래에 있는  ConfigurationUtil 의 프로퍼티는 abnmodule.properties 파일의 내용을 실시간으로 가져와서 반영한다.
	 *//*
	protected void loadConfig() {
		
		ConfigurationUtil conf = new ConfigurationUtil();
		
		try{
	
			system = conf.getProperty("rpg.ip");		//AS/400서버아이피
			
			if (system == null || system.length() == 0)
				system = I_SYSTEM; 
			
			
			// XML에서 사용자가 USER_ID를 직접 입력했을 경우
			if ( model.getAs400_userID() != null && model.getAs400_userID().length() > 0 ){
	
					userId = model.getAs400_userID();		//RPG
					
					password = conf.getProperty(userId);	//여기서 키가 존재하지 않을시 Exception이 떨어진다.				
	 
			}
			else
			{ 
				
				userId = conf.getProperty("rpg.userid");
				 
				if (userId == null || userId.length() == 0)
					userId = I_USER_ID; 
				
				password = conf.getProperty("rpg.password");
				
				if (password == null || password.length() == 0)
					password = I_PASSWORD; 
						
			}
			
			
		}catch(RuntimeException rte){		
			
			userId = I_USER_ID;			
			password = I_PASSWORD;			
			
			model.setMessage(rte.toString());
			
		}		
			
	}
	
	*//**
	 * AS400과의 connection pool 초기화
	 * 이 클래스가 초기에 처음 실행시에 단!!! 한번만 로딩이 된다.(호출될때마다 로딩이 안됨)
	 * 이 클래스를 호출시에 new 생성자를 사용해서 안하기 때문이다. 
	 *//*
	synchronized public static void initConnectionPool() {
		try {

			pool.setMaxConnections(256);		// 최대 오픈할수 있는 커넥션 수

			pool.setMaxLifetime(1000 * 20); // 커넥션이 살아 있는 시간 set maximum connection life time to 20 second(Number of MilliSecond) 

			pool.setMaxUseCount(100); 	// 초기 커넥션 사용 연결수
			
			pool.setMaxUseTime(60 * 1 * 1000);		// 400 커넥션의 접속 최대 허용시간
			
			pool.setMaxInactivity(60 * 1* 1000);		// 미사용 제한시간 : 활동하지 않을시에 죽어버리는 시간   
			
			ConfigurationUtil conf = new ConfigurationUtil();  
			
			// 초기값 설정
			
			pool.setMaxConnections(  Integer.parseInt( conf.getProperty("rpg.pool.maxsize")));		// 최대 커넥션수
			LoggerUtil.debug( "rpg.pool.maxsize: " + conf.getProperty("rpg.pool.maxsize")); 
 
			pool.setMaxLifetime(  Integer.parseInt( conf.getProperty("rpg.pool.maxlifetime")));			// 커넥션의 수명시간
			LoggerUtil.debug( "rpg.pool.setMaxLifetime : " + conf.getProperty("rpg.pool.maxlifetime")); 
		
			pool.setMaxUseCount(  Integer.parseInt( conf.getProperty("rpg.pool.maxusecount")));		// 최대 사용수
			LoggerUtil.debug( "rpg.pool.setMaxUseCount : " + conf.getProperty("rpg.pool.maxusecount"));		
		
			pool.setMaxUseTime(  Integer.parseInt( conf.getProperty("rpg.pool.maxusetime")));			// 최대 사용시간
			LoggerUtil.debug( "rpg.pool.setMaxUseTime : " + conf.getProperty("rpg.pool.maxusetime"));		
			
			pool.setMaxInactivity(  Integer.parseInt( conf.getProperty("rpg.pool.maxinactivity")));			// 커넥션시 최대  활동시간
			LoggerUtil.debug( "rpg.pool.setMaxInactivity : " + conf.getProperty("rpg.pool.maxinactivity"));			
			
			
			String SYSTEM = conf.getProperty("rpg.ip");	// AS/400 서버 IP 주소
			
			// 유저 별로 초기 커넥션을 채운다.(커넥션 가속 향상을 위해 해준다.)
			int iUserCount = Integer.parseInt( conf.getProperty("rpg.pool.fillusercount"));
			
			for(int iLoop = 1 ; iLoop <= iUserCount ; iLoop++  ){ 
				
				String sUserInfo = conf.getProperty("rpg.pool.filluser" + iLoop);	// (유저명/동시유저수)
				
				try{
				
					String[] aStrUserInfo = StringUtil.split( sUserInfo ,  "/" );		// "/" 문자열로 배열로 나눈다.
					
					String sUser = aStrUserInfo[0].trim();			// 유저명 추출   = 혹 공백이 포함될 우려가 있으니 양쪽 공백제거
					
					int iDefaultUserCount = Integer.parseInt( aStrUserInfo[1].trim().toUpperCase() );  // 패스워드 추출 	
					
					String sPassword = conf.getProperty(sUser); 		// 유저의 패스워드를 들고온다.
					
					pool.fill( SYSTEM ,  sUser , sPassword , AS400.COMMAND ,  iDefaultUserCount );  // <--  바로 이부분이 커넥션 가속 향상을 위해 쓰인다.
					
					LoggerUtil.debug("### 커넥션 풀 재생성 됨 시스템[" + SYSTEM + "] 유저 [" + sUser +  "] 비번[" + sPassword+ "] 초기커넥션수 [" + iDefaultUserCount + "] ###" );
										
				}catch(Exception eX){
					
					LoggerUtil.debug("초기 커넥션 풀 생성시 예외발생 유저명/초기카운트명[ " +  sUserInfo + "]"); 
				
				}
			}
			
			
		} catch (Exception e) {
			
			LoggerUtil.debug("Error while initializing connection pool");
			
			usePool = false;
			
			e.printStackTrace();
			
		}
		
		usePool = true;
	}
	
	*//**
	 * 커넥션 풀에서 AS400 connection을 가져온다.
	 * 만약  AS/400 Connection Pool 이 가동된다면 커넥션 풀에서 AS400 커넥션을 가져오고
	 *  커넥션 풀이 가동되지 않으면  커넥션풀이 가동되지 않는 AS400 커넥션을 가동한다.
	 * @return - AS/400 커넥션 객체
	 * @throws Exception
	 *//*
	//2014.03.31 remove synchronized
	private AS400 getConnection() throws Exception {
		if( usePool) {
			AS400 conn =  pool.getConnection(system, userId, password, AS400.COMMAND);
		//	LoggerUtil.debug("getConnection.["+userId+"] Active/Avail = " + pool.getActiveConnectionCount( system, userId) + "/" + pool.getAvailableConnectionCount( system, userId));
			return conn;
		} else {
			synchronized (this) {
				AS400 conn = new AS400( system, userId, password);
				connectionCount ++ ;
			//	LoggerUtil.debug("getConnection. count = " + connectionCount);
				return conn;
			}
		}
	}
	
//	synchronized private AS400 getConnection() throws Exception {
//		if( usePool) {
//			AS400 conn =  pool.getConnection(system, userId, password, AS400.COMMAND);
//			LoggerUtil.debug("getConnection. Active/Avail = " + pool.getActiveConnectionCount( system, userId) + "/" + pool.getAvailableConnectionCount( system, userId));
//			return conn;
//		} else {
//			AS400 conn =new AS400( system, userId, password);; 
//			connectionCount ++ ;
//			LoggerUtil.debug("getConnection. count = " + connectionCount);
//			return conn;
//		}
//	}
	
	*//**
	 * AS400 커넥션 반환
	 * RPG 프로그램을  호출한 AS400 커넥션을 커넥션 풀에 반환한다.
	 * @param conn
	 *//*
	private  void returnConnection( AS400 conn) {
		if( usePool) {
			pool.returnConnectionToPool( conn);
			LoggerUtil.debug("returntConnection. Active/Avail = " + pool.getActiveConnectionCount( system, userId) + "/" + pool.getAvailableConnectionCount( system, userId));
		} else {
			conn.disconnectAllServices();
			connectionCount -- ;
			LoggerUtil.debug("getConnection. count = " + connectionCount);
		}
	}
	
	
	
	*//**
	 * AS400과 connect 하여 해당 AS400 program을 실행한다
	 *  
	 * @param progName  RPG프로그램명
	 * @param paramList RPG프로그램의 파라미터(paramList[배열] )
	 * @return boolean 성공적으로 호출했는지 실패 했는지 여부(성공 :true , 실패 :false)
	 *//*
	public boolean call( String progName, ProgramParameter[] paramList) {
		//		Call programs on system "Hal"
		LoggerUtil.debugIn( this, "Call " + progName);
		
		AS400 as400 = null;
		ProgramCall pgm = null;
		boolean result = false;
		
		try {

			as400 = getConnection();
			
			pgm = new ProgramCall(as400);			
			
			//		Set the program name and parameter list
			pgm.setProgram(progName, paramList);
			
			//		Run the program
			LoggerUtil.debug("Calling " + progName);
			result =pgm.run();
			
			String msg = "Program call failed : " + progName + "\n";
			AS400Message[] messagelist = pgm.getMessageList();
			for (int i = 0; i < messagelist.length; i++) {
				msg += messagelist[i] + "\n";
			}
			setMessage( msg);
			LoggerUtil.debug("Call " + progName  + " Ok");
		} catch (Exception e) {
			this.setMessage("Error on calling RPG program : " + e.getClass().getName() + " : " +  e.getMessage());
			e.printStackTrace();
		} finally {
			//		done with the system
			if( as400 != null) {
				returnConnection( as400);
			}
		}
		
		LoggerUtil.debugOut();
		return result;		
	}
	
	
	*//**
	 * Request XML 객체를  RPG_PARAMETER과 매칭하여 RPG 파라미터를 셋팅하여 RPG프로그램을 호출한다. 
	 * 1. voModel의 각 field를 AS400용 program의 parameter에 세팅하고 
	 * 2. call()을 불러 AS400과 통신한 후에 
	 * 3. output 이 있는 field들을 voModel에 update 하여 return 한다.
	 *  
	 * @param model  RPG프로그램명
	 *//*	
	public void invoke() {
		this.rpgSpec = model.getRpgSpec();


		String progName = rpgSpec.getProgram_path();		// 디폴트로는 DB에서 RPG프로그램명을 가져온다.

		// XML에서 RPG_PATH가 설정되어 잇을 시에는 XML에서 RPG프로그램명을 가져온다.
		if( model.getRpg_path() != null && model.getRpg_path().length() > 0 ){
			//LoggerUtil.debug("XML파일프로그램명:(" + model.getRpg_path() + ")");
			progName = model.getRpg_path();
		}		
		
		
		LoggerUtil.debugIn( this, "invoke " + progName);
		
		try {			 
			String tranId = progName;	// AS400의 해당하는 program 이름
			
			int p = tranId.lastIndexOf("/");
			if( p!=-1) {
				tranId = tranId.substring( p+1);
			}
			p = tranId.lastIndexOf(".");
			if( p!=-1) {
				tranId = tranId.substring( 0, p);
			}
			 
			*//** 1. set parameters *//*
			LoggerUtil.debug("1. Preparing parameters in RPGConnector CLASS");			
			String msg = "Calling " + progName;
			
			List paramList = rpgSpec.getParameterList();						
			ProgramParameter[] parmlist = new ProgramParameter[ paramList.size() ];		//프로그램 파라미터의 배열은 최대 35개 까지만 허용가능하다.
			
			for (int i=0; i < paramList.size(); i++) {
				RPGParameter param = (RPGParameter) paramList.get(i);
				byte[] bytes = getBytes(param, model);
				 
				if (param.getInput_output().equalsIgnoreCase("I")) 
					parmlist[i] = new ProgramParameter ( bytes);
				else 					
					parmlist[i] = new ProgramParameter ( bytes, param.getSize());				
			}
									
			
			*//** 2. AS400으로 call 한다 *//* 
			if ( call( progName, parmlist) != true) {
				
				*//** exception occurred (RPG 실패시 로그를 남긴다)*//*		
				model.setMessage(getMessage() + "  ,Program[" + progName + "]");				
				LoggerUtil.debug("RPG Connector invoke failed : " + getMessage() + "  ,Program[" + progName + "] RequestXml[" +model.getRequestXml() + "]");				
				LoggerUtil.debugOut();
				
				return;
				
			}						
			
			*//** 3. update 된 parameter를 해당 field에 update 한다 *//*									 
			LoggerUtil.debug("3. Gathering results in RPGConnector CLASS");
			msg = "Called " + progName;
			
			for (int i = 0; i < parmlist.length; i++) {
				RPGParameter param = (RPGParameter) paramList.get(i);
				String seq = param.getSeq();
				
				//	INPUT 인 경우는 continue
				if(param.getInput_output().equalsIgnoreCase("I")) {
					LoggerUtil.debug("param" + i + "(" + param.getField() + ") = <INPUT ONLY>");
					continue;
				}
 
				// OUTPUT, BOTH 인 경우 해당 field에 update
				byte[] bytes = parmlist[i].getOutputData();				
				
				 if( bytes != null) {
				 					 	 
				 	updateParameter(param, model, bytes);
					LoggerUtil.debug("param" + i + "(" + param.getField() + ") = [" + model.getField(param.getField().toUpperCase()) + "]");

				 } else {
				 	
					model.addField(param.getField().toUpperCase(), "");
					LoggerUtil.debug("param" + i + "(" + param.getField() + ") = NULL");
					
				 }
				
			} // end for
					  
			*//** set responseXML *//*
			String xmlData = model.toXML(); 	
			model.setResponseXml(xmlData);
			
			LoggerUtil.debug("Call " + progName  + " Ok");
			
		} catch (Exception e) {
			model.setMessage( "Error on invoking RPG program : " + e.getClass().getName() + " : " +  e.getMessage() + "  : Program[" + progName + "]");
			LoggerUtil.debug("Error on invoking RPG program : " + e.getClass().getName() + " : " +  e.getMessage() + "  : Program[" + progName + "] : RequestXml[" +model.getRequestXml() + "]");
			e.printStackTrace();
		} finally {
		}
		LoggerUtil.debugOut();
	}	


	
	*//**
	 * AS400에서 가져온 Data를 field에 update 한다 
	 * @param param - RPG파라미터
	 * @param model - 모델
	 * @param buffer - 받아온 바이트 데이터
	 *//*
	private void updateParameter(RPGParameter param, BaseModel model, byte[] buffer) {

		String seq = param.getSeq();
		List subParamList = rpgSpec.getSubParameterList(seq);

		//	TODO sub paramete에 결과값 세팅하는 문제
		//           field 가 중복될때의 처리여부				
		*//** sub parameter를 가지고 있음 *//*
		if (subParamList != null && subParamList.size() > 0) {
					
			int offset = 0;
			String fullValue = "";

			for (int k=0; k < subParamList.size(); k++) {
				
				RPGParameter subParam = (RPGParameter) subParamList.get(k);
				
				String value = getValueFromBytes(subParam, model, buffer, offset);
				
				value = StringUtil.SpecialCharConvert(value);	// XML에 허용되지 않는 특수문자 제거
				
				fullValue += value;
				
				if (StringUtil.isNotEmpty(value.trim())){
					
					model.addField(subParam.getField().toUpperCase(), value);
										
				}else{
					
					model.addField(subParam.getField().toUpperCase(), "");
										
				}

													
				offset += subParam.getSize();
				
			}			

			model.addField(param.getField().toUpperCase(), fullValue);
		} 
  				
		*//** sub parameter를 가지고 있지 않음 *//*
		else {					
							
			String value = getValueFromBytes(param, model, buffer, 0);
			
			value = StringUtil.SpecialCharConvert(value);		// XML에 허용되지 않는 특수문자 제거
			
			if (StringUtil.isNotEmpty(value.trim())){
				
				model.addField(param.getField().toUpperCase(), value);
								
			}else{
				
				model.addField(param.getField().toUpperCase(), value);				
				
			}

						
		}					
	}

	*//**
	 * buffer 데이터를 받아서 offset 위치부터 param.getSize() 까지 잘라서 문자열로 보낸다.
	 * @param param - RPG파라미터
	 * @param model - 모델
	 * @param buffer - 받아온 바이트 데이터
	 * @param offset - 데이터 시작위치
	 * @return
	 *//*
	private String getValueFromBytes(RPGParameter param, BaseModel model, byte[] buffer, int offset) {
			
		String type = param.getType();		
		AS400DataType dataType = null; 
		String sReturnData = null; 

		try{
			
			if (type.equalsIgnoreCase("CHAR")){ 
				dataType = new AS400Text(param.getSize());
			}
			else
			{				 
				dataType = new AS400PackedDecimal(param.getSize(), 0); 
			}
			
			sReturnData = dataType.toObject( buffer, offset).toString();

		}catch(Exception e){
			
			
			// 길이관련 메세지 오류가 떳을시에 메세지를 핸드폰으로 보낸다. 			
			ConfigurationUtil conf = new ConfigurationUtil();
			
			conf.getProperty("msg_to_phone_number_1");
			conf.getProperty("msg_to_phone_number_2");

			model.getClientId();
			model.getDistNo(); 			// IBO번호
			model.getInterfaceId(); 	// RPG를 호출할때 쓰이는 고유한 별칭
			model.getAs400_userID(); 		// AS/400접속 아이디 (비밀번호는 프로퍼티에 셋팅되어 있음)
			model.getRpg_path();  					// RPG 호출 프로그램명
			
					
		}
		
		//LoggerUtil.debug("버퍼길이:(" + buffer.length + ") offset(" + offset + ")");		
		return sReturnData;				
	}	
	
	*//**
	 * AS400용 parameter에 세팅하기 위해 rpg parameter 값을 byte로 convert 한다 
	 * @param param - RPG 파라미터
	 * @param model - 모델
	 * @return 문자열을 byte로 반환한다.
	 *//*
	private byte[] getBytes(RPGParameter param, BaseModel model) {
		byte[] buffer = new byte[ param.getSize()];
		String paramValue = "";
		
		try {		
			String seq = param.getSeq();						
			List subParamList = rpgSpec.getSubParameterList(seq);
			
			*//** sub parameter를 가지고 있음 *//*
			if (subParamList != null && subParamList.size() > 0) {	
												
				for (int k=0; k < subParamList.size(); k++) {
					RPGParameter subParam = (RPGParameter) subParamList.get(k);
					String fieldValue = model.getField(subParam.getField().toUpperCase());
					
					if (subParam.getType().equalsIgnoreCase("CHAR"))						
						paramValue += StringUtil.getPackedText(fieldValue, subParam.getSize());
					else
						//paramValue += StringUtil.getNumberText(fieldValue, subParam.getSize());
						paramValue += StringUtil.getNumToText(fieldValue, subParam.getSize());
				}
														
			}					
			*//** sub parameter를 가지고 있지 않음 *//*
			else {
				String fieldValue = model.getField(param.getField().toUpperCase());
				
				if (param.getType().equalsIgnoreCase("CHAR"))
					paramValue = StringUtil.null2String(fieldValue);		// 키값이 없을 경우 null을 반환하므로 공백을 바꿔준다.
					//paramValue = StringUtil.getPackedText(fieldValue, param.getSize());
					//paramValue = fieldValue;
				else
					//paramValue = StringUtil.getNumberText(fieldValue, param.getSize());					
					paramValue = StringUtil.getNumToText(fieldValue, param.getSize());
				
			}
			
			LoggerUtil.debug("param" + "(" + param.getField() + ")[" + param.getSize() + "] =[" + paramValue + "](" + paramValue.getBytes("UTF-8").length + ")");

			*//** buffer에 value를 세팅 *//*
			if (param.getType().equalsIgnoreCase("CHAR")) {
				AS400Text dataType = new AS400Text(param.getSize());
				dataType.toBytes( paramValue, buffer);
			} else {	
				AS400PackedDecimal dataType = new AS400PackedDecimal(param.getSize(), 0);
				dataType.toBytes( Double.parseDouble(paramValue), buffer);
			}

		} catch(Exception e) {
			
			LoggerUtil.debug( "------------------- 예외발생 -------------------");
			LoggerUtil.debug( "error field name[" + param.getField() + "] error ");	// 필드명
			LoggerUtil.debug( "field size[" + param.getSize() + "] " );			
			LoggerUtil.debug( "field data[" + paramValue + "] " );
			LoggerUtil.debug( "ABN classid[" + model.getInterfaceId() + "] " );						
			LoggerUtil.debug( "error message[" + e.toString() + "] " );			 
			LoggerUtil.debug( "------------------------------------------");
			
			e.printStackTrace();
			
		}
		
		return buffer;		
	}	
		

	public String getMessage() {		return message;	}
	public void setMessage(String string) {		message = string;	}

		
//	/** 주문 최소 */
// 	invoke("/QSYS.LIB/OMPO314KOR.LIB/EEP5XFR.PGM", vo );

//	/** 주문 생성 */
//		return verifyOrder( vo);

//	/** 주문 검증 */
//			invoke("/QSYS.LIB/OMPO314KOR.LIB/EFJJXFR.PGM", vo );	// 배달주문

////			invoke("/QSYS.LIB/OMPO314KOR.LIB/EGEJXFR.PGM", vo );	
//			invoke("/QSYS.LIB/OMPO314KOR.LIB/EFIVXFR.PGM", vo );	// 픽업주문 

//	/** 주문 목록 조회 */
//		invoke("/QSYS.LIB/OMPO314KOR.LIB/INTERORD9.PGM", vo );

//	/** 주문 헤더 조회  */
//		invoke("/QSYS.LIB/OMPO314KOR.LIB/EG6FXFR.PGM", vo );

//	/** 주문 상세 조회 */
//		invoke("/QSYS.LIB/OMPO314KOR.LIB/EG6GXFR.PGM", vo );

//	/** 주소 변경 */
//		invoke("/QSYS.LIB/OMPO314KOR.LIB/EETJXFR.PGM", vo );



}
*/