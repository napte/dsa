package com.naptex.study.dsa.graphs.algo;

import com.naptex.study.dsa.graphs.Vertex;

public class SpanningTreeEdge<T> implements Comparable<SpanningTreeEdge<T>>
{
	private Vertex<T> source;
	private Vertex<T> target;
	private int weight;

	public SpanningTreeEdge(Vertex<T> source, Vertex<T> target, int weight)
	{
		super();
		this.source = source;
		this.target = target;
		this.weight = weight;
	}

	public Vertex<T> getSource()
	{
		return source;
	}

	public Vertex<T> getTarget()
	{
		return target;
	}

	public int getWeight()
	{
		return weight;
	}

	@Override
	public String toString()
	{
		return "Edge [" + source.getData() + " -- " + target.getData() + ", wt="
				+ weight + "]";
	}

	@Override
	public int compareTo(SpanningTreeEdge<T> o)
	{
		return new Integer(getWeight()).compareTo(new Integer(o.getWeight()));
	}
}
