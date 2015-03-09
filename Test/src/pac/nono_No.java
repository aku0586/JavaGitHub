package pac;

import java.beans.PropertyVetoException;
import java.io.IOException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;


public class nono_No {

	public static void main(String[] args) throws AS400SecurityException, ErrorCompletingRequestException, IOException, InterruptedException, ObjectDoesNotExistException, PropertyVetoException {
		// TODO Auto-generated method stub
		// parameter setup
		
		/*Trace.setTraceOn(true);
		Trace.setTraceAllOn(true);
		Trace.setTracePCMLOn(true);
		Trace.setTraceDiagnosticOn(true);*/
		
		
		 AS400 as400System = new AS400("amwkor01","aku0586","xorwhd1");
 
		 	ProgramCall program = new ProgramCall(as400System);     
		 	
			String programName = "/QSYS.LIB/OMQO314KOR.LIB/EKGKXFR.PGM"; 
			
		    para_class pst = new para_class();
		    
		    
		    ProgramParameter[] parameterList = pst.para();
	
			 program.setProgram(programName, parameterList);   
			
			 
			 if (program.run() != true)
			 {
			 // Report failure.
			 System.out.println("Program failed!");
			 // Show the messages.
			 AS400Message[] messagelist = program.getMessageList();
			 for (int i = 0; i < messagelist.length; ++i)
			 {
			 // Show each message.
			 System.out.println(messagelist[i]);
			 }
			 }
			 // Else no error, get output data.
			 else
			 {
				 
				ProgramParameter[] pra =   program.getParameterList();
				byte[] output1 = pra[1].getOutputData();
				
				int len2 = pra[1].getOutputDataLength();
				System.out.println("len2 --> " + len2);
				
				AS400DataType aaa = new AS400Text(len2, as400System);
				
				String apiOutput1 = (String) aaa.toObject(output1);
				
				System.out.println("Sucees?" + apiOutput1);
				
			//check the parameter type
			// System.out.println("Parameter Type" + parameterList[4].getParameterType());
				 // Print 1st Param
				 String srt0 =
						 	(String) new AS400Text(7,as400System).toObject(parameterList[0].getInputData());
						
				 System.out.println(srt0);
				 // Print 2nd Param				 
				 String srt1 =
						 	(String) new AS400Text(457,as400System).toObject(parameterList[1].getInputData());
						 	System.out.println(srt1);
				// Print 3rd Param
				 String srt2 =
						 	(String) new AS400Text(14,as400System).toObject(parameterList[2].getInputData());
						 	System.out.println(srt2);
			   // Print 4th Param				 
				 String srt3 =
						 	(String) new AS400Text(1,as400System).toObject(parameterList[3].getInputData());
						 	System.out.println(srt3);
				// Print 5th Param				 
				 String srt4 =
						 	(String) new AS400Text(40,as400System).toObject(parameterList[4].getInputData());
						 	System.out.println(srt4);
				// output size check	
						 	
				System.out.println("check output");
				
				for (int i=0; i<4;i++){
					
					int len = pra[i].getOutputDataLength();
					System.out.println("length of " + i   +"-->" + len );
					
							
				
			 	byte[] data = pra[1].getInputData();
			 	
			 	if (data != null){
			 		
					int len1 = pra[i].getOutputDataLength();
					AS400Text typeConverter = new AS400Text(457,as400System);
					String apiOutput = (String) typeConverter.toObject(data);
					System.out.println("apiOutput 457 " + apiOutput);		
			 	
			 	}
				}		 	
			 	/* AS400Text textData = new AS400Text(600, as400System);   
					String message1 = (String) textData.toObject(parameterList[0].getOutputData());  
	 
					 System.out.println(message1);
				 */
				 
				 }
			 // Done with the system.
		 	as400System.disconnectAllServices();
				
	}
}


