package com.moon.algorithm.sort;

import org.junit.Test;

/**
 * @ClassName: Quick3way 
 * @Description: TODO
 * @author liuzhao
 * @date 2013-6-2 下午11:19:59 
 * 
 * 对于具有大量重复元素的数组
 * 快速排序的递归性会使全部重复的子数组经常出现
 * 
 * Dijkstra的三向切分的快速排序
 * 它从左到右遍历数组一次，维护
 * 一个指针lt使得a[lo...lt-1]中的元素都小于v
 * 一个指针gt使得a[gt+1....hi]中的元素都大于v,
 * 一个指针i使得a[lt....i-1]中的元素都等于v
 * a[i....gt]中的元素都还未确定。
 * 
 * 一开始i和lo相等，三向比较来直接处理以下的情况
 * 1.a[i]小于v,将a[lt]和a[i]交换，将lt和i加一
 * 2.a[i]大于v,将a[gt]和a[i]交换，将gt减一
 * 3.a[i]等于v,将i加一
 * 
 */
public class Quick3way extends SortBase {

	@Override
	public void sort(Comparable<?>[] a) {
		sort(a,0,a.length -1);
	}

	public void sort(Comparable<?>[] a, int lo, int hi) {
		if (hi <= lo) return;
		int lt = lo,i=lo+1,gt=hi;
		Comparable<?> v = a[lo];
		while(i<=gt) { 
			if (less(a[i],v)) exch(a,lt++,i++);
			else if (less(v,a[i])) exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
	@Test
	@Override
	public void testSort() {
		Integer[] testI = {1,3,4,5,6,2,5,5,7,9};
		show(testI);
		sort(testI);
		show(testI);
	}

}
