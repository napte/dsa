package com.naptex.study.dsa.graphs.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.naptex.study.dsa.datastructures.DisjointSet;
import com.naptex.study.dsa.datastructures.NaiveDisjointSet;
import com.naptex.study.dsa.graphs.AdjecencyEdge;
import com.naptex.study.dsa.graphs.Graph;
import com.naptex.study.dsa.graphs.Vertex;

public class KruskalMST<T>
{
	public List<SpanningTreeEdge<T>> getMST(Graph<T> graph)
	{
		List<SpanningTreeEdge<T>> mst = new ArrayList<SpanningTreeEdge<T>>();

		DisjointSet<Vertex<T>> disjointSet = getVerticesDisjointset(graph);

		List<SpanningTreeEdge<T>> edges = getGraphEdges(graph);
		Collections.sort(edges);

		for (SpanningTreeEdge<T> edge : edges)
		{
			Vertex<T> source = edge.getSource();
			Vertex<T> target = edge.getTarget();

			if (disjointSet.findSet(source)
					.equals(disjointSet.findSet(target)) == false)
			{
				mst.add(edge);
				System.out.println(edge);
				disjointSet.union(source, target);
			}
		}

		return mst;
	}

	private DisjointSet<Vertex<T>> getVerticesDisjointset(Graph<T> graph)
	{
		DisjointSet<Vertex<T>> disjointSet = new NaiveDisjointSet<>();
		for (Vertex<T> vertex : graph.getVertices())
		{
			disjointSet.makeSet(vertex);
		}
		return disjointSet;
	}

	public List<SpanningTreeEdge<T>> getGraphEdges(Graph<T> graph)
	{
		List<SpanningTreeEdge<T>> edges = new ArrayList<>();
		for (Vertex<T> vertex : graph.getVertices())
		{
			for (AdjecencyEdge<T> edge : vertex.getAdjList())
			{
				edges.add(new SpanningTreeEdge<>(vertex, edge.getTarget(),
						edge.getWeight()));
			}
		}
		return edges;
	}

	public static void main(String[] args)
	{
		KruskalMST<String> kruskals = new KruskalMST<>();
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
		System.out.println(kruskals.getMST(graph));
	}
}
