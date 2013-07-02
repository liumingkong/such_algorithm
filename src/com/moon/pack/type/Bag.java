package com.moon.pack.type;

import java.util.Iterator;

/**
 * @ClassName: Bag
 * @Description: 背包
 * @author liuzhao
 * @date 2013-4-25 上午12:24:55
 * @param <Item>
 * 
 * 背包是一种不支持删除操作的集合数据类型
 * 目的：帮助用例收集元素并迭代遍历所有收集到的元素。
 * 迭代的顺序是不确定的，并且与用例无关。
 * 背包重点用来说明元素的顺序不重要
 * 
 * 举例：计算平方根或者统计平均值，这种需求是不需要care顺序的
 * 
 * Tips:
 * 
 * 泛型相当于数据结构中的抽象数据类型
 * <Item>相当于一个记号，将Item定义为一个“类型参数”，
 * 一个象征性的占位符，在使用时可以替换成任何引用类型
 * Item本身没有任何名称意义，也可以叫Ite，Iter....
 * 这属于java1.5以后才提供的泛型方式。
 * 
 * 类型参数必须被实例化为引用类型，
 * 原始数据类型也有自己对应的引用类型，并且支持自动装箱和拆箱
 * 
 * 
 */  
public class Bag<Item> implements Iterable<Item> {

	private int size;
	
	/**创建一个空背包*/
	public Bag() {
		
	}
	
	/**添加一个元素*/
	public void add(Item item) {
		
	}
	
	/**背包中是否为空*/
	public boolean isEmpty() {
		if ( 0 == size ) {
			return true;
		}
		return false;
	}
	
	/**背包中的元素数量*/
	public int size() {
		return this.size;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
