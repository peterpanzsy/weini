
package cn.ihuyi._106;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.ihuyi._106 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetNumResult_QNAME = new QName("http://106.ihuyi.cn/", "GetNumResult");
    private final static QName _SubmitResult_QNAME = new QName("http://106.ihuyi.cn/", "SubmitResult");
    private final static QName _VersionInfoResult_QNAME = new QName("http://106.ihuyi.cn/", "VersionInfoResult");
    private final static QName _ChangePasswordResult_QNAME = new QName("http://106.ihuyi.cn/", "ChangePasswordResult");
    private final static QName _GetReplyResult_QNAME = new QName("http://106.ihuyi.cn/", "GetReplyResult");
    private final static QName _QueryResult_QNAME = new QName("http://106.ihuyi.cn/", "QueryResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.ihuyi._106
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link ChangePasswordResult }
     * 
     */
    public ChangePasswordResult createChangePasswordResult() {
        return new ChangePasswordResult();
    }

    /**
     * Create an instance of {@link SubmitResponse }
     * 
     */
    public SubmitResponse createSubmitResponse() {
        return new SubmitResponse();
    }

    /**
     * Create an instance of {@link SubmitResult }
     * 
     */
    public SubmitResult createSubmitResult() {
        return new SubmitResult();
    }

    /**
     * Create an instance of {@link GetNumResult }
     * 
     */
    public GetNumResult createGetNumResult() {
        return new GetNumResult();
    }

    /**
     * Create an instance of {@link VersionInfo }
     * 
     */
    public VersionInfo createVersionInfo() {
        return new VersionInfo();
    }

    /**
     * Create an instance of {@link GetReplyResponse }
     * 
     */
    public GetReplyResponse createGetReplyResponse() {
        return new GetReplyResponse();
    }

    /**
     * Create an instance of {@link GetReplyResult }
     * 
     */
    public GetReplyResult createGetReplyResult() {
        return new GetReplyResult();
    }

    /**
     * Create an instance of {@link QueryResult }
     * 
     */
    public QueryResult createQueryResult() {
        return new QueryResult();
    }

    /**
     * Create an instance of {@link GetNumResponse }
     * 
     */
    public GetNumResponse createGetNumResponse() {
        return new GetNumResponse();
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link VersionInfoResult }
     * 
     */
    public VersionInfoResult createVersionInfoResult() {
        return new VersionInfoResult();
    }

    /**
     * Create an instance of {@link Submit }
     * 
     */
    public Submit createSubmit() {
        return new Submit();
    }

    /**
     * Create an instance of {@link GetReply }
     * 
     */
    public GetReply createGetReply() {
        return new GetReply();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link GetNum }
     * 
     */
    public GetNum createGetNum() {
        return new GetNum();
    }

    /**
     * Create an instance of {@link VersionInfoResponse }
     * 
     */
    public VersionInfoResponse createVersionInfoResponse() {
        return new VersionInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://106.ihuyi.cn/", name = "GetNumResult")
    public JAXBElement<GetNumResult> createGetNumResult(GetNumResult value) {
        return new JAXBElement<GetNumResult>(_GetNumResult_QNAME, GetNumResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://106.ihuyi.cn/", name = "SubmitResult")
    public JAXBElement<SubmitResult> createSubmitResult(SubmitResult value) {
        return new JAXBElement<SubmitResult>(_SubmitResult_QNAME, SubmitResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VersionInfoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://106.ihuyi.cn/", name = "VersionInfoResult")
    public JAXBElement<VersionInfoResult> createVersionInfoResult(VersionInfoResult value) {
        return new JAXBElement<VersionInfoResult>(_VersionInfoResult_QNAME, VersionInfoResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePasswordResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://106.ihuyi.cn/", name = "ChangePasswordResult")
    public JAXBElement<ChangePasswordResult> createChangePasswordResult(ChangePasswordResult value) {
        return new JAXBElement<ChangePasswordResult>(_ChangePasswordResult_QNAME, ChangePasswordResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReplyResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://106.ihuyi.cn/", name = "GetReplyResult")
    public JAXBElement<GetReplyResult> createGetReplyResult(GetReplyResult value) {
        return new JAXBElement<GetReplyResult>(_GetReplyResult_QNAME, GetReplyResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://106.ihuyi.cn/", name = "QueryResult")
    public JAXBElement<QueryResult> createQueryResult(QueryResult value) {
        return new JAXBElement<QueryResult>(_QueryResult_QNAME, QueryResult.class, null, value);
    }

}
