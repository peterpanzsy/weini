package com.weini.manage.entity;
// default package

/**
 * TIndex entity. @author MyEclipse Persistence Tools
 */

public class TIndex implements java.io.Serializable {

	// Fields

	private Integer indexId;
	private String indexName;
	private String indexValue;

	// Constructors

	/** default constructor */
	public TIndex() {
	}

	/** full constructor */
	public TIndex(String indexName, String indexValue) {
		this.indexName = indexName;
		this.indexValue = indexValue;
	}

	// Property accessors

	public Integer getIndexId() {
		return this.indexId;
	}

	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}

	public String getIndexName() {
		return this.indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIndexValue() {
		return this.indexValue;
	}

	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}

}