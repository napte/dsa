package com.naptex.study.dsa.datastructures;

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
		Assert.assertEquals(11, rightChild);
	}

	@Test
	public void getLeft()
	{
		int i = 5;
		int leftChild = queue.getLeft(i);
		Assert.assertEquals(10, leftChild);
	}

	@Test
	public void getparentLeft()
	{
		int i = 4;
		int parent = queue.getParent(i);
		Assert.assertEquals(2, parent);
	}

	@Test
	public void getparentRight()
	{
		int i = 5;
		int parent = queue.getParent(i);
		Assert.assertEquals(2, parent);
	}

	@Test
	public void testSiftUpNoOp()
	{
		int[] arr = new int[] { 0, 1, 3, 5, 7, 12, 14, 6, 8 };
		queue.siftup(arr, 8);
		int[] expected = new int[] { 0, 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftUpOneLevel()
	{
		int[] arr = new int[] { 0, 1, 3, 5, 8, 12, 14, 6, 7 };
		queue.siftup(arr, 8);
		int[] expected = new int[] { 0, 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftUpToRoot()
	{
		int[] arr = new int[] { 0, 3, 4, 5, 7, 12, 14, 6, 1 };
		queue.siftup(arr, 8);
		int[] expected = new int[] { 0, 1, 3, 5, 4, 12, 14, 6, 7 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftDownNoOp()
	{
		int[] arr = new int[] { 0, 1, 3, 5, 7, 12, 14, 6, 8 };
		queue.siftDown(arr, 8);
		int[] expected = new int[] { 0, 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftDownOneLevel()
	{
		int[] arr = new int[] { 0, 5, 3, 1, 7, 12, 14, 6, 8 };
		queue.siftDown(arr, 8);
		int[] expected = new int[] { 0, 1, 3, 5, 7, 12, 14, 6, 8 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testSiftDownToLeaf()
	{
		int[] arr = new int[] { 0, 9, 3, 5, 7, 12, 14, 6, 8 };
		queue.siftDown(arr, 8);
		int[] expected = new int[] { 0, 3, 7, 5, 8, 12, 14, 6, 9 };
		Assert.assertArrayEquals(arr, expected);
	}

	@Test
	public void testIsEmpty()
	{
		PriorityQueue pq = new PriorityQueue();
		Assert.assertTrue(pq.isEmpty());
	}
}
