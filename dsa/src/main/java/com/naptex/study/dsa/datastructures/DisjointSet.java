package com.naptex.study.dsa.datastructures;

public interface DisjointSet<T>
{
	/**
	 * Create a disjoint set containing only the specified element
	 * 
	 * @param e
	 */
	public void makeSet(T e);

	/**
	 * Returns the representative element of the set that contains the specified
	 * element
	 * 
	 * @param e
	 *            element to look up to
	 * @return the representative member of the containing set
	 */
	public T findSet(T e);

	/**
	 * Unites the sets that contain elements <code>x</code> and <code>y</code>
	 * 
	 * @param x
	 * @param y
	 */
	public void union(T x, T y);
}
