package com.naptex.study.dsa.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SelectionTest
{
	Selection sel = new Selection();

	@Test
	public void testSelection()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		int low = 0;
		int high = arr.length - 1;
		int selected = sel.select(arr, 3, low, high);
		Assert.assertTrue(selected == 4);
	}

	@Test
	public void testSelectionMin()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		int low = 0;
		int high = arr.length - 1;
		int selected = sel.select(arr, 0, low, high);
		Assert.assertTrue(selected == 0);
	}

	@Test
	public void testSelectionMax()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		int low = 0;
		int high = arr.length - 1;
		int selected = sel.select(arr, 6, low, high);
		Assert.assertTrue(selected == 123);
	}

	@Test
	public void testSelectionRandom()
	{
		int size = 100;
		int[] arr = getRandomArray(size);
		int[] arr2 = arr.clone();
		Arrays.sort(arr2);

		int index = (int) (Math.random() * size);
		int selection = sel.selectIthLargestElement(arr, index);

		Assert.assertEquals(arr2[index], selection);
	}

	@Test
	public void testPartition()
	{
		int[] arr = new int[] { 4, 2, 5, 1, 0, 9, 123 };
		int low = 0;
		int high = arr.length - 1;
		int pivotIndex = sel.partition(arr, low, high);
		Assert.assertTrue(pivotIndex == 3);
	}

	@Test
	public void testPartitionPivotMin()
	{
		int[] arr = new int[] { -4, 2, 5, 1, 0, 9, 123 };
		int low = 0;
		int high = arr.length - 1;
		int pivotIndex = sel.partition(arr, low, high);
		Assert.assertTrue(pivotIndex == 0);
	}

	@Test
	public void testPartitionPivotMax()
	{
		int[] arr = new int[] { 400, 2, 5, 1, 0, 9, 123 };
		int low = 0;
		int high = arr.length - 1;
		int pivotIndex = sel.partition(arr, low, high);
		Assert.assertTrue(pivotIndex == 6);
	}

	@Test
	public void testPartitionRandom()
	{
		final int size = 100;
		int[] arr = getRandomArray(size);

		int pivot = arr[0];
		int[] arr2 = arr.clone();
		Arrays.sort(arr2);
		int expectedPivotIndex = Arrays.binarySearch(arr2, pivot);

		int low = 0;
		int high = arr.length - 1;
		int pivotIndex = sel.partition(arr, low, high);

		Assert.assertEquals(expectedPivotIndex, pivotIndex);
	}

	private int[] getRandomArray(final int size)
	{
		int[] arr = new int[size];
		List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		for (int i = 0; i < size; i++)
		{
			arr[i] = list.get(i);
		}
		return arr;
	}
}
