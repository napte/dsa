package com.naptex.study.dsa.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest
{
	@Test
	public void testInsertionSort()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		MergeSort sorter = new MergeSort();
		sorter.insertionSort(arr);
		int[] sortedArr = new int[] { 0, 1, 2, 4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testInsertionSortRep()
	{
		int[] arr = new int[] { -12, -12, -12, 4, 4, 4, 2, 5, 1, 0, 0, 9, 123,
				-10, -10 };
		MergeSort sorter = new MergeSort();
		sorter.insertionSort(arr);
		int[] sortedArr = new int[] { -12, -12, -12, -10, -10, 0, 0, 1, 2, 4, 4,
				4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testInsertionSortDesc()
	{
		int[] arr = new int[] { 100, 50, 10, 5, 4, 3, 2, 1, 0, -1, -2, -50,
				-100 };
		MergeSort sorter = new MergeSort();
		sorter.insertionSort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testInsertionSortAsc()
	{
		int[] arr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10, 50,
				100 };
		MergeSort sorter = new MergeSort();
		sorter.insertionSort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testMerge()
	{
		int[] arr = new int[] { 10, 20, 30, 40, 1, 3, 13, 23 };
		MergeSort sorter = new MergeSort();
		int low = 0;
		int high = arr.length - 1;
		int mid = low + ((high - low) / 2);

		sorter.merge(arr, low, high, mid);
		int[] merged = new int[] { 1, 3, 10, 13, 20, 23, 30, 40 };
		Assert.assertTrue(Arrays.equals(arr, merged));
	}

	@Test
	public void testMergeEqual()
	{
		int[] arr = new int[] { 10, 20, 30, 40, 10, 20, 30, 40 };
		MergeSort sorter = new MergeSort();
		int low = 0;
		int high = arr.length - 1;
		int mid = low + ((high - low) / 2);

		sorter.merge(arr, low, high, mid);
		int[] merged = new int[] { 10, 10, 20, 20, 30, 30, 40, 40 };
		Assert.assertTrue(Arrays.equals(arr, merged));
	}

	@Test
	public void testMergeSort()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		MergeSort sorter = new MergeSort();
		sorter.sort(arr);
		int[] sortedArr = new int[] { 0, 1, 2, 4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testMergeSortRep()
	{
		int[] arr = new int[] { -12, -12, -12, 4, 4, 4, 2, 5, 1, 0, 0, 9, 123,
				-10, -10 };
		MergeSort sorter = new MergeSort();
		sorter.sort(arr);
		int[] sortedArr = new int[] { -12, -12, -12, -10, -10, 0, 0, 1, 2, 4, 4,
				4, 5, 9, 123 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testMergeSortDesc()
	{
		int[] arr = new int[] { 100, 50, 10, 5, 4, 3, 2, 1, 0, -1, -2, -50,
				-100 };
		MergeSort sorter = new MergeSort();
		sorter.sort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}

	@Test
	public void testMergeSortAsc()
	{
		int[] arr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10, 50,
				100 };
		MergeSort sorter = new MergeSort();
		sorter.sort(arr);
		int[] sortedArr = new int[] { -100, -50, -2, -1, 0, 1, 2, 3, 4, 5, 10,
				50, 100 };
		Assert.assertTrue(Arrays.equals(arr, sortedArr));
	}
}
