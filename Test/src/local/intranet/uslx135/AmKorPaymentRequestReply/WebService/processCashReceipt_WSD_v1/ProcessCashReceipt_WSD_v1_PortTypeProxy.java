package local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1;

public class ProcessCashReceipt_WSD_v1_PortTypeProxy implements local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType {
  private String _endpoint = null;
  private local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType processCashReceipt_WSD_v1_PortType = null;
  
  public ProcessCashReceipt_WSD_v1_PortTypeProxy() {
    _initProcessCashReceipt_WSD_v1_PortTypeProxy();
  }
  
  public ProcessCashReceipt_WSD_v1_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initProcessCashReceipt_WSD_v1_PortTypeProxy();
  }
  
  private void _initProcessCashReceipt_WSD_v1_PortTypeProxy() {
    try {
      processCashReceipt_WSD_v1_PortType = (new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1Locator()).getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port();
      if (processCashReceipt_WSD_v1_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)processCashReceipt_WSD_v1_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)processCashReceipt_WSD_v1_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (processCashReceipt_WSD_v1_PortType != null)
      ((javax.xml.rpc.Stub)processCashReceipt_WSD_v1_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType getProcessCashReceipt_WSD_v1_PortType() {
    if (processCashReceipt_WSD_v1_PortType == null)
      _initProcessCashReceipt_WSD_v1_PortTypeProxy();
    return processCashReceipt_WSD_v1_PortType;
  }
  
  public local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Response_v1 processCashReceipt_v1(local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Request_v1 parameters) throws java.rmi.RemoteException{
    if (processCashReceipt_WSD_v1_PortType == null)
      _initProcessCashReceipt_WSD_v1_PortTypeProxy();
    return processCashReceipt_WSD_v1_PortType.processCashReceipt_v1(parameters);
  }
  
  
}