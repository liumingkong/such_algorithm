package com.moon.algorithm.stack;

import java.util.Iterator;

/**
 * @ClassName: Stack 
 * @Description: 先进后出的栈
 * @author liuzhao
 * @date 2013-5-3 上午1:52:03 
 * @param <Item>
 * 
 * 举例：邮件阅读，总是读最新的，即栈顶
 */
public class Stack <Item> implements Iterable<Item> {

	private int size;

	public Stack()	 {
		
	}
	
	/**添加一个元素*/
	public void push(Object item) {
		
	}
	
	/**删除最近添加的元素*/
	public Item pop() {
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
