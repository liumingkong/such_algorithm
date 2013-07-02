package com.moon.algorithm.sort;

import org.junit.Test;

/**
 * @ClassName: QuickSort 
 * @Description: 快速排序
 * @author liuzhao
 * @date 2013-5-24 上午1:39:09
 * 
 *  快速排序或许是使用最为广泛的排序算法了
 *  优点：原地排序（只需要一个很小的辅助栈），长度为N的数组排序时间为NlgN O(nlgn
 *  缺点：很脆弱，实际使用中要非常小心才能避免低劣的性能
 *  
 *  快速排序是一种分治的排序算法。
 *  它把一个数组分成两个子数组，将两部分独立排序。
 *  快速排序和归并排序是互补的：
 *  1.归并将数组分成两个子数组分别排序，并将有序的子数组归并以将整个数组排序
 *  2.快速排序是当子数组有序的时候，整个数组也就有序了
 *  第一种情况，递归调用发生在处理整个数组之前
 *  第二种情况，递归调用发证在处理整个数组之后
 *  归并排序切分的位置是一半，快速排序的切分位置取决于数组的内容
 *  
 *  快速排序算法：
 *  递归地将子数组a[lo...hi]排序，先用partition方法将a[j]放在一个合适位置，然后递归调用将其他位置的元素排序
 *  
 *  该方法的关键在于切分，这个过程使得数组满足下面三个条件：
 *  1.对于某个j，a[j]已经排定
 *  2.a[lo]到a[j-1]中的所有元素都不大于a[j];
 *  3.a[j+1]到a[hi]中的所有元素都不小于a[i];
 *  
 *  实现切分方法：
 *  通常取a[lo]作为切分元素，即那个会被排定的元素
 *  从左向右扫描直到找到一个大于等于它的元素
 *  
 *  
 *  
 *  
 */
public class QuickSort extends SortBase{

	@Override
	public void sort(Comparable<?>[] a) {
		sort(a, 0, a.length-1);
	}
	
	/** 排序*/
	private void sort(Comparable<?>[] a, int low, int high) {
		System.out.println("low:"+low+",high:"+high);
		if (high <= low) return;
		int j = partition(a,low,high); // 切分
		sort(a,low,j-1);  // 将左半部分排序
		sort(a,j+1,high); // 将右半部分排序
	}
	
	/** 切分
	 *  一般的策略是取a[lo]作为被排定的元素，即会被排定的元素
	 *  从数组的左端开始向右扫描直到找到一个大于等于它的元素，再从右向左扫描直到找到一个小于等于它的元素
	 *  交换两个元素的位置
	 *  这样就可以保证左指针i的左侧元素都不大于切分元素
	 *  右指针j的右侧元素都不小于切分元素
	 *  当两个指针相遇的时候，只需要将切分元素和左子数组最右侧的元素a[j]贾环返回j即可
	 * 
	 *  代码中，按照a[lo]的值v进行切分。当指针i和j相遇时主循环退出
	 *  在循环中，a[i]小于v，增大i，a[j]大于v，减小j，
	 *  然后交换i和j，保证i左侧的元素都不大于v，j右侧的元素都不小于v
	 *  指针相遇时交换a[lo]和a[j]，切分结束
	 *  
	 * */
	private int partition(Comparable<?>[] a, int low, int high) {
		int i = low;
		int j = high + 1; 
		Comparable<?> v = a[low];
		while(true) {
			while(less(a[++i],v)) {
				if (i == high) {
					break;
				}
			}
			while(less(v,a[--j])) {
				if (j == low)
					break;
			}
			if (i>=j) break;
			exch(a,i,j);
		}
		exch(a,low,j);
		return j;
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
