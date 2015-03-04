package test_pac;

public class test_wM_WSDL_Cash {

	public static void  main(String[] args) {
		// TODO Auto-generated method stub
	     
	        try {             
	            
	        local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1 a = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1Locator();
	        local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType amKorABNRequestReply_Apps_CTI_CashReceiptPort0 = a.getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port();
      //    local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType  b = a.getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port(5656);
	        local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input _input = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input();
    
	        
	        // local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Output _output = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Output();
            local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Request_v1 req = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Request_v1();
	        local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Response_v1 res = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Response_v1();
	            
            _input.setReturnCode(null);  // returnCode
            _input.setOrderCancel("N");
            _input.setOrder("130136274");
            _input.setVPSReference("0");
            _input.setCRIDNO("0172243250");
            _input.setCRDISTClass("0");
            _input.setCRTRANSMITREASON("3");           
   System.out.println("_1");
          
   req.setInput(_input);
   System.out.println("_3");  
   res =  amKorABNRequestReply_Apps_CTI_CashReceiptPort0.processCashReceipt_v1(req);
   System.out.println("_2");            
            
	         System.out.println("getCRDISTClass : " + res.getOrder());
	         
	       //     		 res.getCRDISTClass();
	 //           System.out.println("여기까지_2");
	         System.out.println("getOrder : " + res.getOrder());
	            System.out.println("_3");
	           System.out.println("getVPSReference : " + res.getVPSReference());
	          System.out.println("getCRIDNO : " + res.getCRIDNO());
	           System.out.println("getCRDISTClass : " + res.getCRDISTClass());
	           System.out.println("getCRDISTClass : " + res.getCRTRANSMITREASON());
	            
	        } catch(javax.xml.rpc.ServiceException ex) {
	            // TODO handle ServiceException
	         System.out.println("ServiceException : " + ex.toString());
	         
	        } catch(java.rmi.RemoteException ex) {
	            // TODO handle remote exception
	         System.out.println("RemoteException : " + ex.toString());
	        } catch(Exception ex) {
	            // TODO handle custom exceptions here
	         System.out.println(ex.toString());
	        }
	     
	        
	    
	        
	}
	
	
	
	public static  String a(String in) {
        StringBuffer out = new StringBuffer(); // Used to hold the output.
        char current; // Used to reference the current character.

        if (in == null || ("".equals(in))) return ""; // vacancy test.
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
            if ((current == 0x9) ||
                (current == 0xA) ||
                (current == 0xD) ||
                ((current >= 0x20) && (current <= 0xD7FF)) ||
                ((current >= 0xE000) && (current <= 0xFFFD)) ||
                ((current >= 0x10000) && (current <= 0x10FFFF)))
                out.append(current);
        }
        return out.toString();
    }

}
