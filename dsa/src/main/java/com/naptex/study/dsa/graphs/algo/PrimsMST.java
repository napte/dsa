package com.naptex.study.dsa.graphs.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.naptex.study.dsa.graphs.AdjecencyEdge;
import com.naptex.study.dsa.graphs.Graph;
import com.naptex.study.dsa.graphs.Vertex;

public class PrimsMST<T>
{
	public List<SpanningTreeEdge<T>> getMST(Graph<T> graph)
	{
		List<SpanningTreeEdge<T>> mst = new ArrayList<SpanningTreeEdge<T>>();

		List<Vertex<T>> list = new ArrayList<>(graph.getVertices().size());
		for (Vertex<T> vertex : graph.getVertices())
		{
			list.add(vertex);
		}

		if (list.size() == 0)
		{
			return mst;
		}

		Vertex<T> start = list.get(0);
		list.remove(0);
		Map<Vertex<T>, Integer> distances = new HashMap<>(list.size());
		Map<Vertex<T>, Boolean> inTree = new HashMap<>(list.size());
		Map<Vertex<T>, Vertex<T>> parent = new HashMap<>(list.size());
		inTree.put(start, true);
		for (Vertex<T> vertex : list)
		{
			distances.put(vertex, Integer.MAX_VALUE);
			inTree.put(vertex, false);
		}

		Vertex<T> vertex = start;
		while (list.isEmpty() == false)
		{
			for (AdjecencyEdge<T> edge : vertex.getAdjList())
			{
				Vertex<T> target = edge.getTarget();
				if (inTree.get(target) == false)
				{
					int edgeWeight = edge.getWeight();
					int knownDistance = distances.get(target);

					if (edgeWeight < knownDistance)
					{
						distances.put(target, edgeWeight);
						parent.put(target, vertex);
					}
				}
			}

			Vertex<T> nextVertex = null;
			int minEdgeDistance = Integer.MAX_VALUE;
			for (Entry<Vertex<T>, Integer> entry : distances.entrySet())
			{
				if ((inTree.get(entry.getKey()) == false)
						&& (entry.getValue() < minEdgeDistance))
				{
					minEdgeDistance = entry.getValue();
					nextVertex = entry.getKey();
				}
			}

			SpanningTreeEdge<T> spanningTreeEdge = new SpanningTreeEdge<>(
					nextVertex, parent.get(nextVertex), minEdgeDistance);
			mst.add(spanningTreeEdge);
			System.out.println("Adding " + spanningTreeEdge + " to tree");

			list.remove(nextVertex);
			inTree.put(nextVertex, true);
			vertex = nextVertex;
		}

		return mst;
	}

	public static void main(String[] args)
	{
		PrimsMST<String> prims = new PrimsMST<>();
		Graph<String> graph = new Graph<>(6);

		List<Vertex<String>> vertices = new ArrayList<>();
		Vertex<String> va = new Vertex<String>("a");
		Vertex<String> vb = new Vertex<String>("b");
		Vertex<String> vc = new Vertex<String>("c");
		Vertex<String> vd = new Vertex<String>("d");
		Vertex<String> ve = new Vertex<String>("e");
		Vertex<String> vf = new Vertex<String>("f");
		vertices.add(va);
		vertices.add(vb);
		vertices.add(vc);
		vertices.add(vd);
		vertices.add(ve);
		vertices.add(vf);

		Set<AdjecencyEdge<String>> set = new HashSet<>();
		AdjecencyEdge<String> edge = new AdjecencyEdge<>(vb, 12);
		set.add(edge);
		edge = new AdjecencyEdge<>(vf, 7);
		set.add(edge);
		va.setAdjList(set);

		set = new HashSet<>();
		edge = new AdjecencyEdge<>(va, 12);
		set.add(edge);
		edge = new AdjecencyEdge<>(vf, 2);
		set.add(edge);
		edge = new AdjecencyEdge<>(vc, 5);
		set.add(edge);
		vb.setAdjList(set);

		set = new HashSet<>();
		edge = new AdjecencyEdge<>(ve, 7);
		set.add(edge);
		edge = new AdjecencyEdge<>(vd, 4);
		set.add(edge);
		edge = new AdjecencyEdge<>(vb, 5);
		set.add(edge);
		vc.setAdjList(set);

		set = new HashSet<>();
		edge = new AdjecencyEdge<>(ve, 8);
		set.add(edge);
		edge = new AdjecencyEdge<>(vc, 4);
		set.add(edge);
		vd.setAdjList(set);

		set = new HashSet<>();
		edge = new AdjecencyEdge<>(vd, 8);
		set.add(edge);
		edge = new AdjecencyEdge<>(vc, 7);
		set.add(edge);
		edge = new AdjecencyEdge<>(vf, 10);
		set.add(edge);
		ve.setAdjList(set);

		set = new HashSet<>();
		edge = new AdjecencyEdge<>(va, 7);
		set.add(edge);
		edge = new AdjecencyEdge<>(vb, 2);
		set.add(edge);
		edge = new AdjecencyEdge<>(ve, 10);
		set.add(edge);
		vf.setAdjList(set);

		graph.setVertices(vertices);

		System.out.println(graph);
		System.out.println(prims.getMST(graph));
	}

}
