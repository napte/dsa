package com.naptex.study.dsa.datastructures;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>>
{
	public interface Visitor<T>
	{
		public void visit(Node<T> node);
	}

	private Node<T> root;

	public Node<T> getRoot()
	{
		return root;
	}

	public void setRoot(Node<T> root)
	{
		this.root = root;
	}

	public void inorderTraversal(Visitor<T> visitor)
	{
		inorderTraversal(getRoot(), visitor);
	}

	public void inorderTraversal(Node<T> node, Visitor<T> visitor)
	{
		if (node.getLeft() != null)
		{
			inorderTraversal(node.getLeft(), visitor);
		}

		visitor.visit(node);

		if (node.getRight() != null)
		{
			inorderTraversal(node.getRight(), visitor);
		}
	}

	public void inorderTraversalNonRecursive(Visitor<T> visitor)
	{
		Node<T> root = getRoot();
		if (root == null)
		{
			return;
		}

		Deque<Node<T>> stack = new ArrayDeque<>();

		Node<T> node = root;
		while ((stack.isEmpty() == false) || (node != null))
		{
			while (node != null)
			{
				stack.addFirst(node);
				node = node.getLeft();
			}

			if (stack.isEmpty() == false)
			{
				node = stack.removeFirst();
				visitor.visit(node);
				node = node.getRight();
			}
		}
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