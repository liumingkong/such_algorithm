package com.moon.algorithm.sort;

import org.junit.Test;

/**
 * @ClassName: MergeSort 
 * @Description: 归并排序
 * @author liuzhao
 * @date 2013-5-20 下午6:15:47
 * 
 * 归并排序：将两个有序的数组归并成一个更大的有序数组
 * 先递归的将数组分成两半，分别排序，将结果合并起来
 * 优点：它能够保证将任意长度为N的数组排序所需时间和NlogN成正比
 * 缺点：它所需的额外空间和N成正比
 * 
 * a[0~15] -> a [0~7] -> a[0~3] -> a[0~1] ->a[2~3] a[4~7], a[8~15] -> 
 * 
 * 自顶向下的归并排序
 * 存在的缺点：辅助数组所用的额外空间和N的大小成正比
 * 
 * 1.归并排序，对小规模的子数组采用插入排序，递归会使小规模数组的调用过于频繁
 * 如果改用插入排序一般可以将运行时间缩短较多
 * 
 * 2.测试数组是否已经有序
 * 添加判断条件，如果a[mid]小于等于a[mid+1],就认为数组已经是有序的，跳过merge方法
 * 这个改动不影响排序的递归调用，但是任意有序的子数组算法的运行时间就变为线性的了。
 * 
 * 3.不将元素复制到辅助数组
 * 可以节省将数组元素复制到用于归并的辅助数组所用的时间（但空间不行）
 * 通过在递归的时候，不断地交换辅助数组和输入数组的角色
 * 
 */
public class MergeSortByTop extends SortBase {

	Comparable<?>[] aux ;
	
	@Override
	public void sort(Comparable<?>[] a) {
		aux = new Comparable<?>[a.length];
		sortMerge(a,0,a.length -1 );
	}

	
	private void sortMerge(Comparable<?>[] a, int lo, int hi) {
		if (lo >= hi) return;
		int mid = (hi + lo) / 2 ;
		sortMerge(a,lo,mid);
		sortMerge(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	/**
	 * 二路归并，a[lo]~a[mid]，a[mid+1]~a[high] 都是有序的
	 */
	private void merge(Comparable<?>[] a, int lo, int mid, int high) {
		// 将 a[lo]~a[mid] 和 a[mid+1]~a[high] 
		int i = lo;
		int j = mid + 1;
		
		// 将a复制到aux
		for (int k = lo; k <= high ; k ++) {
			System.out.println(k+":"+high);
			aux[k] = a[k];
		}
		
		// 归并到a[lo...high]
		int k = lo;
		while ( i<= mid && j <= high ) {
			if (less(aux[i],aux[j])) { // 
				a[k] = aux[i];
				i ++;
			} else if (less(aux[j],aux[i])) {
				a[k] = aux[j];
				j ++;
			} else { //相等
				a[k] = aux[i];
				i ++;
				k ++;
				a[k] = aux[j];
				j ++;
			}
			k ++;
		}
		
		if (i > mid) { // i 用尽
			while (j <= high) {
				a[k] = aux[j];
				j ++;
				k ++;
			}
		} else if (j>high) {
			while ( i<= mid ) {
				a[k] = aux[i];
				i ++;
				k ++;
			}
		}
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
