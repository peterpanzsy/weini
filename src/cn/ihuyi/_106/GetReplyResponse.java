
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
 *         &lt;element name="GetReplyResult" type="{http://106.ihuyi.cn/}GetReplyResult" minOccurs="0"/>
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
    "getReplyResult"
})
@XmlRootElement(name = "GetReplyResponse")
public class GetReplyResponse {

    @XmlElement(name = "GetReplyResult")
    protected GetReplyResult getReplyResult;

    /**
     * ��ȡgetReplyResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GetReplyResult }
     *     
     */
    public GetReplyResult getGetReplyResult() {
        return getReplyResult;
    }

    /**
     * ����getReplyResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GetReplyResult }
     *     
     */
    public void setGetReplyResult(GetReplyResult value) {
        this.getReplyResult = value;
    }

}
