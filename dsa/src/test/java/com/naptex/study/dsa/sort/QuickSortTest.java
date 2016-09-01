package com.naptex.study.dsa.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest
{
	QuickSort sorter = new QuickSort();

	@Test
	public void testQuickSort()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { 0, 1, 2, 4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testQuickSortRep()
	{
		int[] arr = new int[] { -12, -12, -12, 4, 4, 4, 2, 5, 1, 0, 0, 9, 123,
				-10, -10 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { -12, -12, -12, -10, -10, 0, 0, 1, 2, 4, 4,
				4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testQuickSortDesc()
	{
		int[] arr = new int[] { 100, 50, 10, 5, 4, 3, 2, 1, 0, -1, -2, -50,
				-100 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testQuickSortAsc()
	{
		int[] arr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10, 50,
				100 };
		sorter.sort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}
}
