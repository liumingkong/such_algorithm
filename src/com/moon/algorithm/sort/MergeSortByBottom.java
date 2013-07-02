package com.moon.algorithm.sort;

import org.junit.Test;

/**
 * @ClassName: MergeSortByBottom 
 * @Description: 自底向上的归并排序
 * @author liuzhao
 * @date 2013-5-22 下午11:42:47 
 * 
 * 递归实现的归并排序是算法设计中分治思想的典型应用
 * 讲一个大问题分割成小问题分别解决，然后用所有小问题的答案来解决整个大问题
 * 
 * 实现归并的另一种方法：自底向上
 * 先归并微型数组，然后再成对归并得到的子数组，如此这般直到将这个数组归并。
 * 
 * 把每个元素想象成大小为1的数组，两两归并，四四，八八...
 * 每一轮归并中，最后一次归并的第二个子数组可能比第一个子数组要小，否则就相同，
 * 而在下一轮中子数组的大小会翻倍
 * 
 * 自底向上的归并排序比较适合用链表组织的数据，
 * 这种方法只需要重新组织链表链接就能将链表原地排序
 * 
 * 两种归并排序：化整为零，循序渐进
 * 
 */
public class MergeSortByBottom extends SortBase {

	Comparable<?>[] aux ;

	// TODO 每一步都很精巧啊
	// 数组的中间位置 = (high + low) / 2
	// 划分的规则，如果是奇数个元素，两个小组，
	// 前面的小组 low ~ (mid - 1),后面的小组 mid ~ high
	// 数组元素的总数 N = high - low + 1
	// 一次归并的元素个数 = 2h 
	// 求 high = 2h - 1 + low
	// 一次归并的范围: low ~ (low + 2h - 1) 
	// mid = ((low + 2h - 1) + low ) / 2 = low + h - 1/2 ~=  low + h - 1
	@Override
	public void sort(Comparable<?>[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int h = 1; h < a.length ; h = h * 2 ) { // 两两归并，h 要小于 数组大小，否则无法形成归并
			for (int lo = 0;lo < N - h; lo = lo + 2*h) { // 归并起点，至少要小于 N-h，并以 lo + 2*h 增长
				merge(a,lo,lo+h-1,min(lo + 2*h -1,N-1)); // 归并的最后一组可能没有足够2h的元素，
				// 注意，mid = lo + h - 1,因为在归并中，后半截的起点是 j = mid + 1 ，若不-1，可能会超过high的位置
			}
		}
	}

	private int min(int a,int b) {
		if (less(a,b)) return a;
		return b;
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
	
	@Override
	@Test
	public void testSort() { 
		Integer[] testI = {1,3,4,5,6,2,5,5,7,9};
		show(testI);
		sort(testI);
		show(testI);
	}
	
}
