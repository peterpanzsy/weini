
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
 *         &lt;element name="SubmitResult" type="{http://106.ihuyi.cn/}SubmitResult" minOccurs="0"/>
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
    "submitResult"
})
@XmlRootElement(name = "SubmitResponse")
public class SubmitResponse {

    @XmlElement(name = "SubmitResult")
    protected SubmitResult submitResult;

    /**
     * ��ȡsubmitResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SubmitResult }
     *     
     */
    public SubmitResult getSubmitResult() {
        return submitResult;
    }

    /**
     * ����submitResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitResult }
     *     
     */
    public void setSubmitResult(SubmitResult value) {
        this.submitResult = value;
    }

}
