package com.naptex.study.dsa.sort;

public class QuickSort
{
	public void sort(int[] arr)
	{
		qsort(arr, 0, (arr.length - 1));
	}

	private void qsort(int[] arr, int low, int high)
	{
		if (low >= high)
		{
			return;
		}

		int pivotIndex = partition(arr, low, high);
		qsort(arr, low, (pivotIndex - 1));
		qsort(arr, (pivotIndex + 1), high);
	}

	public int partition(int[] arr, int low, int high)
	{
		int pivot = arr[low];

		int pivotIndex = low;
		for (int j = low + 1; j <= high; j++)
		{
			if (arr[j] < pivot)
			{
				pivotIndex++;
				swap(arr, pivotIndex, j);
			}
		}
		swap(arr, pivotIndex, low);

		return pivotIndex;
	}

	private void swap(int[] arr, int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
