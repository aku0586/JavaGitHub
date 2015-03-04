/**
 * Response_v1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package local.intranet.uslx135.AmKorPaymentRequestReply.WebService.processCashReceipt_WSD_v1;

public class Response_v1  implements java.io.Serializable {
    private java.lang.String returnCode;

    private java.lang.String orderCancel;

    private java.lang.String order;

    private java.lang.String VPSReference;

    private java.lang.String CRIDNO;

    private java.lang.String CRDISTClass;

    private java.lang.String CRTRANSMITREASON;

    public Response_v1() {
    }

    public Response_v1(
           java.lang.String returnCode,
           java.lang.String orderCancel,
           java.lang.String order,
           java.lang.String VPSReference,
           java.lang.String CRIDNO,
           java.lang.String CRDISTClass,
           java.lang.String CRTRANSMITREASON) {
           this.returnCode = returnCode;
           this.orderCancel = orderCancel;
           this.order = order;
           this.VPSReference = VPSReference;
           this.CRIDNO = CRIDNO;
           this.CRDISTClass = CRDISTClass;
           this.CRTRANSMITREASON = CRTRANSMITREASON;
    }


    /**
     * Gets the returnCode value for this Response_v1.
     * 
     * @return returnCode
     */
    public java.lang.String getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this Response_v1.
     * 
     * @param returnCode
     */
    public void setReturnCode(java.lang.String returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Gets the orderCancel value for this Response_v1.
     * 
     * @return orderCancel
     */
    public java.lang.String getOrderCancel() {
        return orderCancel;
    }


    /**
     * Sets the orderCancel value for this Response_v1.
     * 
     * @param orderCancel
     */
    public void setOrderCancel(java.lang.String orderCancel) {
        this.orderCancel = orderCancel;
    }


    /**
     * Gets the order value for this Response_v1.
     * 
     * @return order
     */
    public java.lang.String getOrder() {
        return order;
    }


    /**
     * Sets the order value for this Response_v1.
     * 
     * @param order
     */
    public void setOrder(java.lang.String order) {
        this.order = order;
    }


    /**
     * Gets the VPSReference value for this Response_v1.
     * 
     * @return VPSReference
     */
    public java.lang.String getVPSReference() {
        return VPSReference;
    }


    /**
     * Sets the VPSReference value for this Response_v1.
     * 
     * @param VPSReference
     */
    public void setVPSReference(java.lang.String VPSReference) {
        this.VPSReference = VPSReference;
    }


    /**
     * Gets the CRIDNO value for this Response_v1.
     * 
     * @return CRIDNO
     */
    public java.lang.String getCRIDNO() {
        return CRIDNO;
    }


    /**
     * Sets the CRIDNO value for this Response_v1.
     * 
     * @param CRIDNO
     */
    public void setCRIDNO(java.lang.String CRIDNO) {
        this.CRIDNO = CRIDNO;
    }


    /**
     * Gets the CRDISTClass value for this Response_v1.
     * 
     * @return CRDISTClass
     */
    public java.lang.String getCRDISTClass() {
        return CRDISTClass;
    }


    /**
     * Sets the CRDISTClass value for this Response_v1.
     * 
     * @param CRDISTClass
     */
    public void setCRDISTClass(java.lang.String CRDISTClass) {
        this.CRDISTClass = CRDISTClass;
    }


    /**
     * Gets the CRTRANSMITREASON value for this Response_v1.
     * 
     * @return CRTRANSMITREASON
     */
    public java.lang.String getCRTRANSMITREASON() {
        return CRTRANSMITREASON;
    }


    /**
     * Sets the CRTRANSMITREASON value for this Response_v1.
     * 
     * @param CRTRANSMITREASON
     */
    public void setCRTRANSMITREASON(java.lang.String CRTRANSMITREASON) {
        this.CRTRANSMITREASON = CRTRANSMITREASON;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Response_v1)) return false;
        Response_v1 other = (Response_v1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.returnCode==null && other.getReturnCode()==null) || 
             (this.returnCode!=null &&
              this.returnCode.equals(other.getReturnCode()))) &&
            ((this.orderCancel==null && other.getOrderCancel()==null) || 
             (this.orderCancel!=null &&
              this.orderCancel.equals(other.getOrderCancel()))) &&
            ((this.order==null && other.getOrder()==null) || 
             (this.order!=null &&
              this.order.equals(other.getOrder()))) &&
            ((this.VPSReference==null && other.getVPSReference()==null) || 
             (this.VPSReference!=null &&
              this.VPSReference.equals(other.getVPSReference()))) &&
            ((this.CRIDNO==null && other.getCRIDNO()==null) || 
             (this.CRIDNO!=null &&
              this.CRIDNO.equals(other.getCRIDNO()))) &&
            ((this.CRDISTClass==null && other.getCRDISTClass()==null) || 
             (this.CRDISTClass!=null &&
              this.CRDISTClass.equals(other.getCRDISTClass()))) &&
            ((this.CRTRANSMITREASON==null && other.getCRTRANSMITREASON()==null) || 
             (this.CRTRANSMITREASON!=null &&
              this.CRTRANSMITREASON.equals(other.getCRTRANSMITREASON())));
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
        if (getReturnCode() != null) {
            _hashCode += getReturnCode().hashCode();
        }
        if (getOrderCancel() != null) {
            _hashCode += getOrderCancel().hashCode();
        }
        if (getOrder() != null) {
            _hashCode += getOrder().hashCode();
        }
        if (getVPSReference() != null) {
            _hashCode += getVPSReference().hashCode();
        }
        if (getCRIDNO() != null) {
            _hashCode += getCRIDNO().hashCode();
        }
        if (getCRDISTClass() != null) {
            _hashCode += getCRDISTClass().hashCode();
        }
        if (getCRTRANSMITREASON() != null) {
            _hashCode += getCRTRANSMITREASON().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Response_v1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://uslx135.intranet.local/AmKorPaymentRequestReply/WebService/processCashReceipt_WSD_v1", "Response_v1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReturnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderCancel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OrderCancel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Order"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VPSReference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VPSReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CRIDNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CRIDNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CRDISTClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CRDISTClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CRTRANSMITREASON");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CRTRANSMITREASON"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
