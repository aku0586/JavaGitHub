package pac;

import java.beans.PropertyVetoException;
import java.io.IOException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;
import com.ibm.as400.access.Trace;

public class call_IVR_Coupon {

	public static void main(String[] args) throws PropertyVetoException, AS400SecurityException, ErrorCompletingRequestException, IOException, InterruptedException, ObjectDoesNotExistException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// parameter setup
		 String Return_Cd = "       "; 
		 String Dist_num = "00007480003";
		 String VPS_cd = "5719";
		 String CPN_API1 = ""; 
		 String CPN_API2 = ""; 
		 String CPN_API3 = ""; 
		 String CPN_API4 = ""; 
		 String CPN_API5 = ""; 
		 String CPN_API6 = ""; 
		 String CPN_API7 = ""; 
		 String CPN_API8 = ""; 
		 String CPN_API9 = ""; 
		 String CPN_API10 = ""; 
		for (int i=0; i<67; i++){ CPN_API1 = CPN_API1 + " ";}
		System.out.println(CPN_API1.length());
		for (int i=0; i<67; i++){ CPN_API2 = CPN_API2 + " ";}
		for (int i=0; i<67; i++){ CPN_API3 = CPN_API3 + " ";}
		for (int i=0; i<67; i++){ CPN_API4 = CPN_API4 + " ";}
		for (int i=0; i<67; i++){ CPN_API5 = CPN_API5 + " ";}
		for (int i=0; i<67; i++){ CPN_API7 = CPN_API6 + " ";}
		for (int i=0; i<67; i++){ CPN_API8 = CPN_API7 + " ";}
		for (int i=0; i<67; i++){ CPN_API9 = CPN_API8 + " ";}
		for (int i=0; i<67; i++){ CPN_API9 = CPN_API9 + " ";}
		for (int i=0; i<67; i++){ CPN_API10 = CPN_API10 + " ";}
		String CPN_ERR = " ";
		
		 String msg = "";
		 
		
		 
	 
		 AS400 as400System = new AS400("amwkor01","aku0586","xorwhd1");
 
		 	ProgramCall program = new ProgramCall(as400System);     
		 	 System.out.println("여기는 왔나");
			String programName = "/QSYS.LIB/OMQO314KOR.LIB/EKGPXFR.PGM"; 
			
			
			ProgramParameter[] parameterList = new ProgramParameter[14];
	   	 	 AS400Text textData = new AS400Text(7, as400System);    
			 parameterList[0] = new ProgramParameter(textData.toBytes(Return_Cd));
			 textData = new AS400Text(11, as400System); 
			 parameterList[1] = new ProgramParameter(textData.toBytes(Dist_num));
			 textData = new AS400Text(4, as400System); 
			 parameterList[2] = new ProgramParameter(textData.toBytes(VPS_cd ));			 
		/*	textData = new AS400Text(67, as400System); 
		     parameterList[3] = new ProgramParameter(textData.toBytes(CPN_API1));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[4] = new ProgramParameter(textData.toBytes(CPN_API2));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[5] = new ProgramParameter(textData.toBytes(CPN_API3));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[6] = new ProgramParameter(textData.toBytes(CPN_API4));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[7] = new ProgramParameter(textData.toBytes(CPN_API5));
		     textData = new AS400Text(67, as400System); 
		     parameterList[8] = new ProgramParameter(textData.toBytes(CPN_API6));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[9] = new ProgramParameter(textData.toBytes(CPN_API7));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[10] = new ProgramParameter(textData.toBytes(CPN_API8));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[11] = new ProgramParameter(textData.toBytes(CPN_API9));
		 	textData = new AS400Text(67, as400System); 
		     parameterList[12] = new ProgramParameter(textData.toBytes(CPN_API10));
		  	textData = new AS400Text(67, as400System); 
		     parameterList[13] = new ProgramParameter(textData.toBytes(CPN_API10));
		    textData = new AS400Text(1, as400System); 
		     parameterList[14] = new ProgramParameter(textData.toBytes(CPN_ERR));*/
		     
		     parameterList[3] = new ProgramParameter(100); 
		     parameterList[4] = new ProgramParameter(100); 
		     parameterList[5] = new ProgramParameter(100); 
		     parameterList[6] = new ProgramParameter(100); 
		     parameterList[7] = new ProgramParameter(100); 
		     parameterList[8] = new ProgramParameter(100); 
		     parameterList[9] = new ProgramParameter(100); 
		     parameterList[10] = new ProgramParameter(100); 
		     parameterList[11] = new ProgramParameter(100); 
		     parameterList[12] = new ProgramParameter(100); 
		     parameterList[13] = new ProgramParameter(100); 
		     
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
				 Trace.setTraceOn(true);
			 textData = new AS400Text(100, as400System);   
				String message1 = (String) textData.toObject(parameterList[4].getOutputData());  
			
				 System.out.println(message1);
				 
			 }
			 System.out.println("lol ");
				 
			 
		//	 String msg1 = (String) text.toObject(parameterList[1].getOutputData());
		//	 System.out.println(msg1);
			// System.out.println(text.toObject(parameterList[0].getOutputData()));
			// System.out.println(text.toObject(parameterList[2].getOutputData()));
			 	 
			
		
		
		

	}
	
}
