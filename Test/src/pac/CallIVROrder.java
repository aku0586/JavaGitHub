package pac;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;

public class CallIVROrder {

	public static void main(String[] args) {
		   
		 // parameter def.
		 String Return_Cd = ""; 
	     String P1PARM = null;
		 String VPS_cmd = "03"; 
		 String VPS_rst = "00";
		 String Dist_num = "00007480003";
		 String VPS_pwd = "";
		 String Dist_chk_rst = ""; 
		 String Chol_method = "4";
		 String Pymnt_chk_method = "";
		 String VPS_bnk_cd = ""; 
		 
		 String BNK_chk_rst = "";
		 String DD_pin_num = "";
		 String DD_pin_num_chk_rst = ""; 
		 String DD_chk_rst = "";
		 String VPS_crd_num = "1111111111111111";
		 String CRD_eff_dt = "1512"; 
		 String CRD_eff_dt_rst = "";
		 String CRD_inst_mth = "00"; 
		 String CRD_inst_mth_chk_rst = "";
		 String SEC_num = "";
		 
		 String ID_bnk_num = "";
		 String CRD_chk_rst = ""; 
		 String ORD_pv = "000000000";
		 String ORD_amt = "000000000";
		 String DLY_fee = "000000000"; 
		 String VPS_ref_num = "000000";
		 String DLY_tim = "";
		 String KE_cd = "";
		 String VPS_itm1 = "571901";
		 String VPS_itm2 = "";
		 
		 String CPN_ser = "CX94U9709367";
		 String CPN_val = "";
		 String P2Parm = null;
		 String PRMFREEITM_1 = "";
		 String PRMFREEITM_1_sts = "";
		 String PRMFREEITM_2 = "";
		 String PRMFREEITM_2_sts = "";
		 String PRMFREEITM_3 = "";
		 String PRMFREEITM_3_sts = "";
		 String PRMFREEITM_4 = "";
		 
		 String PRMFREEITM_4_sts = "";
		 String PRMFREEITM_5 = "";
		 String PRMFREEITM_5_sts = "";
		 
		 String msg = "";
		 
		 
		 //Connect to the iSeries using hostname, userid and password   
		 AS400 as400System = new AS400("amwkor01","aku0586","amway");
		 
		 //The ProgramCall class allows a user to call an iSeries server program,    
		 //pass parameters to it (input and output), and access data returned in the    
		 //output parameters after the program runs. Use ProgramCall to call programs.   
		 ProgramCall program = new ProgramCall(as400System);     
		 try  {    
			 // Initialize the name of the program to run.   
			 String programName = "/QSYS.LIB/OMQO314KOR.LIB/EKGKXFR.PGM"; 
			 // Set up the 3 parameters.    
			 ProgramParameter[] parameterList = new ProgramParameter[40];          
			 AS400Text textData = new AS400Text(20, as400System);    
		 
			 parameterList[0] = new ProgramParameter(textData.toBytes(Return_Cd));     
			 textData = new AS400Text(20, as400System);   
			 parameterList[1] = new ProgramParameter(textData.toBytes( ""));
			 textData = new AS400Text(20, as400System);  
			 parameterList[2] = new ProgramParameter(textData.toBytes( VPS_cmd)); 
			 textData = new AS400Text(20, as400System);  
			 parameterList[3] = new ProgramParameter(textData.toBytes( VPS_rst));
			 textData = new AS400Text(20, as400System);
			 parameterList[4] = new ProgramParameter(textData.toBytes( Dist_num));
			 textData = new AS400Text(20, as400System);
			 parameterList[5] = new ProgramParameter(textData.toBytes( VPS_pwd));
			 textData = new AS400Text(20, as400System); 
			 parameterList[6] = new ProgramParameter(textData.toBytes( Dist_chk_rst)); 
			 textData = new AS400Text(20, as400System); 
			 parameterList[7] = new ProgramParameter(textData.toBytes( Chol_method));
			 textData = new AS400Text(20, as400System); 
			 parameterList[8] = new ProgramParameter(textData.toBytes( Pymnt_chk_method));
			 textData = new AS400Text(20, as400System); 
			 parameterList[9] = new ProgramParameter(textData.toBytes( VPS_bnk_cd)); 
			 textData = new AS400Text(20, as400System); 
			 parameterList[10] = new ProgramParameter(textData.toBytes( BNK_chk_rst));
			 textData = new AS400Text(20, as400System); 
			 parameterList[11] = new ProgramParameter(textData.toBytes( DD_pin_num));
			 textData = new AS400Text(20, as400System); 
			 parameterList[12] = new ProgramParameter(textData.toBytes( DD_pin_num_chk_rst)); 
			 textData = new AS400Text(20, as400System); 
			 parameterList[13] = new ProgramParameter(textData.toBytes( DD_chk_rst));
			 textData = new AS400Text(20, as400System); 
			 parameterList[14] = new ProgramParameter(textData.toBytes( VPS_crd_num));
			 textData = new AS400Text(20, as400System); 
			 parameterList[15] = new ProgramParameter(textData.toBytes( CRD_eff_dt)); 
			 textData = new AS400Text(20, as400System); 
			 parameterList[16] = new ProgramParameter(textData.toBytes( CRD_eff_dt_rst));
			 textData = new AS400Text(20, as400System); 
			 parameterList[17] = new ProgramParameter(textData.toBytes( CRD_inst_mth)); 
			 textData = new AS400Text(20, as400System); 
			 parameterList[18] = new ProgramParameter(textData.toBytes( CRD_inst_mth_chk_rst));
			 textData = new AS400Text(20, as400System); 
			 parameterList[19] = new ProgramParameter(textData.toBytes( SEC_num));
			 textData = new AS400Text(20, as400System); 
			 parameterList[20] = new ProgramParameter(textData.toBytes( ID_bnk_num));
			 textData = new AS400Text(20, as400System); 
			 parameterList[21] = new ProgramParameter(textData.toBytes( CRD_chk_rst)); 
			 textData = new AS400Text(20, as400System); 
			 parameterList[22] = new ProgramParameter(textData.toBytes( ORD_pv));
			 textData = new AS400Text(20, as400System); 
			 parameterList[23] = new ProgramParameter(textData.toBytes( ORD_amt));
			 textData = new AS400Text(20, as400System); 
			 parameterList[24] = new ProgramParameter(textData.toBytes( DLY_fee)); 
			 textData = new AS400Text(20, as400System); 
			 parameterList[25] = new ProgramParameter(textData.toBytes( VPS_ref_num));
			 textData = new AS400Text(20, as400System); 
			 parameterList[26] = new ProgramParameter(textData.toBytes( DLY_tim));
			 textData = new AS400Text(20, as400System); 
			 parameterList[27] = new ProgramParameter(textData.toBytes( KE_cd));
			 textData = new AS400Text(20, as400System); 
			 parameterList[28] = new ProgramParameter(textData.toBytes( VPS_itm1));
			 textData = new AS400Text(20, as400System); 
			 parameterList[29] = new ProgramParameter(textData.toBytes( VPS_itm2));
			 textData = new AS400Text(20, as400System); 
			 parameterList[30] = new ProgramParameter(textData.toBytes( CPN_ser));
			 textData = new AS400Text(20, as400System); 
			 parameterList[31] = new ProgramParameter(textData.toBytes( CPN_val));
			 textData = new AS400Text(20, as400System); 
			 parameterList[32] = new ProgramParameter(textData.toBytes( ""));
			 textData = new AS400Text(20, as400System); 
			 parameterList[33] = new ProgramParameter(textData.toBytes( PRMFREEITM_1));
			 textData = new AS400Text(20, as400System); 
			 parameterList[34] = new ProgramParameter(textData.toBytes( PRMFREEITM_1_sts));
			 textData = new AS400Text(20, as400System); 
			 parameterList[35] = new ProgramParameter(textData.toBytes( PRMFREEITM_2));
			 textData = new AS400Text(20, as400System); 
			 parameterList[36] = new ProgramParameter(textData.toBytes( PRMFREEITM_2_sts));
			 textData = new AS400Text(20, as400System); 
			 parameterList[37] = new ProgramParameter(textData.toBytes( PRMFREEITM_3));
			 textData = new AS400Text(20, as400System); 
			 parameterList[38] = new ProgramParameter(textData.toBytes( PRMFREEITM_3_sts));
			 textData = new AS400Text(20, as400System); 
			 parameterList[39] = new ProgramParameter(textData.toBytes( PRMFREEITM_4));
			 textData = new AS400Text(20, as400System); 
	//		 parameterList[40] = new ProgramParameter(textData.toBytes( PRMFREEITM_4_sts));
	//		 textData = new AS400Text(20, as400System); 
	//		 parameterList[41] = new ProgramParameter(textData.toBytes( PRMFREEITM_5));
	//		 textData = new AS400Text(20, as400System); 
	//		 parameterList[42] = new ProgramParameter(textData.toBytes( PRMFREEITM_5_sts));
	//		 textData = new AS400Text(20, as400System); 
    //       Set the program name and parameter list.  
			 program.setProgram(programName, parameterList);     
			 // Run the program.    
			 if (program.run() != true)    {     
				 // Report failure.   
				 System.out.println("Program failed!");    
				 // Show the messages.     
				 AS400Message[] messageList = program.getMessageList();    
				 for (int i = 0; i < messageList.length; ++i)     {
					 // Show each message.      
					 System.out.println(messageList[i].getText());   
					 // Load additional message information. 
					 messageList[i].load();      
					 //Show help text.   
					 System.out.println(messageList[i].getHelp());     }    
			  
			 // Else no error, get output data.   
			 }else{    
				 textData = new AS400Text(100, as400System);   
			     msg = (String) textData.toObject(parameterList[3].getOutputData());
			    // message2 = (String) textData.toObject(parameterList[4].getOutputData());
			    // message3 = (String) textData.toObject(parameterList[4].getOutputData());
			 	   }
			 } catch (Exception e) {    
			 System.out.println("Program " + program.getProgram() + " issued an exception!");   
			 e.printStackTrace();   
			 }     
		 	 // Done with the server.   
		 	 as400System.disconnectAllServices();   
		 	 //Print the output from the RPGLE called program    
		 	 System.out.println("Message is: " + msg);  
		 //	 System.out.println("Message2 is: " + message2); 
		//	 System.out.println("Message3 is: " + message3);
		 	
   
	}

}
