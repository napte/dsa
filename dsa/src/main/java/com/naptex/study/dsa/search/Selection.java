package com.naptex.study.dsa.search;

public class Selection
{
	public int selectIthLargestElement(int[] arr, int i)
	{
		return select(arr, i, 0, arr.length - 1);
	}

	public int select(int[] arr, int i, int low, int high)
	{
		if (high == low)
		{
			return arr[low];
		}

		int pivotIndex = partition(arr, low, high);
		int k = pivotIndex - low;

		if (i == k)
		{
			return arr[pivotIndex];
		}
		else if (i < k)
		{
			return select(arr, i, low, pivotIndex - 1);
		}
		else
		{
			return select(arr, (i - (k + 1)), pivotIndex + 1, high);
		}
	}

	public int partition(int[] arr, int low, int high)
	{
		int pivotIndex = low;
		int pivot = arr[pivotIndex];

		for (int i = low + 1; i <= high; i++)
		{
			if (arr[i] < pivot)
			{
				pivotIndex++;
				swap(arr, pivotIndex, i);
			}
		}
		swap(arr, low, pivotIndex);
		return pivotIndex;
	}

	private void swap(int[] arr, int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
