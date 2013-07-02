package com.moon.algorithm.sort;

public abstract class SortBase implements SortService{
	
	/** 比较元素v与w的大小，true:v小于w */ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0 ;
	}
	
	/** 交换两个元素*/
	void exch(Comparable<?>[] a,int i,int j) {
		Comparable<?> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/** 显示所有元素*/
	void show(Comparable<?>[] a) {
		for (int i = 0;i < a.length; i++) {
			System.out.print(a[i]+",");
		}
		System.out.println();
	}
} 
