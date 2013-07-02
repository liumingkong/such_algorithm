package com.moon.algorithm.stack.test;

import java.util.Stack;

import org.junit.Test;

/**
 * @ClassName: Evaluate 
 * @Description: Dijkstra双栈表达式
 * @author liuzhao
 * @date 2013-5-4 下午12:53:34 
 * 
 * 表达式由运算符，括号，操作数组成
 * 从左到右逐个将数据存入到栈中，进行计算
 * 1.将操作数存入操作数栈
 * 2.将运算符存入运算符栈
 * 3.忽略左括号
 * 4.在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈
 * 
 * (1+((2+3)*(4*5)))
 * (1+(5*(4*5)))
 * (1+(5*20))
 * (1+100)
 * 101
 * 
 */
public class Evaluate {
	
	public static Double dijkstraCaculate(char[] expression) {
		double value = 0;
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		for (int i = 0 ; i<expression.length ; i++) {
			String valStr = String.valueOf(expression[i]);
			if ("(".equals(valStr)) {
			   	
			} else if ("+".equals(valStr) || "-".equals(valStr) || "*".equals(valStr) || "/".equals(valStr)) {
				ops.push(valStr); // 运算符压栈
			} else if (")".equals(valStr)) {
				String op = ops.pop();
				double v = vals.pop();
				if (null == op || 0.0 == v) {
					return value;
				}
				if ("+".equals(op)) v = vals.pop() + v;
				else if ("-".equals(op)) v = vals.pop() - v;
				else if ("*".equals(op)) v = vals.pop() * v;
				else if ("/".equals(op)) v = vals.pop() / v;
				vals.push(v);
			} else {
				vals.push(Double.parseDouble(valStr));
			}
		}
		value = vals.pop();
		return value;
	}
	
	@Test
	public void evalTest(){
		String str = "(1+(((2+3)*(4*5))+4))";
		char[] split = str.toCharArray();
		System.out.println(dijkstraCaculate(split));
	}
}
