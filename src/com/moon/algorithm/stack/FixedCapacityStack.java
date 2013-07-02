package com.moon.algorithm.stack;

/**
 * @ClassName: FixedCapacityStack 
 * @Description: 定容栈
 * @author liuzhao
 * @date 2013-5-7 上午12:18:20 
 * 
 * 定容栈，采用数组的形式，长度是固定的。
 * 
 * 问题：
 * 
 * 1.类型固定->泛型
 * java不支持泛型数组（历史问题）
 * 采用如下方法即可：
 * stackCache = (Item[])new Object[defalutLength];
 * 
 * 2.长度限制->动态调整
 * 
 * 3.内存泄露，对象游离，每次pop出来，并没有真正释放对象
 * 将弹出的对象设置为null即可
 * 
 * 4.缺少迭代功能
 * for(String s : stack) ,参见后面的实现
 * 
 */
public class FixedCapacityStack {

	private int size = 0;
	private int defalutLength = 10;
	private String[] stackCache;
	
	public FixedCapacityStack()	 {
//		stackCache = new Item[5]; java不支持泛型数组
		stackCache = new String[defalutLength];
	}
	
	public FixedCapacityStack(int length)	 {
		stackCache = new String[length];
	}
	
	/**添加一个元素*/
	public void push(String item) { 
		if ( size <= (stackCache.length-1)) { 
			stackCache[size] = item;
			size ++;
		}
	}
	
	/**删除最近添加的元素*/
	public String pop() {
		String ret = "";
		if ( size > 0) {
			size --;
			ret = stackCache[size]; 
		}
		return ret;
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
}
