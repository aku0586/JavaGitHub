/*
 * 작성된 날짜: 2005-11-25
 *
 * 이 생성된 파일에 대한 템플리트를 변경하려면 다음으로 이동하십시오.
 * 창&gt;환경설정&gt;Java&gt;코드 생성&gt;코드 및 주석
 */
package pac;

import java.util.Properties;







import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400PackedDecimal;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;

/**
 * @author smna
 *
 * 이 생성된 유형 주석에 대한 템플리트를 변경하려면 다음으로 이동하십시오.
 * 창&gt;환경설정&gt;Java&gt;코드 생성&gt;코드 및 주석
 */
public class AS400Program {
	
	Properties properties = new Properties();
/*	Configuration conf = new Configuration();
	String hostIp = conf.getProperty("com.amway.eshop.as400pgm.ip");
	String userId = conf.getProperty("com.amway.eshop.as400pgm.id");
	String password = conf.getProperty("com.amway.eshop.as400pgm.password");*/
	
	
	String hostIp = "amwkor01";
	String userId = "au0586";
	String password = "amway";
	
	protected static boolean TEST_MODE = false; //true면 test모드, false면 server모드임

	private String programName;
	
	String MSG_DESC = "";
	
	AS400 as400 = null;
	ProgramCall programCall = null;
	ProgramParameter parameterList[] = null;
	AS400DataType[] parameterTypeList = null;
	
	
	public AS400Program() {
		as400 = new AS400( hostIp, userId, password);
		programCall = new ProgramCall( as400);
	}
	
	public void finalize() {
		if( as400 != null) {
			as400.disconnectAllServices();
		}
	}
	
	public void setParameter( int index, String value) throws Exception {
		AS400DataType dataType = parameterTypeList[ index];
	if( dataType instanceof AS400PackedDecimal) {
			((AS400PackedDecimal) dataType).toBytes( Utility.parseDouble( value));
			parameterList[index].setInputData(((AS400PackedDecimal) dataType).toBytes( Utility.parseDouble( value)));
		} else {
			parameterList[index].setInputData( dataType.toBytes(value));
		}

		parameterList[index].setInputData( dataType.toBytes(value));
		
	}

	
	
	
	
	
	public void setParameter( int index, double value) throws Exception {
		
		
		AS400DataType dataType = parameterTypeList[ index];
		//if( dataType instanceof AS400PackedDecimal) {
			//((AS400PackedDecimal) dataType).toBytes( value);
		//	parameterList[index].setInputData( ((AS400PackedDecimal) dataType).toBytes( value));
	//	} else {
			parameterList[index].setInputData( dataType.toBytes( String.valueOf( value)));
			
	//	}
	}

	public String getParameter( int index) throws Exception {
		ProgramParameter param = parameterList[index];
		AS400DataType dataType = parameterTypeList[ index];
		
		
		if( param==null) {
			return "";
		}
		byte[] data = param.getOutputData();
		if( data==null) {
			return "";
		}
		return dataType.toObject( data).toString();
	}

	
	private String getClassName( Object obj) {
		String s = obj.getClass().getName();
		int p = s.lastIndexOf(".");
		if( p==-1) return s;
		else {
			return s.substring( p+1);
		}
	}
	public boolean call() {
		if( programName == null) {
			
			setMSG_DESC("프로그램이 설정되지 않았습니다.");
		//	Logger.as400inv.println("프로그램이 설정되지 않았습니다.");
			System.out.println("프로그램이 설정되지 않았습니다.");
			return false;
		}
		try {
			System.out.println( "Preparing " + programName);
			StringBuffer paramLog = new StringBuffer();
			for (int i = 0; i < parameterList.length; i++) {

				System.out.println( "param " + i + " ( " + getClassName( parameterTypeList[i])+ ")  : [" + parameterTypeList[i].toObject( parameterList[i].getInputData()) + "]");
				paramLog.append("[" + parameterTypeList[i].toObject( parameterList[i].getInputData()) + "]");
				
			}
			System.out.println("Preparing " + programName + paramLog.toString());
		//	Logger.as400inv.println("Preparing " + programName + paramLog.toString());
			
			programCall.setProgram( programName, parameterList);
		  
			// Run the program
			if (! programCall.run()) {
				// Show the messages
				AS400Message[] messagelist = programCall.getMessageList();
	
				for (int i=0; i < messagelist.length; i++) {
					MSG_DESC += messagelist[i].getText();
				}
				return false;
			}
			System.out.println( "Call end " + programName);
			paramLog = new StringBuffer();
			for (int i = 0; i < parameterList.length; i++) {
				System.out.println( "param " + i + " ( " + getClassName( parameterTypeList[i])+ ")  : [" + parameterTypeList[i].toObject( parameterList[i].getOutputData()) + "]");
				paramLog.append("[" + parameterTypeList[i].toObject( parameterList[i].getOutputData()) + "]");
			}
			System.out.println("Call end " + programName + paramLog.toString());
	//		Logger.as400inv.println("Call end  " + programName + paramLog.toString());
			return true;
			
		} catch (Exception e) {
			setMSG_DESC( "AS400 프로그램 호출 중 오류가 발생했습니다.  프로그램명 : " + programName + " 오류 : " + e.getClass().getName() + " - " + e.getMessage() );
		//	Logger.as400inv.println("AS400 프로그램 호출 중 오류가 발생했습니다.  프로그램명 : " + programName + " 오류 : " + e.getClass().getName() + " - " + e.getMessage() );
			return false;
		}
	}
	/**
	 * @return
	 */
	public String getMSG_DESC() {
		return MSG_DESC;
	}

	/**
	 * @return
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * @param string
	 */
	public void setMSG_DESC(String string) {
		MSG_DESC = string;
	}

	public void setMSG_DESC(Exception e) {
		MSG_DESC = "AS400호출 중 오류가 발생했습니다. 프로그램 :  " + programName + " 오류 : " + e.getClass().getName() + " - " + e.getMessage();
	}

	/**
	 * @param string
	 */
	public void setProgramName(String string) {
		programName = string;
		
	
	}

	/**
	 * @return
	 */
	public AS400DataType[] getParameterTypeList() {
		return parameterTypeList;
	}

	/**
	 * @param types
	 */
	public void setParameterTypeList(AS400DataType[] types) {
		parameterTypeList = types;
		parameterList = new ProgramParameter[ parameterTypeList.length];
		AS400DataType dataType;
		for (int i = 0; i < parameterList.length; i++) {
			dataType = parameterTypeList[ i];
			
		
			
			parameterList[i]  = new ProgramParameter( dataType.toBytes( dataType.getDefaultValue()), dataType.getByteLength());
			System.out.println("이건 된거지"+ i );
		}		
	}
	
}
