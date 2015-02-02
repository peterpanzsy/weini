
package cn.ihuyi._106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SubmitResult complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SubmitResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="msg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smsid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitResult", propOrder = {
    "code",
    "msg",
    "smsid"
})
public class SubmitResult {

    protected int code;
    @XmlElement(required = true)
    protected String msg;
    protected int smsid;

    /**
     * ��ȡcode���Ե�ֵ��
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * ����code���Ե�ֵ��
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

    /**
     * ��ȡmsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * ����msg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * ��ȡsmsid���Ե�ֵ��
     * 
     */
    public int getSmsid() {
        return smsid;
    }

    /**
     * ����smsid���Ե�ֵ��
     * 
     */
    public void setSmsid(int value) {
        this.smsid = value;
    }

}
