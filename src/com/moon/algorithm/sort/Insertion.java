package com.moon.algorithm.sort;

import org.junit.Test;

/**
 * @ClassName: Insertion 
 * @Description: 插入排序
 * @author liuzhao
 * @date 2013-5-15 下午12:07:08 
 * 
 * 插入排序的思想来自于人们平时整理桥牌的做法
 * 每次获得一张新牌，都会插入到其他已经有序的排中的适当位置
 * 为了给插入元素，需要将其余元素向后移动。
 * 
 * 当索引左边的所有元素都是有序的，但他们的最终位置还不确定，
 * 为了给更小的元素腾出空间，它们可能会被移动，直到最右边的索引位置
 * 
 * 和选择排序不同，插入排序所需时间取决于输入元素的初始顺序
 * 插入排序对于部分有序的数组十分高效。
 * 
 * 命题：插入排序中，
 * 需要的交换操作 = 数组中倒置的数量相同
 * 证明：每次交换相当于两个元素顺序颠倒过来，倒置的数量减少一个，倒置为0，排序完成。
 * 倒置的数量 <= 比较的次数 <= 倒置的数量+数组的大小-1
 * 
 * 如何改进插入排序的效率呢？
 * 将内循环中较大的元素向后移动，而不总是交换元素
 * 这样就能减少访问数组的次数
 */
public class Insertion extends SortBase{

	@Override
	public void sort(Comparable<?>[] a) {
		for (int i = 0 ; i < a.length ; i++) { 
			for (int j = i - 1 ;j >= 0 ; j --) { // 从 i-1的位置开始 倒着开始
				if (less(a[j],a[j+1])) { 
					break;
				}
				exch(a,j,j+1); // j 和 j + 1交换 
			}
		}
	}

	@Test
	public void testSort() {
		Integer[] testI = {1,3,4,5,6,2,5,5,7,9,1};
		show(testI);
		sort(testI);
		show(testI);
	}

	
}
