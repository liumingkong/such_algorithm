package com.moon.algorithm.find;

/**
 * @ClassName: SignTable 
 * @Description: 符号表
 * @author liuzhao
 * @date 2013-6-12 上午1:00:24 
 * @param <Key>
 * @param <Value>
 * 
 * 实现原则：
 * 1.每个键只对应一个值（表中不允许存在重复的值）
 * 2.向表中存入的键值对喝表中已有的键值对冲突时，新的值会取代旧的值
 * 
 * 符号表中的删除操作包括两种：
 * 1.延时删除，将键对应的值置位空，在某个时刻删掉所有值为空的键
 * 2.即时删除，立刻从表中删除指定的键
 * 
 */
public abstract class SignTable<Key extends Comparable<Key>,Value> {

	/** 将键值对存入表中 ，若值为空则将键key从表中删除*/
	abstract void put(Key key, Value value) ; 
	
	/** 获取键key对应的值，若key不存在则返回null*/
	abstract Value get(Key key) ;
	
	/** 从表中删去键key(及其对应的值)*/
	abstract void delete(Key key);
	
	/** 表中的键值对数量*/
	abstract int size();
	
	/** 表中所有键的集合*/
	abstract Iterable<Key> keys();
	
	
	/** 键key在表中是否有对应的值*/
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	/** 表是否为空*/
	public boolean isEmpty() {
		return size() == 0;
	}
}
