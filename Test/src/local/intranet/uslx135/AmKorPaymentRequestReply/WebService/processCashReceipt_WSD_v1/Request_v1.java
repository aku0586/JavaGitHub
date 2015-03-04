/**
 * Request_v1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1;

public class Request_v1  implements java.io.Serializable {
    private local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input input;

    public Request_v1() {
    }

    public Request_v1(
           local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input input) {
           this.input = input;
    }


    /**
     * Gets the input value for this Request_v1.
     * 
     * @return input
     */
    public local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input getInput() {
        return input;
    }


    /**
     * Sets the input value for this Request_v1.
     * 
     * @param input
     */
    public void setInput(local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1.Input input) {
        this.input = input;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Request_v1)) return false;
        Request_v1 other = (Request_v1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.input==null && other.getInput()==null) || 
             (this.input!=null &&
              this.input.equals(other.getInput())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getInput() != null) {
            _hashCode += getInput().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Request_v1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://uslx135.intranet.local/AmKorPaymentRequestReply/WebService/processCashReceipt_WSD_v1", "Request_v1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("input");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Input"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://uslx135.intranet.local/AmKorPaymentRequestReply/WebService/processCashReceipt_WSD_v1", "Input"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
