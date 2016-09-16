package com.naptex.study.dsa.graphs;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.naptex.study.dsa.graphs.algo.KruskalMST;
import com.naptex.study.dsa.graphs.algo.PrimsMST;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of vertices : ");
		int vCount = scanner.nextInt();

		Graph<String> graph = new Graph<>(vCount);
		for (int i = 0; i < vCount; i++)
		{
			System.out.println("Enter data for vertex " + i + " : ");
			String vertexData = scanner.next();
			graph.addVertex(vertexData);
		}

		System.out.println("Enter wights of edges, -1 for a non-existing edge");
		Iterator<Vertex<String>> iter = graph.getVertices().iterator();
		while (iter.hasNext())
		{
			Vertex<String> source = iter.next();
			System.out.println("Emter out-degree for " + source.getData());
			int outDegree = scanner.nextInt();
			for (int i = 0; i < outDegree; i++)
			{
				System.out.println("Enter target vertex : ");
				String targetData = scanner.next();
				Vertex<String> target = search(graph.getVertices(), targetData);
				System.out.println("Enter weight of edge " + source.getData()
						+ " -- " + target.getData() + " : ");
				int weight = scanner.nextInt();
				if (weight != -1)
				{
					// add edge i-j
					graph.addEdge(source, target, weight);
				}
			}
		}
		scanner.close();
		System.out.println(graph);

		PrimsMST<String> primsMST = new PrimsMST<>();
		System.out.println(primsMST.getMST(graph));

		System.out.println("\n==============================\n\n");
		KruskalMST<String> kruskalMST = new KruskalMST<>();
		System.out.println(kruskalMST.getMST(graph));
	}

	private static <T> Vertex<T> search(List<Vertex<T>> vertices,
			String targetData)
	{
		Iterator<Vertex<T>> iter = vertices.iterator();
		while (iter.hasNext())
		{
			Vertex<T> vertex = iter.next();
			if (vertex.getData().equals(targetData))
			{
				return vertex;
			}
		}
		return null;
	}
}
