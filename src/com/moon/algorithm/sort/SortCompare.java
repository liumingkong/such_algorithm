package com.moon.algorithm.sort;

import org.junit.Test;

public class SortCompare {

	@Test
	public void testCompareSort(){
		Integer[] testData = genData();
		Insertion insertion = new Insertion();
		Selection selection = new Selection();
		insertion.show(testData);
		System.out.println("time:"+ timeSort(insertion,testData));
		insertion.show(testData);
		testData = genData();
		selection.show(testData);
		System.out.println("time:"+ timeSort(selection,testData));
		selection.show(testData);
	}
	
	public long timeSort(SortService sortService,Comparable<?>[] data) {
		long start = System.nanoTime();
		sortService.sort(data);
		long stop = System.nanoTime();
		return (stop - start);
	}
	
	public Integer[] genData() {
		Integer[] testI = {1,3,4,5,6,2,5,5,11,3,4,5,6,2,5,5,7,23,3,4,5,6,2,5,5,7,7,9};
		return testI;
	}
}
