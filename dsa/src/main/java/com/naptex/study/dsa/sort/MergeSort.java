package com.naptex.study.dsa.sort;

public class MergeSort
{
	/**
	 * Tuning parameter: list size at or below which insertion sort will be used
	 * in preference to mergesort.
	 */
	private static final int INSERTIONSORT_THRESHOLD = 3;

	public void sort(int[] arr)
	{
		mergeSort(arr, 0, (arr.length - 1));
	}

	private void mergeSort(int[] arr, int low, int high)
	{
		if ((high - low) < INSERTIONSORT_THRESHOLD)
		{
			insertionSort(arr, low, high);
			return;
		}

		int mid = low + ((high - low) / 2);
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);

		merge(arr, low, high, mid);
	}

	public void merge(int[] arr, int low, int high, int mid)
	{
		int len = high - low + 1;
		int[] arrMerge = new int[len];

		int p = low;
		int q = mid + 1;

		int r = 0;
		while (p <= mid && q <= high)
		{
			if (arr[p] <= arr[q])
			{
				arrMerge[r] = arr[p];
				p++;
			}
			else
			{
				arrMerge[r] = arr[q];
				q++;
			}
			r++;
		}

		while (p <= mid)
		{
			arrMerge[r++] = arr[p++];
		}

		while (q <= high)
		{
			arrMerge[r++] = arr[q++];
		}

		for (int i = 0; i < len; i++)
		{
			arr[low + i] = arrMerge[i];
		}
	}

	public void insertionSort(int[] arr, int low, int high)
	{
		for (int i = low; i <= high; i++)
		{
			int j = i;
			while (j > 0 && (arr[j] < arr[j - 1]))
			{
				swap(arr, j, (j - 1));
				j--;
			}
		}
	}

	private void swap(int[] arr, int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
