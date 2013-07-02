package com.moon.algorithm.find;

/**
 * @ClassName: BinarySearchST 
 * @Description: 有序数组的二分查找
 * @author liuzhao
 * @date 2013-6-15 下午11:41:10 
 * @param <Key>
 * @param <Value>
 * 
 * 
 * 
 */
@SuppressWarnings("unused")
public class BinarySearchST<Key extends Comparable<Key>, Value> extends SignTable<Key, Value> {
 
	@SuppressWarnings("hiding")
	private class Node<Key, Value> {
		Key key;
		Value value;
	}
	/** 存储所有的结点*/
	private Node<Key, Value> nodes[];
	/** 存储的元素总量*/
	private Integer N;
	
	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		/** java 不支持泛型数组*/
		nodes = new Node[capacity];
	}
	
	@Override
	void put(Key key, Value value) {
		if (key == null) {
			System.out.println("put key is null"); 
			return;
		}
		if (N == nodes.length) {
			System.out.println("the table is overflow"); 
			return;
		}
		int index = getInsertPoiBybinarySearch(key);
		if (key == nodes[index].key) { // 已经存在则更新
			if (value == null) {
				delete(key); 
			} else {
				nodes[index].value = value;
			}
		} else {
			move(index);
			Node<Key, Value> node = new Node<Key, Value>();
			node.key = key;
			node.value = value;
			nodes[index] = node;
		}
	}

	@Override
	Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 二分查找的实现*/
	public boolean binarySearch(Key key) {
		int low = 0;
		int high = nodes.length - 1;
		while (true) {
			if (low > high) break ; // return low  
			int mid = (low + high) / 2 ;
			int result = key.compareTo(nodes[mid].key);
			if (result < 0 ) {
				high = mid - 1;
			} else if (result > 0) {
				low = mid + 1;
			} else {
				return true; // return mid
			}
		}
		return false;
	}
	
	/** 二分查找的实现, 返回合适位置*/
	public int getInsertPoiBybinarySearch(Key key) {
		int low = 0;
		int high = nodes.length - 1;
		int tag = 0;
		while (true) {
			if (low > high) {
				tag = low;
				break ; // return low  
			}
			int mid = (low + high) / 2 ;
			int result = key.compareTo(nodes[mid].key);
			if (result < 0 ) {
				high = mid - 1;
			} else if (result > 0) {
				low = mid + 1;
			} else {
				tag = mid;
				break; // return mid
			}
		}
		return tag;
	}
	
	/** 把所有元素，从index处向后移动一个位置*/
	public void move(int index) {
		if (index == N ) return;
		for(int i = N; i >= 0; i --) {
			if (index == i) break;
			exch(i,i-1);
		}
	}
	
	/** 交换两个元素*/
	private void exch(int i,int j){
		Node<Key, Value> temp = nodes[i];
		nodes[i] = nodes[j];
		nodes[j] = temp;
	}
	
	
	@Override
	void delete(Key key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
