
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
 *         &lt;element name="ChangePasswordResult" type="{http://106.ihuyi.cn/}ChangePasswordResult" minOccurs="0"/>
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
    "changePasswordResult"
})
@XmlRootElement(name = "ChangePasswordResponse")
public class ChangePasswordResponse {

    @XmlElement(name = "ChangePasswordResult")
    protected ChangePasswordResult changePasswordResult;

    /**
     * ��ȡchangePasswordResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ChangePasswordResult }
     *     
     */
    public ChangePasswordResult getChangePasswordResult() {
        return changePasswordResult;
    }

    /**
     * ����changePasswordResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ChangePasswordResult }
     *     
     */
    public void setChangePasswordResult(ChangePasswordResult value) {
        this.changePasswordResult = value;
    }

}
