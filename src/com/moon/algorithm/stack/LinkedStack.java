package com.moon.algorithm.stack;

import java.util.Iterator;

import com.moon.pack.type.Node;

/**
 * @ClassName: LinkedStack 
 * @Description: 采用链表来实现栈
 * @author liuzhao
 * @date 2013-5-8 上午12:53:49 
 * 
 * 采用链表来实现栈达到了我们最佳设计目标：
 * 1.它可以处理任意类型的数据
 * 2.所需空间总是和集合大小成正比
 * 3.操作所需的时间总是和集合的大小无关
 * 
 */
public class LinkedStack<Item> implements Iterable<Item> {
	
	/** 栈中的元素数量*/
	private int size = 0;
	/** 栈顶元素 */
	private Node<Item> first;

	public LinkedStack()	 {
		
	}
	
	/**添加一个元素*/
	public void push(Item item) {
		Node<Item> newItem = new Node<Item>();
		newItem.item = item;
		newItem.next = this.first;
		this.first = newItem;
		size ++;
	}
	
	/**删除最近添加的元素*/
	public Item pop() {
		Item popItem = null;
		if (null != this.first ) {
			popItem = this.first.item;
			this.first = this.first.next;
			size --;
		}
		return popItem;
	}
	
	/**栈中是否为空*/
	public boolean isEmpty() {
		if ( 0 == size ) {
			return true;
		}
		return false;
	}
	
	/**栈中的元素数量*/
	public int size() {
		return this.size;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new LinkedIterator();
	}
	
	class LinkedIterator implements Iterator<Item> {

		private Node<Item> cursor = first;
		
		@Override
		public boolean hasNext() {
			boolean flag = true;
			if (null == cursor) {
				flag = false;
			}
			return flag;
		}

		@Override
		public Item next() {
			Item item = cursor.item;
			cursor = cursor.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
