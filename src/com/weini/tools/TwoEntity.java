package com.weini.tools;

public class TwoEntity{
	private Object index1;
	private Object index2;
	public TwoEntity(){
		index1 = null;
		index2 = null;
	}
	public TwoEntity(Object index1, Object index2){
		this.index1 = index1;
		this.index2 = index2;
	}
	public Object getIndex1() {
		return index1;
	}
	public void setIndex1(Object index1) {
		this.index1 = index1;
	}
	public Object getIndex2() {
		return index2;
	}
	public void setIndex2(Object index2) {
		this.index2 = index2;
	}
}
