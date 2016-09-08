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
				left.setParent(node);
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
				right.setParent(node);
			}
			else
			{
				insertAtNode(right, item);
			}
		}
	}

	/**
	 * Replaces the specified old node with the specified new node
	 * 
	 * @param oldNode
	 *            node to be replaced
	 * @param newNode
	 *            node to replace the old node with
	 */
	public void transplant(Node<T> oldNode, Node<T> newNode)
	{
		Node<T> parentNode = oldNode.getParent();
		if (parentNode == null)
		{
			// root node
			setRoot(newNode);
		}
		else
		{
			if (parentNode.getLeft() == oldNode)
			{
				parentNode.setLeft(newNode);
			}
			else
			{
				parentNode.setRight(newNode);
			}
		}
		if (newNode != null)
		{
			newNode.setParent(parentNode);
		}
	}

	public void deleteNode(Node<T> node)
	{
		if (node.getLeft() == null)
		{
			transplant(node, node.getRight());
		}
		else if (node.getRight() == null)
		{
			transplant(node, node.getLeft());
		}
		else
		{
			Node<T> successor = getMinNode(node.getRight());
			if (successor.getParent() != node)
			{
				Node<T> right = successor.getRight();
				transplant(successor, right);
				successor.setRight(node.getRight());
				successor.getRight().setParent(successor);
			}

			transplant(node, successor);
			Node<T> left = node.getLeft();
			successor.setLeft(left);
			left.setParent(successor);
		}
	}

	public T getMin()
	{
		if (getRoot() == null)
		{
			throw new IllegalArgumentException("Tree is empty");
		}

		return getMinNode(getRoot()).getData();
	}

	public Node<T> getMinNode(Node<T> node)
	{
		while (node.getLeft() != null)
		{
			node = node.getLeft();
		}

		return node;
	}

	public T getMax()
	{
		if (getRoot() == null)
		{
			throw new IllegalArgumentException("Tree is empty");
		}

		return getMaxNode(getRoot()).getData();
	}

	public Node<T> getMaxNode(Node<T> node)
	{
		while (node.getRight() != null)
		{
			node = node.getRight();
		}

		return node;
	}

	public T getFloor(Node<T> node)
	{
		if (node.getLeft() == null)
		{
			return null;
		}

		return getMaxNode(node.getLeft()).getData();
	}

	public T getCeil(Node<T> node)
	{
		if (node.getRight() == null)
		{
			return null;
		}

		return getMinNode(node.getRight()).getData();
	}
}
