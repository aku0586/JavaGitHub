package pac;
import com.ibm.as400.access.*; 
public class call_IVR_Test {

	 public static void main( String[] args )
	 {   
	 
	 String Dist_num = "00007480003"; 
     String VPSCde = "5719";
	 String message = ""; 
	 String message2 = "";
	 String message3 = "";
	 //Connect to the iSeries using hostname, userid and password   
	 AS400 as400System = new AS400("amwkor01","aku0586","xorwhd1");
	 
	 //The ProgramCall class allows a user to call an iSeries server program,    
	 //pass parameters to it (input and output), and access data returned in the    
	 //output parameters after the program runs. Use ProgramCall to call programs.   
	 ProgramCall program = new ProgramCall(as400System);     
	 try  {    
		 // Initialize the name of the program to run.   
		 String programName = "/QSYS.LIB/OMQO314KOR.LIB/EKGPXFR.PGM"; 
		 // Set up the 3 parameters.    
		 ProgramParameter[] parameterList = new ProgramParameter[14];          
		 AS400Text textData = new AS400Text(20, as400System);    
 
		 parameterList[0] = new ProgramParameter(textData.toBytes(""));     
		 textData = new AS400Text(20, as400System);   
		 parameterList[1] = new ProgramParameter(textData.toBytes(Dist_num));   
		 parameterList[2] = new ProgramParameter(textData.toBytes(VPSCde));
		 parameterList[3] = new ProgramParameter(100); 
		 parameterList[4] = new ProgramParameter(100); 
		 parameterList[5] = new ProgramParameter(100); 
		 parameterList[6] = new ProgramParameter(100); 
		 parameterList[7] = new ProgramParameter(100); 
		 parameterList[8] = new ProgramParameter (100); 
		 parameterList[9] = new ProgramParameter (100); 
		 parameterList[10] = new ProgramParameter (100); 
		 parameterList[11] = new ProgramParameter (100); 
		 parameterList[12] = new ProgramParameter (100);  
		 parameterList[13] = new ProgramParameter (100); 
		 // Set the program name and parameter list.  
		 program.setProgram(programName, parameterList);     
		 // Run the program.    
		 if (program.run() != true)    {}else{    
			 textData = new AS400Text(100, as400System);   
		     message = (String) textData.toObject(parameterList[3].getOutputData());
		     message2 = (String) textData.toObject(parameterList[4].getOutputData());
		     message3 = (String) textData.toObject(parameterList[2].getOutputData());
		 	   }
		 } catch (Exception e) {    
		 System.out.println("Program " + program.getProgram() + " issued an exception!");   
		 e.printStackTrace();   
		 }     
	 	 // Done with the server.   
	 	 as400System.disconnectAllServices();   
	 	 //Print the output from the RPGLE called program    
	 	 System.out.println("Message is: " + message);  
	 	 System.out.println("Message2 is: " + message2); 
		 System.out.println("Message3 is: " + message3);
	 	}
	}
