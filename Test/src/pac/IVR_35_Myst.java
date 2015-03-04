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

public class IVR_35_Myst {

	public static void main(String[] args) throws PropertyVetoException, AS400SecurityException, ErrorCompletingRequestException, IOException, InterruptedException, ObjectDoesNotExistException {
		// TODO Auto-generated method stub
		// parameter setup
		 String Return_Cd = "       "; 
		 String VPS_cmd = "03"; 
		 String VPS_rst = "00";
		 String Dist_num = "00007480003";
		 String VPS_pwd = "    ";
		 String Dist_chk_rst = " "; 
		 String Chol_method = "4";
		 String Pymnt_chk_method = " ";
		 String VPS_bnk_cd = "  ";		 
		 String BNK_chk_rst = " ";
		 String DD_pin_num = "      ";
		 String DD_pin_num_chk_rst = " "; 
		 String DD_chk_rst = " ";
		 String VPS_crd_num = "1111111111111111";
		 String CRD_eff_dt = "1512"; 
		 String CRD_eff_dt_rst = " ";
		 String CRD_inst_mth = "00"; 
		 String CRD_inst_mth_chk_rst = " ";
		 String SEC_num = "  ";		 
		 String ID_bnk_num = "       ";
		 String CRD_chk_rst = " "; 
		 String ORD_pv = "000000000";
		 String ORD_amt = "000000000";
		 String DLY_fee = "000000000"; 
		 String VPS_ref_num = "000000";
		 String DLY_tim = "    ";
		 String KE_cd = "   ";
		 String VPS_itm1 = "571901 ";
		 String VPS_itm2 = "";
		 for (int i=0; i <168; i++) {  VPS_itm1 = " "+VPS_itm1; }
		 for (int i=0; i <175; i++) {  VPS_itm2 = VPS_itm2+" "; }
		 
		 
		 String CPN_ser = "CX94U9709367  ";
		 String CPN_val = " ";
		 
		 
		 String PRMFREEITM_1 = "            ";
		 String PRMFREEITM_1_sts = " ";
		 String PRMFREEITM_2 = "            ";
		 String PRMFREEITM_2_sts = " ";
		 String PRMFREEITM_3 = "            ";
		 String PRMFREEITM_3_sts = " ";
		 String PRMFREEITM_4 = "            ";		 
		 String PRMFREEITM_4_sts = " ";
		 String PRMFREEITM_5 = "            ";
		 String PRMFREEITM_5_sts = " ";
		  
		 
		 String msg = "";
		 
		 String P1PARM= VPS_cmd +
				 		VPS_rst +  
				 		Dist_num +  
				 		VPS_pwd + 
				 		Dist_chk_rst + 
				 		Chol_method + 
				 		Pymnt_chk_method + 
				 		VPS_bnk_cd + 
				 		BNK_chk_rst +  
				 		DD_pin_num +  
				 		DD_pin_num_chk_rst + 
				 		DD_chk_rst +  
				 		VPS_crd_num +  
				 		CRD_eff_dt +  
				 		CRD_eff_dt_rst + 
				 		CRD_inst_mth +  
				 		CRD_inst_mth_chk_rst + 
				 		SEC_num + 
				 		ID_bnk_num +  
				 		CRD_chk_rst + 
				 		ORD_pv +  
				 		ORD_amt + 
				 		DLY_fee +  
				 		VPS_ref_num +  
				 		DLY_tim + 
				 		KE_cd +  
				 		VPS_itm1 +  
				 		VPS_itm2;
			System.out.println("P1=  " + P1PARM.length());
			
		 String P2PARM= PRMFREEITM_1
				 + PRMFREEITM_1_sts
				 +PRMFREEITM_2
				 + PRMFREEITM_2_sts
				 +PRMFREEITM_3
				 + PRMFREEITM_3_sts
				 +PRMFREEITM_4
				 + PRMFREEITM_4_sts
				 +PRMFREEITM_5
				 + PRMFREEITM_5_sts;	
		System.out.println("P2=  " + P2PARM.length());
		
		 
		 //Connect to the iSeries using hostname, userid and password   
		 AS400 as400System = new AS400("amwkor01","aku0586","xorwhd1");
/*		The ProgramCall class allows a user to call an iSeries server program,    
		pass parameters to it (input and output), and access data returned in the    
		output parameters after the program runs. Use ProgramCall to call programs.*/   
		 	ProgramCall program = new ProgramCall(as400System);     
		 // Initialize the name of the program to run.   
			String programName = "/QSYS.LIB/OMQO314KOR.LIB/EKGKXFR.PGM"; 
			System.out.println("여기는 왔나");
		 // Set up the 3 parameters.    
		     ProgramParameter[] parameterList = new ProgramParameter[5];
	   	 	 AS400Text textData = new AS400Text(7, as400System);    
			 parameterList[0] = new ProgramParameter(textData.toBytes(Return_Cd));
			 textData = new AS400Text(457, as400System); 
			 parameterList[1] = new ProgramParameter(textData.toBytes(P1PARM));
			 textData = new AS400Text(14, as400System); 
			 parameterList[2] = new ProgramParameter(textData.toBytes(CPN_ser));
			textData = new AS400Text(1, as400System); 
		     parameterList[3] = new ProgramParameter(textData.toBytes(CPN_val));
		     textData = new AS400Text(65, as400System); 
		     parameterList[4] = new ProgramParameter(textData.toBytes(P2PARM));
		     
		     
		     System.out.println("여기는 왔나");
 		 
			 // Set the program name and parameter list.  
			 program.setProgram(programName, parameterList);   
			 System.out.println("여기는 왔나 1 ");
			 // Run the program.    
			// if (program.run() != true)    {        
				 // Report failure.   
			//	 System.out.println("여기는 왔나 2 ");
			//	 System.out.println("Program failed!");    }
				 // Show the messages.     
				
			// else {
				 System.out.println("여기는 왔나 3 ");
				 program.run() ;
				 System.out.println("여기는 왔나 4 ");
			// AS400Message[] messageList = program.getMessageList();  
			// System.out.println("여기는 왔나 5 ");
			 System.out.println("사이즈   " + parameterList.length);
			 
			 textData = new AS400Text(100, as400System);   
		     String message = (String) textData.toObject(parameterList[3].getOutputData());
			 System.out.println(message);
		//	 AS400Text textData1 = new AS400Text(500, as400System);  
		//	 parameterList[1].getOutputData()
			
		//	 System.out.println(parameterList[1].getOutputData());
		//	 System.out.println(parameterList[2].getOutputData());
			 
			 
	//		 String message = (String) textData1.toObject(parameterList[1].getOutputData());
	//		 System.out.println("결과  "+ message);
		//	 messageList.length
			// messageList[0].getText()
			// System.out.println(messageList[1].getText());
			 
				/* for (int i = 0; i < messageList.length; ++i)     {
					 System.out.println("여기는 왔나 5 ");
					 // Show each message.      
					 System.out.println(messageList[i].getText());   
					 // Load additional message information. 
					 messageList[i].load();      
					 //Show help text.   
					 System.out.println(messageList[i].getHelp()); 
					 }		*/  
			 //   }  
			
		 
		 
		 } 

	}
