package com.moon.algorithm.sort;

import org.junit.Test;

import com.moon.pack.type.MaxPQ;

public class TestMaxPQ {

	@Test
	public void testSort() {
		Integer[] testI = {1,3,4,5,6,2,5,5,7,9,1};
		MaxPQ<Integer> maxPq = new MaxPQ<Integer>(20);
		for (Integer i:testI) {
			maxPq.Insert(i);
		}
		for(int i = 0;i<11;i++) {
			System.out.println(maxPq.delMax());
		}
	}
	
	
}
