package com.moon.algorithm.stack.test;

import org.junit.Assert;
import org.junit.Test;

import com.moon.algorithm.stack.LinkedStack;

public class TestLinedNode {

	@Test
	public void testNode() {

		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("first");
		stack.push("secode");
		stack.push("third");
		for (String item: stack) {
			System.out.println(item);
		}
		Assert.assertEquals("third",stack.pop());
	}
}
