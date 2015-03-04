package pac;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400PackedDecimal;
import com.ibm.as400.access.AS400Text;

public class IVER_Test_from_eshop extends AS400Program {
	
	
	public IVER_Test_from_eshop() {
		
	//	if(AS400Program.TEST_MODE){
			setProgramName("/QSYS.LIB/OMQO314KOR.LIB/EKGKXFR.PGM");
	//	}else{
	//		setProgramName("/QSYS.LIB/*LIBL.LIB/EG98XFR.PGM" );
	//	}
		setParameterTypeList( 
			new AS400DataType[] {
				
			new AS400Text(7),   //ReturnCode
			new AS400Text(20),   //#P1PARM
			new AS400Text(2),   //#u-vps command
			new AS400Text(2),   //#u-vps result           
			new AS400Text(11),   //#dist number(11a)       
			new AS400Text(4),   //#vps password           
			new AS400Text(1),   //#distributor sts        
			new AS400Text(1),   //#chollian payment method
			new AS400Text(1),   //#payment method chk     
			new AS400Text(2),   //#vps Bank Code          
			new AS400Text(1),   //#bank chk               
			new AS400Text(6),   //#vps D/D Sec num        
			new AS400Text(1),   //#ddb password chk       
			new AS400Text(1),   //#ddb result             
			new AS400Text(16),   //#vps card number        
			new AS400Text(4),   //#Effective Date         
			new AS400Text(1),   //#card effective ym chk  
			new AS400Text(2),   //#vps installment month  
			new AS400Text(1),   //#card installment mm chk
			new AS400Text(2),   //#security number
			new AS400Text(7),   //#ID Back Number 
			new AS400Text(1),   //#card result            
			new AS400Text(9),   //#vps order P/V          
			new AS400Text(9),   //#vps order amount       
			new AS400Text(9),   //#vps Handling charge    
			new AS400Text(6),   //#VPS REF NUM 
			new AS400Text(4),   //#delivery hh:mm
			new AS400Text(3),   //#ke depot code 
			new AS400Text(175),   //#u-vps item ds(7*25)1
			new AS400Text(175),   //#u-vps item ds(7*25)2
			new AS400Text(14),   //#Coupon Serial  
			new AS400Text(1),   //#Coupon Validity
			new AS400Text(20),   //#P2PARM
			new AS400Text(12),   //PRMFreeItem1
			new AS400Text(1),   //PRMFreeItem1Status
			new AS400Text(12),   //PRMFreeItem2
			new AS400Text(1),   //PRMFreeItem2Status
			new AS400Text(12),   //PRMFreeItem3
			new AS400Text(1),   //PRMFreeItem3Status
			new AS400Text(12),   //PRMFreeItem4
			new AS400Text(1),   //PRMFreeItem4Status
			new AS400Text(12),   //PRMFreeItem5
			new AS400Text(1)   //PRMFreeItem5Status

			}
		);
	}
	
//	public String inventoryCancel(String strWhs, String strItemCode, int intQty) {
//		try {
//			setParameter( 4, strWhs);
//			setParameter( 5, strItemCode);
//			setParameter( 6, intQty);
//			setParameter( 7, "1");
//			if( ! call() ) return null;
//			return getParameter(0);
//		} catch (Exception e) {
//			setMSG_DESC( e);
//			return null;
//		}
//		
//	}

	public String Order_Eshop() {
		try {
			
			
			setParameter (1,"");
			
			
			 // setParameter (2,null);
			setParameter (2,"");
			
		
			setParameter (3,"03");
			setParameter (4,"00");
			
		//	System.out.println("748전");
			setParameter (5,"abc");
			
			
			setParameter (6,"");
			
		//  System.out.println("안오는곳");
			
			setParameter (7,"");
			setParameter (8,"4");
			setParameter (9,"");
			setParameter (10,"");
			setParameter (11,"");
			setParameter (12,"");
			setParameter (13,"");
			setParameter (14,"");
			setParameter (15,"1111111111111111");
			setParameter (16,"1512'");
			setParameter (17,"");
			setParameter (18,"00");
			setParameter (19,"");
			setParameter (20,"");
			setParameter (21,"");
			setParameter (22,"");
			setParameter (23,"000000000");
			setParameter (24,"000000000");
			setParameter (25,"000000000");
			setParameter (26,"000000");
			setParameter (27,"");
			setParameter (28,"");
			setParameter (29,"571901");
			setParameter (30,"");
			setParameter (31,"CX94U9709367");
			setParameter (32,"");
			setParameter (33,"");
			setParameter (34,"");
			setParameter (35,"");
			setParameter (36,"");
			setParameter (37,"");
			setParameter (38,"");
			setParameter (39,"");
			setParameter (40,"");
			setParameter (41,"");
			setParameter (42,"");
			setParameter (43,"");
			System.out.println("여기여기");
            call();
            
		//	if( ! call() ) return null;
			System.out.println("getParameter(0)" + getParameter(0));
			return getParameter(0);
			
			
			
		} catch (Exception e) {
			setMSG_DESC( e);
			return null;
		}
	//	return MSG_DESC;
		
	}

	public static void main( String[] args) {
		IVER_Test_from_eshop pgm = new IVER_Test_from_eshop();
		//String rtnCode = pgm.inventoryCancel( "09", "WHU2692K", 10);
		String rtnCode = pgm.Order_Eshop();
		System.out.println( "RTN_CODE=" + rtnCode);
		System.out.println( "MSG_DESC=" + pgm.getMSG_DESC());
	}

}
