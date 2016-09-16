package com.naptex.study.dsa.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NaiveDisjointSet<T> implements DisjointSet<T>
{
	List<Set<T>> disJointSet = new ArrayList<>();

	@Override
	public void makeSet(T e)
	{
		Set<T> set = new LinkedHashSet<>();
		set.add(e);
		disJointSet.add(set);
	}

	@Override
	public T findSet(T e)
	{
		for (Set<T> set : disJointSet)
		{
			if (set.contains(e))
			{
				Iterator<T> iter = set.iterator();
				return iter.next();
			}
		}

		return null;
	}

	@Override
	public void union(T x, T y)
	{
		Set<T> setX = null;
		Set<T> setY = null;

		for (int i = 0; i < disJointSet.size(); i++)
		{
			Set<T> set = disJointSet.get(i);
			if (set.contains(x))
			{
				setX = set;
			}
			if (set.contains(y))
			{
				setY = set;
			}
		}

		if (setX == null || setY == null)
		{
			throw new IllegalArgumentException("Element " + x + " or " + y
					+ " not found in the disjoint set");
		}

		setX.addAll(setY);
		disJointSet.remove(setY);
	}

	public int size()
	{
		return disJointSet.size();
	}

}
