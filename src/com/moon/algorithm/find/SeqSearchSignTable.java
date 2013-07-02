package com.moon.algorithm.find;

/**
 * @ClassName: SeqSearchSignTable 
 * @Description: 顺序查找（基于无序链表）
 * @author liuzhao
 * @date 2013-6-13 上午1:00:12 
 * 
 * 无序链表中的顺序查找
 * 符号表采用的数据结构的一个简单选择是链表，每个结点存储一个键值对
 * 1.get()的实现即为遍历链表，用equal比较需要被查找的键和每个结点中的键
 * 匹配成功就返回相应的值，否则我们返回null。
 * 
 * 2.put的实现遍历链表，用equal比较键，
 * 匹配成功就用第二参数指定的值更新对应的值
 * 否则就用给定的键值对创建一个新的结点并将其插入到链表的开头
 * 查找的过程是逐个匹配所有的键的方法：顺序查找
 * 
 * 
 */
public class SeqSearchSignTable<Key extends Comparable<Key>, Va,Value> extends SignTable<Key,Value>{

	/** 链表的头结点*/
	private Node first; 
	/** 结点*/
	private class Node {
		Key key;
		Value value;
		Node next;
	}
	/** 结点总数*/
	private int size;
	
	public SeqSearchSignTable() {
		first = new Node(); // 初始化
		size= 0;
	}
	
	@Override
	void put(Key key, Value value) {
		Node p = getNode(key);
		if (null != p) {
			if (value == null) { // value为空，删掉这个键
				delete(key); 
			} else { // 不为空，更新这个键
				p.value = value; 
			}
			return;
		}
		insertNode(key,value);
	}
	
	/** 创建一个新的结点并将其插入到链表的开头*/
	private void insertNode(Key key, Value value) { // key,value都不为空
		Node node = new Node();
		node.key = key;
		node.value = value;
		node.next = first.next;
		first.next = node;
		size ++;
	}
	
	/** 查找指定结点的指针,返回结果*/
	private Node getNode(Key key) {
		if (key == null) { // key 不能为null
			return null;
		}
		Node p = first;
		while(p != null) {
			if (key.equals(p.key)) { // key已经存在
				return p;
			}
			p = p.next;
		}
		return null;
	}
	
	@Override
	Value get(Key key) {
		Node p = getNode(key);
		if (null != p) {
			return p.value;
		}
		return null;
	}
	
	@Override
	void delete(Key key) {
		Node p = getNode(key);
		if (null != p) {
			Node q = first;
			while(q.next != q) {
				q = q.next;
			}
			q.next = p.next;
		}
	}
	
	@Override
	int size() {
		return this.size;
	}
	@Override
	Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}
}
