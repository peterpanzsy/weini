
package cn.ihuyi._106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取getReplyResult属性的值。
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
     * 设置getReplyResult属性的值。
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
