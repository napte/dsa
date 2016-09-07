package com.naptex.study.dsa.datastructures;

public class BST<T extends Comparable<T>> extends BinaryTree<T>
{
	public Node<T> search(T item)
	{
		return searchAtNode(getRoot(), item);
	}

	public Node<T> searchAtNode(Node<T> node, T item)
	{
		if (node == null)
		{
			return null;
		}

		int comp = node.getData().compareTo(item);
		if (comp == 0)
		{
			return node;
		}
		else if (comp > 0)
		{
			return searchAtNode(node.getLeft(), item);
		}
		else
		{
			return searchAtNode(node.getRight(), item);
		}
	}

	public void insert(T item)
	{
		if (getRoot() == null)
		{
			setRoot(new Node<T>(item));
			return;
		}

		insertAtNode(getRoot(), item);
	}

	public void insertAtNode(Node<T> node, T item)
	{
		if (node.getData().compareTo(item) > 0)
		{
			Node<T> left = node.getLeft();
			if (left == null)
			{
				left = new Node<T>(item);
				node.setLeft(left);
			}
			else
			{
				insertAtNode(left, item);
			}
		}
		else
		{
			Node<T> right = node.getRight();
			if (right == null)
			{
				right = new Node<T>(item);
				node.setRight(right);
			}
			else
			{
				insertAtNode(right, item);
			}
		}
	}
}
