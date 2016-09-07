package com.naptex.study.dsa.datastructures;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>>
{
	private Node<T> root;

	public Node<T> getRoot()
	{
		return root;
	}

	public void setRoot(Node<T> root)
	{
		this.root = root;
	}

	public void getLevelwisePrint(Writer out) throws IOException
	{
		if (getRoot() == null)
		{
			return;
		}

		Queue<Node<T>> queue = new ArrayDeque<>();
		Node<T> LEVEL_SEPARATOR = new Node<T>(null);

		queue.add(getRoot());
		queue.add(LEVEL_SEPARATOR);

		while (queue.isEmpty() == false)
		{
			Node<T> node = queue.poll();
			if (node == LEVEL_SEPARATOR)
			{
				if (queue.isEmpty() == false) // no new line is added at the end
				{
					out.write("\n");
					queue.add(LEVEL_SEPARATOR);
				}
			}
			else
			{
				out.write(String.valueOf(node.getData()));
				if (queue.peek() != LEVEL_SEPARATOR)
				{
					out.write("\t");
				}

				if (node.getLeft() != null)
				{
					queue.add(node.getLeft());
				}
				if (node.getRight() != null)
				{
					queue.add(node.getRight());
				}
			}
		}
	}

}