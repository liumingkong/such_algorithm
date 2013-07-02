package com.moon.algorithm.sort.compara;

import java.util.Comparator;

public class InsertionComparator<Key> {
 
	public void sort(Key[] a, Comparator<Key> c) {
		for (int i = 0 ; i < a.length ; i++) { 
			for (int j = i - 1 ;j >= 0 ; j --) { // 从 i-1的位置开始 倒着开始
				if (less(c, a[j],a[j+1])) { 
					break;
				}
				exch(a,j,j+1); // j 和 j + 1交换 
			}
		}
	}
	
	boolean less(Comparator<Key> c, Key v, Key w) {
		return c.compare(v, w) < 0;
	}
	
	/** 交换两个元素*/
	void exch(Key[] a,int i,int j) {
		Key t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	
}
