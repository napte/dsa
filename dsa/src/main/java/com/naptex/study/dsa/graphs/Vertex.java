package com.naptex.study.dsa.graphs;

import java.util.HashSet;
import java.util.Set;

public class Vertex<T>
{
	private T data;
	private Set<AdjecencyEdge<T>> adjList;

	public Vertex(T data)
	{
		this.data = data;
		adjList = new HashSet<>();
	}

	public T getData()
	{
		return data;
	}

	public Set<AdjecencyEdge<T>> getAdjList()
	{
		return adjList;
	}

	public void setAdjList(Set<AdjecencyEdge<T>> adjList)
	{
		this.adjList = adjList;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Vertex other = (Vertex) obj;
		if (data == null)
		{
			if (other.data != null)
				return false;
		}
		else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return data + ", ==> " + adjList;
	}
}
