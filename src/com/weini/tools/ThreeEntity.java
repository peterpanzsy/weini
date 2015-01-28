package com.weini.tools;

public class ThreeEntity{
	private Object index1;
	private Object index2;
	private Object index3;
	public ThreeEntity(){
		index1 = null;
		index2 = null;
		setIndex3(null);
	}
	public ThreeEntity(Object index1, Object index2,Object index3){
		this.index1 = index1;
		this.index2 = index2;
		this.setIndex3(index3);
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
	public Object getIndex3() {
		return index3;
	}
	public void setIndex3(Object index3) {
		this.index3 = index3;
	}
}
