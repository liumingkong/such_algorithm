package com.moon.pack.type;

/**
 * @ClassName: Node 
 * @Description: 单链表
 * @author liuzhao
 * @date 2013-5-7 下午11:12:18 
 * @param <Item>
 * 
 * 链表是一种递归型数据结构
 * 
 * 单链表无法实现任意插入和删除，标准实现方式:双向链表
 * 
 * 闲扯淡：
 * 在结构数据集合的发展历史中，链表是数组的一种重要替代方式，有几十年的历史
 * 事实上，编程语言上的一个重要里程碑就是McCathy在20世纪50年代发明的LISP语言
 * 链表则是该语言组织程序和数据的主要结构。
 * 
 */
public class Node<Item> {

	public Item item;
	public Node<Item> next;
}
