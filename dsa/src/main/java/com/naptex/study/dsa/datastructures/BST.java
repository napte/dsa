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

	public T getMin()
	{
		if (getRoot() == null)
		{
			throw new IllegalArgumentException("Tree is empty");
		}

		return getMinNode(getRoot());
	}

	public T getMinNode(Node<T> node)
	{
		while (node.getLeft() != null)
		{
			node = node.getLeft();
		}

		return node.getData();
	}

	public T getMax()
	{
		if (getRoot() == null)
		{
			throw new IllegalArgumentException("Tree is empty");
		}

		return getMaxNode(getRoot());
	}

	public T getMaxNode(Node<T> node)
	{
		while (node.getRight() != null)
		{
			node = node.getRight();
		}

		return node.getData();
	}

	public T getFloor(Node<T> node)
	{
		if (node.getLeft() == null)
		{
			return null;
		}

		return getMaxNode(node.getLeft());
	}

	public T getCeil(Node<T> node)
	{
		if (node.getRight() == null)
		{
			return null;
		}

		return getMinNode(node.getRight());
	}
}
