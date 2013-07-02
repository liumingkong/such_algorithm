package com.moon.pack.type;
 
/**
 * @ClassName: IndexMaxPq 
 * @Description: TODO
 * @author liuzhao
 * @date 2013-6-4 下午11:13:57 
 * 
 * 索引优先队列
 * 
 * 很多应用中，允许用例引用已经进入优先队列中的元素是有必要的
 * 做到这一点就要给每个元素一个索引。
 * 这里定义一种数据结构来索引这些元素。
 * 
 * 把索引优先队列看成一个能够快速访问其中最小元素的数组
 * 事实上，它能够快速访问数组的一个特定子集中的最大元素(指所有被插入的元素)
 * 
 * 不同于优先队列，less和exch是不同的，比较的是索引所指向的值，而不是索引本身
 * 
 */
public class IndexMaxPq<Item extends Comparable<Item>> {

	private int N; // PQ中的元素数量
	private int[] pq; // 索引二叉堆，由1开始
	private int[] qp; // 逆序，qp[pq[i]] = pq[qp[i]] = i;
	private Item[] items; // 有优先级之分的元素
	
	/**创建一个最大容量为maxN的优先队列，索引的范围0~maxN-1*/
	@SuppressWarnings("unchecked")
	public IndexMaxPq(int maxN) {
		items = (Item[]) new Comparable[maxN+1];
		pq = new int[maxN+1];
		qp = new int[maxN+1];
		for (int i=0;i<=maxN;i++) {
			qp[i] = -1;
		}
	}
	
	/**插入一个元素，将它与索引k关联*/
	public void insert(int k,Item item) {
		N ++;
		pq[N] = k; // 索引存储到pq，尾插
		qp[k] = N;  // 逆序
		items[k] = item; // 存储item
		swim(N); // 调整位置
	}
	
	/**将索引为k的元素设为item*/
	public void change(int k,Item item) { 
		items[k] = item;
		swim(qp[k]);
		sink(qp[k]);
	}
	
	/**是否存在所因为k的元素*/
	public boolean contains(int k) {
		return qp[k] != -1;
	}
	
	/** 删除索引k及其相关的元素*/
	public void delete(int k) {
		exch(k,N);
		N --;
		swim(qp[k]);
		sink(qp[k]);
		items[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
	}
	
	/** 返回最大元素*/
	public Item max() {
		return items[pq[1]];
	}
	
	/** 返回最大元素的索引*/
	public int maxIndex() {
		return pq[1];
	}
	
	/** 删除最大元素并返回它的索引*/
	public int delMax() {
		int maxIndex = pq[1];
		exch(1,N);
		N --;	
		sink(1);
		return maxIndex; 
	}
	
	/** 优先队列是否为空*/
	public boolean isEmpty() {
		return N == 0;
	}
	
	/** 优先队列的元素数量*/
	public int size() {
		return N;
	}
	
	/** 比较大小*/
	protected boolean less(int i, int j) {
		return items[pq[i]].compareTo(items[pq[j]]) < 0 ;
	}
	
	/** 交换两个元素*/
	protected void exch(int i,int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
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
