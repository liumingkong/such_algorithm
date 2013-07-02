package com.moon.algorithm.sort;

import org.junit.Test;

/**
 * @ClassName: Selection 
 * @Description: 选择排序
 * @author liuzhao
 * @date 2013-5-14 下午11:16:05 
 * 
 * 算法描述：
 * 首先，找到数组中最小的那个元素，
 * 其次，将它与数组的第一个元素交换，在剩下的元素中找到最小的元素，将他和数组的第二个元素交换位置。
 * 如此往复，知道将整个数组排序。
 * 
 * 选择排序：不断地选择剩余元素之中的最小者。
 * 对于长度为N的数组，选择排序需要大约N*N/2次比较和N次交换
 * 
 * 选择排序的两个特点:
 * 1.运行时间与输入无关。为找出最小元素扫描一遍数组并不能为下一遍扫描提供什么信息。
 * 这个性质就会导致的缺点是，一个有序的数组或者主键全部相等的数组和一个元素随机排列的数组所用的排序时间竟然一样长。
 * 2.数据移动是最少的。每次交换都会改变两个数组元素的值，因此选择排序用了N次交换，交换次数和数组的大小是线性关系。其他算法不具备此特征。
 * 
 */
public class Selection extends SortBase{

	/**选择排序*/
	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] a) {
		for (int i = 0;i < a.length;i++) {
			int min = i;
			for (int j = i + 1;j < a.length;j++) {
				if (less(a[j],a[min])) {
					min = j;
				}
			}
			exch(a,i,min);
		}
	}
	
	@Test
	public void testSort() {
		Integer[] testI = {1,3,4,5,6,2,5,5,7,9};
		show(testI);
		sort(testI);
		show(testI);
	}
}
