package test_pac;

public class CashReceipt {

	 
	
	public String CashReceipt()      
    {                  
     
        try {             
            
             local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1 a = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1Locator();
             local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType amKorABNRequestReply_Apps_CTI_CashReceiptPort0 = a.getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port();
             
             local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input _input = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input();
        //     local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Output _output = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Output();
             
             local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Request_v1 req = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Request_v1();
             local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Response_v1 res = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Response_v1();
      
             _input.setReturnCode("00");  // returnCode
             _input.setOrderCancel("N");
             _input.setOrder("123456789");
             _input.setVPSReference("0");
             _input.setCRIDNO("1234567890");
             _input.setCRDISTClass("0");
             _input.setCRTRANSMITREASON("3");           
             
             
             req.setInput(_input);

             res =  amKorABNRequestReply_Apps_CTI_CashReceiptPort0.processCashReceipt_v1(req);
     
            System.out.println("getCRDISTClass : " +  res.getOutput().getCRDISTClass());
            System.out.println("getOrder : " + res.getOutput().getOrder());
            System.out.println("getVPSReference : " + res.getOutput().getVPSReference());
            System.out.println("getCRIDNO : " + res.getOutput().getCRIDNO());
            System.out.println("getCRDISTClass : " + res.getOutput().getCRDISTClass());
            System.out.println("getCRDISTClass : " + res.getOutput().getCRTRANSMITREASON());
            
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
              
       return "00";
    }
 
 
 

}
