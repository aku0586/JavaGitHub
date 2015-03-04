package pac;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;

public class para_class {

	public  ProgramParameter[] para (){
		
		ProgramParameter[] rst ;	
	
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
	 for (int i=0; i <168; i++) {  VPS_itm1 = VPS_itm1+" "; }
	 for (int i=0; i <175; i++) {  VPS_itm2 = VPS_itm2+" "; }
	 
//	 String CPN_ser = "CX94U9709367  ";
	 String CPN_ser = "              ";
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
	
	 AS400 as400System = new AS400("amwkor01","aku0586","xorwhd1");
	ProgramParameter par = new ProgramParameter();
	
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
	
	rst = parameterList;
	return rst ;
	
	
	}
}
