package com.naptex.study.dsa.graphs;

public class AdjecencyEdge<T>
{
	private Vertex<T> target;
	int weight;

	public AdjecencyEdge(Vertex<T> target, int weight)
	{
		super();
		this.target = target;
		this.weight = weight;
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
		return "(" + target.getData() + ", wt=" + weight + ")";
	}

}
