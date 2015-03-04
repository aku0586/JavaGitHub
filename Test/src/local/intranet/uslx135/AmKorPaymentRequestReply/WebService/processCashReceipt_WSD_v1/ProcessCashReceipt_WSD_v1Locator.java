/**
 * ProcessCashReceipt_WSD_v1Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1;

public class ProcessCashReceipt_WSD_v1Locator extends org.apache.axis.client.Service implements local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1 {

    public ProcessCashReceipt_WSD_v1Locator() {
    }


    public ProcessCashReceipt_WSD_v1Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProcessCashReceipt_WSD_v1Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port
    private java.lang.String AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port_address = "http://uslx135.intranet.local:7474/ws/AmKorPaymentRequestReply.WebService:processCashReceipt_WSD_v1/AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port";

    public java.lang.String getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortAddress() {
        return AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortWSDDServiceName = "AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port";

    public java.lang.String getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortWSDDServiceName() {
        return AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortWSDDServiceName;
    }

    public void setAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortWSDDServiceName(java.lang.String name) {
        AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortWSDDServiceName = name;
    }

    public local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port(endpoint);
    }

    public local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_BinderStub _stub = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_BinderStub(portAddress, this);
            _stub.setPortName(getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortEndpointAddress(java.lang.String address) {
        AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.ProcessCashReceipt_WSD_v1_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_BinderStub _stub = new local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_BinderStub(new java.net.URL(AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port_address), this);
                _stub.setPortName(getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port".equals(inputPortName)) {
            return getAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://uslx135.intranet.local/AmKorPaymentRequestReply/WebService/processCashReceipt_WSD_v1", "processCashReceipt_WSD_v1");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://uslx135.intranet.local/AmKorPaymentRequestReply/WebService/processCashReceipt_WSD_v1", "AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_Port".equals(portName)) {
            setAmKorPaymentRequestReply_WebService_processCashReceipt_WSD_v1_PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
