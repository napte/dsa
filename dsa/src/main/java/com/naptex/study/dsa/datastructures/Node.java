package com.naptex.study.dsa.datastructures;

public class Node<T>
{
	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node(T data)
	{
		this.data = data;
	}

	public T getData()
	{
		return data;
	}

	public Node<T> getLeft()
	{
		return left;
	}

	public void setLeft(Node<T> left)
	{
		this.left = left;
	}

	public Node<T> getRight()
	{
		return right;
	}

	public void setRight(Node<T> right)
	{
		this.right = right;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<?> other = (Node<?>) obj;
		if (data == null)
		{
			if (other.data != null)
				return false;
		}
		else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Node [data=" + data + "]";
	}
}