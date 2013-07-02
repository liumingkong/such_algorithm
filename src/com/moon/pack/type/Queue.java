package com.moon.pack.type;

import java.util.Iterator;

/**
 * @ClassName: Queue 
 * @Description: 先进先出的队列
 * @author liuzhao
 * @date 2013-5-3 上午1:47:16 
 * @param <Item>
 * 
 * 队列：先入先出
 * 最早到来最先服务的原则
 */
public class Queue <Item> implements Iterable<Item> {

	private int size;
	
	/**创建一个*/
	public Queue() {
		
	}
	
	/**添加一个元素*/
	public void enqueue(Item item) {
		
	}
	
	/**删除最近添加的元素*/
	public void dequeue() {
		
	}
	
	/**队列中是否为空*/
	public boolean isEmpty() {
		if ( 0 == size ) {
			return true;
		}
		return false;
	}
	
	/**队列中的元素数量*/
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
