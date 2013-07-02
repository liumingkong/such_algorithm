package com.moon.algorithm.sort;

/**
 * @ClassName: HeapSort 
 * @Description: TODO
 * @author liuzhao
 * @date 2013-6-8 下午9:36:45 
 * 
 * 堆排序
 * 堆排序可以分为两个阶段：构造堆，堆排序
 * 
 * 构造堆的方式
 * 1.从左到右遍历数组，用swim保证扫描指针左侧的所有元素已经是一棵堆有序的完全二叉树，犹如向优先队列插入元素
 * 2.更聪明的做法，从右到左用sink构造子堆
 * 数组的每个位置都已经是一个子堆的根节点，如果一个结点的两个子结点都已经是堆了，在该节点上调用sink可将它们变成一个堆
 * 这个过程会递归的建立起堆的秩序
 * 
 * 开始时，我们只需要扫描数组的一半元素，即可完成有序堆.
 * 
 * 堆排序的重要意义：
 * 它是我们所知道的排序中，唯一能够同时最优地利用空间和时间的方法，
 * 即使在最坏的情况下，也能保证用2NlgN次比较和恒定的额外空间
 * 在空间紧张的设备中，几行代码就实现了较好的排序性能
 * 但现代系统中很少使用，因为它无法利用缓存，数组元素很少喝相邻元素比较，缓存命中率不高
 * 另外，用堆来实现的优先队列的使用很是广泛。
 * 
 * 优先队列的利用场景：
 * 例如:10亿个数中找最大的十个，或者不间断的输入很大量的数据，
 * 因为当数据量很大的时候，我们无法同时获取所有数据，因此我们只能先从优先队列中取出一部分并进行处理
 * 再根据结果决定是否要向优先队列中添加多余的数据
 * 
 */
public class HeapSort extends SortBase {
 
	public void sort(Comparable<?>[] a) { 
		int N = a.length;
		for (int k = N/2; k >= 1;k--) { // 初始化堆，不断选举，选出最大值
			sink(a,k,N);     
		} 
		while (N > 1) { //逐渐的把最大的元素向后放
			exch(a,1,N);
			N--;
			sink(a,1,N); 
		}
		
	}

	/** k 指的是要下沉的元素位置，N 指的是下沉的元素下界限*/
	private void sink(Comparable<?>[] a,int k, int N) {
		while(2 * k <= N) {
			int left = 2 * k;
			int right = 2 * k +1;
			int max = left;
			if (right <= N && less(a[left],a[right])) {
				max = right;
			} 
			if (less(a[max],a[k])) {
				break;
			} else {
				exch(a, max, k);
				k = max;
			}
			
		}
	}
	
	public void testSort() {
		// TODO Auto-generated method stub
		
	}

	
}
