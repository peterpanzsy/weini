
package cn.ihuyi._106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetNumResult" type="{http://106.ihuyi.cn/}GetNumResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getNumResult"
})
@XmlRootElement(name = "GetNumResponse")
public class GetNumResponse {

    @XmlElement(name = "GetNumResult")
    protected GetNumResult getNumResult;

    /**
     * ��ȡgetNumResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GetNumResult }
     *     
     */
    public GetNumResult getGetNumResult() {
        return getNumResult;
    }

    /**
     * ����getNumResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GetNumResult }
     *     
     */
    public void setGetNumResult(GetNumResult value) {
        this.getNumResult = value;
    }

}
