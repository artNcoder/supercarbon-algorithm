package com.supercarbon.algorithm.pearls.exercises;

import java.util.Random;

/**
 * @ClassName: MaxSubVector
 * @Description: 求解输入向量的最大子向量（指和最大）
 * @author zJun
 * @Date Jan 12, 2013 11:15:01 AM
 */
/*
 * 结果：1、N:10; Max:12; Time:0 ms
 */
public class MaxSubVector {

	/*
	 * 生成输入向量
	 */
	private static int[] vectorGenerator(int n) {
		int[] vector = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			vector[i] = random.nextInt() % n;
		}
		return vector;
	}

	/*
	 * 最简单的方法，简称方法1
	 */
	private static int easy(int[] vector) {
		int maxSoFar = 0;
		int vectorSize = vector.length;
		for (int i = 0; i < vectorSize; i++) {
			for (int j = i; j < vectorSize; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += vector[k];
					maxSoFar = Math.max(maxSoFar, sum);
				}
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int n = 10;
		long start = System.currentTimeMillis();
		int max = easy(vectorGenerator(n));
		long end = System.currentTimeMillis();
		System.out.println("Result is:");
		System.out.print("N:"+n+"; Max:" + max + "; Time:" + (end - start) + " ms");
	}

}
