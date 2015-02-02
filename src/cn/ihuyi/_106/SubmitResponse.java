
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
     * 获取submitResult属性的值。
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
     * 设置submitResult属性的值。
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
