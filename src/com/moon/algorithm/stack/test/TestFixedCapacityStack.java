package com.moon.algorithm.stack.test;

import org.junit.Test;

import com.moon.algorithm.stack.FixedCapacityStack;
import com.moon.algorithm.stack.ResizingCapacityStack;

public class TestFixedCapacityStack {

	//@Test
	public void testFixed() {
		FixedCapacityStack stack = new FixedCapacityStack();
		String str = "abcdefghighlmn";
		char[] request = str.toCharArray();
		for (int i = 0;i<str.length();i++) {
			stack.push(String.valueOf(request[i]));
		}
		for (int i = 0;i<str.length();i++) {
			System.out.print(stack.pop());;
		}
		System.out.println();
	}
	
	@Test
	public void testFixed2() {
		ResizingCapacityStack<String> stack = new ResizingCapacityStack<String>();
		String str = "abcdefghig";
		char[] request = str.toCharArray();
		for (int i = 0;i<str.length();i++) {
			stack.push(String.valueOf(request[i]));
			System.out.println(stack.toString());;
		}
//		for (int i = 0;i<str.length();i++) {
//			System.out.print(stack.pop());;
//		}
		
		for(String item:stack) {
			System.out.print(item);;
		}
		System.out.println();
	}
}
