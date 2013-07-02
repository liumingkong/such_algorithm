package com.moon.algorithm.sort.compara;

import java.util.Comparator;
 
public class Transaction {
	
	private Integer total;
	private Integer when;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getWhen() {
		return when;
	}
	public void setWhen(Integer when) {
		this.when = when;
	}
	
	/**继承Comparator接口，自定义排序方式*/
	public static class HowTotalComparator implements Comparator<Transaction>{
		
		@Override
		public int compare(Transaction o1, Transaction o2) { 
			return (o1.getTotal()).compareTo(o2.getTotal());
		}
	}
	
	/**第二种比较器
	 * 使用方法
	 * Insertion.sort(a, new HowWhenComparator())*/
	public static class HowWhenComparator implements Comparator<Transaction>{
		
		@Override
		public int compare(Transaction o1, Transaction o2) { 
			return (o1.getWhen()).compareTo(o2.getWhen());
		}
	}
}
