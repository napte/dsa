package com.naptex.study.dsa.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph<T>
{
	private List<Vertex<T>> vertices;

	public Graph(int vCount)
	{
		vertices = new ArrayList<>(vCount);
	}

	public void setVertices(List<Vertex<T>> vertices)
	{
		this.vertices = vertices;
	}

	public List<Vertex<T>> getVertices()
	{
		return vertices;
	}

	public void addVertex(T data)
	{
		Vertex<T> vertex = new Vertex<>(data);
		vertices.add(vertex);
	}

	public void addEdge(Vertex<T> source, Vertex<T> target, int weight)
	{
		AdjecencyEdge<T> adjEdge = new AdjecencyEdge<>(target, weight);
		source.getAdjList().add(adjEdge);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Iterator<Vertex<T>> iter = vertices.iterator();
		while (iter.hasNext())
		{
			Vertex<T> vertex = iter.next();
			sb.append(vertex.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
