package pac;

import com.ibm.as400.access.*; 


public class CallRPGProgram {
	
  //	 AS400 as400System = new AS400("amwkor01","aku0586","amway");
  //	 String message = null;
	 
	 
	 public static void main( String[] args )
	 {   
	// String firstName = args[0].trim(); 
	 String firstName = "First";
	//	 String lastName = args[1].trim();  
	 String lastName = "second";
	 String message = ""; 
	 //Connect to the iSeries using hostname, userid and password   
	 AS400 as400System = new AS400("amwkor01","aku0586","amway");
	//  String message = null;
	 
	 //The ProgramCall class allows a user to call an iSeries server program,    
	 //pass parameters to it (input and output), and access data returned in the    
	 //output parameters after the program runs. Use ProgramCall to call programs.   
	// ProgramCall program = new ProgramCall(as400System);     
	// try  {    
		 // Initialize the name of the program to run.   
		 String programName = "/QSYS.LIB/TJKANG.LIB/MYNAME.PGM"; 
		 // Set up the 3 parameters.    
		 ProgramParameter[] parameterList = new ProgramParameter[3];
		 
		 call_test_WAS ctw = new call_test_WAS();
		 
		 // Parameter 1 is the First Name    
		 AS400Text textData = new AS400Text(20, as400System);    
		 parameterList[0] = new ProgramParameter(textData.toBytes(firstName));     
		 // Parameter 2 is the Last Name    
		 AS400Text textData1 = new AS400Text(20, as400System);   
	     parameterList[1] = new ProgramParameter(textData1.toBytes(lastName));   
		 // Parameter 3 is the Age   
		// AS400ZonedDecimal as400ZonedDecimal = new AS400ZonedDecimal(3,0) ;   
		 // double myAge = Double.valueOf(age);   
		 // parameterList[2] = new ProgramParameter(as400ZonedDecimal.toBytes(myAge));  
		 // Parameter 4 to get the answer, up to 100 bytes long.    
		  parameterList[2] = new ProgramParameter(100);      
		 // Set the program name and parameter list.  
	//	 program.setProgram(programName, parameterList);     
		 // Run the program.    
	//	 if (program.run() != true)    {     
			 // Report failure.   
		//	 System.out.println("Program failed!");    
			 // Show the messages.     
			// AS400Message[] messageList = program.getMessageList();    
			 // for (int i = 0; i < messageList.length; ++i)     {
				 // Show each message.      
				// System.out.println(messageList[i].getText());   
				 // Load additional message information. 
				// messageList[i].load();      
				 //Show help text.   
				// System.out.println(messageList[i].getHelp());     }    }  
		 // Else no error, get output data.   
		 // else   {    
		//	 textData = new AS400Text(100, as400System);   
		// message = (String) textData.toObject(parameterList[2].getOutputData()); }  
		 // }   
//	 catch (Exception e)  {    
//		 System.out.println("Program " + program.getProgram() + " issued an exception!");   
//		 e.printStackTrace();   }     
//	 	// Done with the server.   
//	 	as400System.disconnectAllServices();   
//	 	//Print the output from the RPGLE called program    
//	 	System.out.println("Message is: " + message);   
	 
		  boolean rst = ctw.call(programName,parameterList,as400System);
		 
	
	 System.out.println(rst);
	 
	 
	 } 
}
		
	