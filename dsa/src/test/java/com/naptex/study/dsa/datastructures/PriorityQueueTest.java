package com.naptex.study.dsa.datastructures;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest
{
	private final PriorityQueue queue = new PriorityQueue();

	@Test
	public void testSwap()
	{
		int[] arr = new int[] { 1, 3, 5, 7, 2, 4, 6, 8 };
		queue.swap(arr, 2, 4);
		int[] expected = new int[] { 1, 3, 2, 7, 5, 4, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void getRight()
	{
		int i = 5;
		int rightChild = queue.getRight(i);
		Assert.assertEquals(12, rightChild);
	}

	@Test
	public void getLeft()
	{
		int i = 5;
		int leftChild = queue.getLeft(i);
		Assert.assertEquals(11, leftChild);
	}

	@Test
	public void getParentLeft()
	{
		int i = 5;
		int parent = queue.getParent(i);
		Assert.assertEquals(2, parent);
	}

	@Test
	public void getParentRight()
	{
		int i = 6;
		int parent = queue.getParent(i);
		Assert.assertEquals(2, parent);
	}

	@Test
	public void testSiftUpNoOp()
	{
		int[] arr = new int[] { 1, 3, 5, 7, 12, 14, 6, 8 };
		queue.siftup(arr, 7);
		int[] expected = new int[] { 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftUpOneLevel()
	{
		int[] arr = new int[] { 1, 3, 5, 8, 12, 14, 6, 7 };
		queue.siftup(arr, 7);
		int[] expected = new int[] { 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftUpToRoot()
	{
		int[] arr = new int[] { 3, 4, 5, 7, 12, 14, 6, 1 };
		queue.siftup(arr, 7);
		int[] expected = new int[] { 1, 3, 5, 4, 12, 14, 6, 7 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftDownNoOp()
	{
		int[] arr = new int[] { 1, 3, 5, 7, 12, 14, 6, 8 };
		queue.siftDown(arr, 8);
		int[] expected = new int[] { 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftDownOneLevel()
	{
		int[] arr = new int[] { 5, 3, 1, 7, 12, 14, 6, 8 };
		queue.siftDown(arr, 8);
		int[] expected = new int[] { 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftDownToLeaf()
	{
		int[] arr = new int[] { 9, 3, 5, 7, 12, 14, 6, 8 };
		queue.siftDown(arr, 8);
		int[] expected = new int[] { 3, 7, 5, 8, 12, 14, 6, 9 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testIsEmpty()
	{
		PriorityQueue pq = new PriorityQueue();
		Assert.assertTrue(pq.isEmpty());
	}

	@Test
	public void testIsNotEmpty()
	{
		PriorityQueue pq = new PriorityQueue();
		pq.insert(10);
		Assert.assertFalse(pq.isEmpty());
	}

	@Test
	public void testFunctioning()
	{
		PriorityQueue pq = new PriorityQueue();
		pq.insert(5);
		pq.insert(15);
		pq.insert(5);
		pq.insert(10);
		pq.insert(2);

		int min = pq.extractMin();
		Assert.assertEquals(2, min);
		min = pq.extractMin();
		Assert.assertEquals(5, min);
		min = pq.extractMin();
		Assert.assertEquals(5, min);
		min = pq.extractMin();
		Assert.assertEquals(10, min);
		min = pq.extractMin();
		Assert.assertEquals(15, min);

		Assert.assertTrue(pq.isEmpty());
	}

	@Test
	public void testFunctioning2()
	{
		PriorityQueue pq = new PriorityQueue();
		for (int i = 0; i < 100; i++)
		{
			pq.insert((int) (Math.random() * 100));
		}

		int[] arr = new int[100];
		for (int i = 0; i < 100; i++)
		{
			arr[i] = pq.extractMin();
		}

		int[] arr2 = arr.clone();
		Arrays.sort(arr2);

		Assert.assertArrayEquals(arr, arr2);
	}
}
