package pac;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;

public class CallTestWASforOrder {

	String message;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	AS400 as400System = new AS400("amwkor01","aku0586","amway");
	String progName ;
	ProgramCall pgm = new ProgramCall (as400System);
	// paramList = 
	// pgm.setProgram(progName, paramList);
		
	}

	 public boolean call( String progName, ProgramParameter[] paramList,AS400 as400System) {
		
			ProgramCall pgm = null;
			boolean result = false;
			
			try {
				pgm = new ProgramCall(as400System);			
				
				//		Set the program name and parameter list
				pgm.setProgram(progName, paramList);
				
				
				result =pgm.run();
				System.out.println("result:" + result);
				String msg = "Program call failed : " + progName + "\n";
				AS400Message[] messagelist = pgm.getMessageList();
				System.out.println(messagelist.length);
				for (int i = 0; i < messagelist.length; i++) {
					msg += messagelist[i] + "\n";
					System.out.println(msg);
				}
				
				setMessage(msg);
				
				
			} catch (Exception e) {
			//	this.setMessage("Error on calling RPG program : " + e.getClass().getName() + " : " +  e.getMessage());
				e.printStackTrace();
			} finally {
				//done with the system
				if( as400System != null) {
					 return true;
				}
			}
			
		//	LoggerUtil.debugOut();
			return result;		
		}
	public void setMessage(String msg) {
		message = msg;
		
	}
	
	
}
