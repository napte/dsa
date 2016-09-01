package com.naptex.study.dsa.datastructures;

public class PriorityQueue
{
	private static final int MAX_SIZE = 100;

	private final int[] queue = new int[MAX_SIZE];
	private int size;

	public void insert(int data)
	{
		size++;
		queue[size] = data;

		siftup(queue, size);
	}

	public int extractMin()
	{
		int min = queue[1];
		swap(queue, 1, size);
		size--;
		siftDown(queue, size);

		return min;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * Sifts up the element arr[index] to its appropriate position in the heap
	 * 
	 * @param arr
	 *            the array representing the heap
	 * @param index
	 *            index of element to be sifted up
	 */
	public void siftup(int[] arr, int index)
	{
		int i = index;
		while (i > 1)
		{
			int parent = getParent(i);
			int parentEl = arr[parent];
			int element = arr[i];

			if (parentEl < element)
			{
				break;
			}

			swap(arr, i, parent);
			i = parent;
		}
	}

	/**
	 * Sifts down the element at arr[1] to its appropriate position in the heap
	 * 
	 * @param arr
	 *            the array representing the heap
	 * @param size
	 *            size of heap
	 */
	public void siftDown(int[] arr, int size)
	{
		int i = 1;
		while (i <= size)
		{
			int left = getLeft(i);
			if (left > size)
			{
				break;
			}

			int leftChild = arr[left];
			int minChild = leftChild;
			int minIndex = left;

			int right = getRight(i);
			if (right <= size)
			{
				int rightChild = arr[right];
				if (rightChild < minChild)
				{
					minChild = rightChild;
					minIndex = right;
				}
			}

			int element = arr[i];
			if (element <= minChild)
			{
				break;
			}

			swap(arr, i, minIndex);
			i = minIndex;
		}
	}

	public int getParent(int i)
	{
		return i / 2;
	}

	public int getLeft(int i)
	{
		return (2 * i);
	}

	public int getRight(int i)
	{
		return ((2 * i) + 1);
	}

	public void swap(int[] arr, int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
