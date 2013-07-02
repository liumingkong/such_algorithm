package com.moon.algorithm.sort;

import org.junit.Test;

/**
 * @ClassName: ShellSort 
 * @Description: 希尔排序
 * @author liuzhao
 * @date 2013-5-17 下午6:41:40 
 * 
 * 基于插入排序的快速的排序算法
 * 对于大规模乱序数组，插入排序的速度很慢，交换元素，逐渐右移
 * 希尔排序就是为了加快速度而改进了插入排序，交换不相邻的元素以对数组的局部进行排序
 * 
 * 希尔排序的思想：使数组中任意间隔为h的元素都是有序的，对于任意以1结尾的h序列，最终都能将数组排序。
 * 
 * 实现希尔排序的方法：对每个h，用插入排序将h个子数组独立排序。
 * 只不过，交换的时候，是将元素的移动距离由1改为h，起始位置由0~h变化
 * 
 * h 的递增序列如何选择？
 * h = N/3 算是理论上和复杂递增序列达到的性能最接近的了...其他的序列并没证明能提高多少
 * 
 * 选择和插入排序对于大型数组排序的表现是很糟糕的，但希尔排序也能够表现很好，数组越大表现越好
 * 对于一个给定的递增序列，构造使希尔排序很慢的数组是不容易的。
 * 
 * 在最坏情况下，希尔排序的比较次数是 与N指数(3/2)成正比，突破了N的平方的限制
 * 理论上，希尔排序所需要的平均比较次数是无法获得的。
 * 
 * 希尔排序常常会被选用中等大小的数组，其运行时间是可以接受的，代码量很小，无需额外的空间
 * 其他更高效的算法可能只会比希尔排序快2倍，但更加复杂
 * 因此，常用希尔排序作为过度排序，以后在替换更加复杂高效的算法
 */
public class ShellSort extends SortBase {

	@Override
	public void sort(Comparable<?>[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) h = 3 * h + 1;
		while( h >= 1 ) {
			for (int i = 0 ; i < h ;i++ ) {
				insertSort(a, i, h);
			}
			h = h / 3;
		}
	}
	
	/**
	 * 插入排序
	 * @param a 数组
	 * @param h 移动间隔
	 */
	public void insertSort(Comparable<?>[] a,int start, int h) {
		for (int j = start; j < a.length; j = j + h) {
			for (int k = j - h; k > 0; k = k - h) {
				if (less(a[k], a[k+h])) {
					break;
				}
				exch(a,k,k+h);
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
