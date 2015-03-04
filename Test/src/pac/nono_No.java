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
		
	 
		 AS400 as400System = new AS400("amwkor01","aku0586","xorwhd1");
 
		 	ProgramCall program = new ProgramCall(as400System);     
		 	
			String programName = "/QSYS.LIB/OMQO314KOR.LIB/EKGKXFR.PGM"; 
			
		    para_class pst = new para_class();
		    ProgramParameter[] parameterList = pst.para();
		     
		     System.out.println("여기는 왔나");
 		  
			 program.setProgram(programName, parameterList);   
			 System.out.println("여기는 왔나 1 ");
			 
			 
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
				 
				 
				 System.out.println("Type" + parameterList[4].getParameterType());
				 String srt0 =
						 	(String) new AS400Text(7,as400System).toObject(parameterList[0].getInputData());
						 	System.out.println(srt0);
				 System.out.println("으흐");
				 
				 String srt1 =
						 	(String) new AS400Text(457,as400System).toObject(parameterList[1].getInputData());
						 	System.out.println(srt1);
				 System.out.println("으흐");
				 String srt2 =
						 	(String) new AS400Text(14,as400System).toObject(parameterList[2].getInputData());
						 	System.out.println(srt2);
				 System.out.println("으흐");
				 
				 String srt3 =
						 	(String) new AS400Text(1,as400System).toObject(parameterList[3].getInputData());
						 	System.out.println(srt3);
				 System.out.println("으흐");
				 
				 
				 String srt4 =
						 	(String) new AS400Text(40,as400System).toObject(parameterList[4].getInputData());
						 	System.out.println(srt4);
				 System.out.println("으흐");
				
				 
				System.out.println("아웃풋 확인");
				
				for (int i=0; i<4;i++){
					
					int len = parameterList[1].getOutputDataLength();
					System.out.println("크기   ==>  " + len );
				}
							
			 	byte[] data = parameterList[1].getInputData();
			 			 	
			 	if (data != null){
			 		
					int len = parameterList[1].getOutputDataLength();
					AS400Text typeConverter = new AS400Text(len,as400System);
					String apiOutput = (String) typeConverter.toObject(data);
					System.out.println("apiOutput " + apiOutput);		
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


