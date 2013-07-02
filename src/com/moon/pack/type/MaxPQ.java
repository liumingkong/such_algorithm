package com.moon.pack.type;
 
/**
 * @ClassName: MaxPQ 
 * @Description: 优先队列
 * @author liuzhao
 * @date 2013-6-3 下午12:45:28 
 * @param <Key>
 * 
 * 许多应用程序都需要处理有序的元素，但未必要求它们全部有序
 * 很多情况下，收集一些元素，处理当前键值最大的元素，然后再收集更多的元素，在处理当前值最大的元素。
 * 通过为每个应用程序的事件分配一个优先级，并总是处理下一个优先级最高的事件来处理。
 * 这样一个合适的数据结构应该支持两种操作：删除最大的元素和插入元素，这种结构叫做优先队列。
 * 
 * 如果用栈或者队列来实现优先队列，性能上并不出色
 * 优先队列的各种实现在最坏情况下运行时间的增长数量级
 * 数据结构，插入元素，删除最大元素
 * 有序数组，N，1 (每次插入都进行排序)
 * 无序数组，1，N (每次获取最大元素都要进行排序)
 * 堆，logN,logN 
 * 理想情况，1，1
 * 
 * 优先队列由一个基于堆的完全二叉树表示，存储于pq[1..N]
 * insert:将N加1，并把新元素添加到数组最后，用swim恢复顺序
 * delMax:从pq[1]中得到需要返回的元素，交换pq[N]和pq[1]，将N减一并用sink恢复堆的秩序
 * 将不再使用的元素未知的元素置为空，以便系统回收它所占的空间
 * 
 * 命题：对于一个含有N个元素的基于堆的优先队列，插入元素操作只需不超过(lgN+1)次比较
 * 删除最大元素的操作需要不超过2lgN次比较
 * 论证：两种操作，路径长度不会超过lgN，
 * 对于路径上的每个节点，删除最大元素需要两次比较（除了栈底元素），一次用来比较最大子节点，一次用来判断是否需要上浮
 * 
 * 
 * 
 */
public class MaxPQ<Key extends Comparable<Key>> {

	/** 创建一个优先队列*/
	public MaxPQ(){
		
	}
	
	/** 创建一个最大容量为max的优先队列*/
	@SuppressWarnings("unchecked")
	public MaxPQ(int maxPq){
		pq = (Key[]) new Comparable[maxPq];
	}
	
	/** 用a[]中的元素创建一个优先队列*/
	public MaxPQ(Key[] a){
		
	}
	
	/** 向优先队列中插入一个元素*/
	public void Insert(Key v) {
		if ((N + 1) > (pq.length - 1)) {
			System.out.println("over the queue max lenght");
			return;
		}
		System.out.println("insert:"+v); 
		N ++;
		pq[N] = v; // 插入数组尾部
		swim(N); // 上浮到合适位置
	}
	
	/** 删除并返回最大元素*/
	public Key delMax() {
		Key max = pq[1]; 
		if (N > 0) { // 发现超过长度就返回null
			exch(1,N); // 交换元素
			pq[N] = null; // 置空，防止越界
			N--;
			sink(1); // 下沉
		}
		return max;
	}
	
	/** 返回队列是否为空*/
	public boolean isEmpty() {
		return N == 0 ;
	}
	
	/** 返回优先队列中的元素个数*/
	public int size() {
		return N;
	}
	
	protected Key pq[]; // 基于堆的完全二叉树
	protected int N = 0; // 存储于pq[1~N]中，pq[0]没有使用
	
	/** 比较大小*/
	protected boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0 ;
	}
	
	/** 交换两个元素*/
	protected void exch(int i,int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	/** 上浮，由下至上的堆有序*/
	protected void swim(int k) {
		while(k > 1 && less(k/2,k)) {
			exch(k/2,k);
			k = k / 2;
		}
	}
	
	/** 下沉*/
	protected void sink(int k) {
		while ( 2*k <= N ){
			int left = 2 * k;
			int right = 2 * k + 1;
			int max = left;
			if (right <= N && less (left,right)) { // 右结点没有越界 && 如果左结点小于右节点 
				max = right;
			}
			if (less(k,max)) { //小于子节点中最大的，需要交换，继续下沉
				exch(k,max);
				k = max;
			} else { // k 大于其子节点中最大的，说明到达
				break;
			}
		}
	}
	
}
