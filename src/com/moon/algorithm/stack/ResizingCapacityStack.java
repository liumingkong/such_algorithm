package com.moon.algorithm.stack;

import java.util.Iterator;

/**
 * @ClassName: ResizingCapacityStack 
 * @Description: 用来解决定容栈的局限
 * @author liuzhao
 * @date 2013-5-7 下午2:57:12 
 * 
 * 如何实现迭代功能？
 * (1)集合数据类型必须实现一个iterator方法并返回一个Iterator对象。
 * (2)Iterator类必须包含两个方法:hasNext(),next()
 * Java中的实现方式是在类的声明中实现Iterable接口，并实现Iterator<Item> iterator()方法
 * 一般是自己实现一个实现Iterator接口的类，即自己实现迭代器
 * 
 * 这个例子十分重要，几乎达到了任意集合数据类型实现的最佳性能
 * 1.每个操作的用时都与集合大小没有关系
 * 2.空间需求总是不超过集合大小乘以一个常数
 * 缺点是push和pop会调整数组的大小，耗时和栈内元素的多少成正比
 * 
 */
@SuppressWarnings("unchecked")
public class ResizingCapacityStack<Item> implements Iterable<Item>{

	/** 当前栈顶指针的上一个位置，0 ~ (stackCache.length) */
	private int size = 0 ;
	/** 栈容量的默认值*/
	private int defalutLength = 5;
	/** 栈容量的底限*/
	private int minSize = 5; 
	/** 调整因子*/
	private int sizeFactor = 2;
	/** 栈 */
	private Item[] stackCache;
	
	public ResizingCapacityStack()	 {
//		stackCache = new Item[5]; java不支持泛型数组
		stackCache = (Item[])new Object[defalutLength];
	}
	 
	public ResizingCapacityStack(int length)	 {
		stackCache = (Item[])new Object[length];
	}
	
	/**添加一个元素*/
	public void push(Item item) {  
		System.out.println("item:"+item+",newStackSize:" + this.size );
		if (stackCache.length <= this.size ) { // 加入元素后，栈容量的大小
			expandStack();
		}
		stackCache[size] = item;
		size ++ ;
	}

	/**删除栈顶元素*/
	public Item pop() {
		Item item = null;
		if ( this.size  > 0) { // 说明仍然包含内容
			size -- ;
			item = stackCache[size];
			stackCache[size] = null; // 解决对象游离
			if ( this.size  <= (stackCache.length/4) ) {
				reduceStack();
			}
		}
		return item;
	}
	
	/**栈中是否为空*/
	public boolean isEmpty() {
		if ( 0 == this.size ) {
			return true;
		}
		return false;
	}
	
	/** 扩展栈的大小：新的栈容量 = 当前栈容量 * 因子 */
	private void expandStack () {
		int stackLength = stackCache.length;
		int expandLength = stackLength * sizeFactor;
		resize (expandLength) ;
	}
	
	/** 缩小栈的大小：新的栈容量 = 当前栈容量 / 因子 */
	private void reduceStack () {
		int stackLength = stackCache.length;
		int reduceLength = stackLength / sizeFactor;
		if (reduceLength >= minSize) { // 如果高于下限，可以继续进行缩小
			resize (reduceLength) ;
		}
	}
	
	/** 调整栈的大小*/
	private void resize(int max) {
		Item[] newStack = (Item[])new Object[max];
		for (int i = 0 ; i < size ; i++ ) {
			newStack[i] = stackCache[i];
			stackCache[i] = null;
		}
		stackCache = newStack; 
	}
	
	/** 打印出当前栈的内容 */
	public String toString() {
		String stackItemStr = "";
		for (Item item:stackCache) {
			if (null != item) {
				stackItemStr = stackItemStr + ":" + String.valueOf(item);
			}		
		}
		return stackItemStr + ",size:" + this.size +",capacity:"+stackCache.length;
	}

	@Override
	public Iterator<Item> iterator() { 
		return new ReverseArrayIterator();
	}
	
	/**
	 * @ClassName: ReverseArrayIterator 
	 * @Description: 实现迭代器，放在栈的代码内实现
	 * @author liuzhao
	 * @date 2013-5-7 下午7:56:01 
	 * @param <Item>
	 */
	class ReverseArrayIterator implements Iterator<Item> {

		private int cursor = 0;
		
		@Override
		public boolean hasNext() {
			boolean flag = true;
			if (cursor >= size) {
				flag = false;
			} 
			return flag;
		}

		@Override
		public Item next() {
			return stackCache[cursor++];
		}

		@Override
		public void remove() {
			
		}
		
	}
}


