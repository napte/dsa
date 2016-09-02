package com.naptex.study.dsa.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest
{
	HeapSort sorter = new HeapSort();

	@Test
	public void testHeapSort()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { 0, 1, 2, 4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testHeapSortRep()
	{
		int[] arr = new int[] { -12, -12, -12, 4, 4, 4, 2, 5, 1, 0, 0, 9, 123,
				-10, -10 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { -12, -12, -12, -10, -10, 0, 0, 1, 2, 4, 4,
				4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testHeapSortDesc()
	{
		int[] arr = new int[] { 100, 50, 10, 5, 4, 3, 2, 1, 0, -1, -2, -50,
				-100 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testHeapSortAsc()
	{
		int[] arr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10, 50,
				100 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testHeapSortRndom()
	{
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++)
		{
			arr[i] = ((int) (Math.random() * 100));
		}
		int[] arr2 = arr.clone();

		sorter.sort(arr);
		Arrays.sort(arr2);

		Assert.assertArrayEquals(arr2, arr);
	}
}
