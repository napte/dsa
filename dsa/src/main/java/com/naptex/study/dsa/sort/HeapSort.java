package com.naptex.study.dsa.sort;

public class HeapSort
{
	public void sort(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			siftup(arr, i);
		}

		for (int i = arr.length - 1; i > 0; i--)
		{
			swap(arr, i, 0);
			siftDown(arr, i);
		}
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
		while (i > 0)
		{
			int parent = getParent(i);
			int parentEl = arr[parent];
			int element = arr[i];

			if (parentEl > element)
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
		int i = 0;
		while (i < size)
		{
			int left = getLeft(i);
			if (left >= size)
			{
				break;
			}

			int leftChild = arr[left];
			int maxChild = leftChild;
			int maxIndex = left;

			int right = getRight(i);
			if (right < size)
			{
				int rightChild = arr[right];
				if (rightChild > maxChild)
				{
					maxChild = rightChild;
					maxIndex = right;
				}
			}

			int element = arr[i];
			if (element >= maxChild)
			{
				break;
			}

			swap(arr, i, maxIndex);
			i = maxIndex;
		}
	}

	public int getParent(int i)
	{
		return (i - 1) / 2;
	}

	public int getLeft(int i)
	{
		return (2 * i) + 1;
	}

	public int getRight(int i)
	{
		return ((2 * i) + 2);
	}

	public void swap(int[] arr, int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
