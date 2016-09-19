package com.naptex.study.dsa.datastructures;

public class LinkedList<T>
{
	static class Node<T>
	{
		private T data;
		private Node<T> next;

		public Node(T data)
		{
			this.data = data;
		}

		public T getData()
		{
			return data;
		}

		public Node<T> getNext()
		{
			return next;
		}

		public void setNext(Node<T> next)
		{
			this.next = next;
		}

		@Override
		public String toString()
		{
			return "Node [" + data + "]";
		}
	}

	private Node<T> start;

	public Node<T> getStart()
	{
		return start;
	}

	public void addAtStart(T e)
	{
		Node<T> node = new Node<T>(e);
		node.setNext(start);
		start = node;
	}

	public T removeAtStart()
	{
		Node<T> nextNode = start.getNext();
		T removed = start.getData();
		start = nextNode;
		return removed;
	}

	public void reverse()
	{
		Node<T> node = start;
		Node<T> reversedNext = null;

		while (node != null)
		{
			Node<T> nextNode = node.getNext();
			node.setNext(reversedNext);
			reversedNext = node;
			node = nextNode;
		}

		start = reversedNext;
	}

	public void reverseRecursively()
	{
		Node<T> startNode = start;
		reverseRecursively0(start);
		startNode.setNext(null);
	}

	private void reverseRecursively0(Node<T> node)
	{
		if (node.getNext() == null)
		{
			start = node;
			return;
		}
		else
		{
			Node<T> nextNode = node.getNext();
			reverseRecursively0(nextNode);
			nextNode.setNext(node);
		}
	}

	public void print()
	{
		Node<T> node = start;
		while (node.getNext() != null)
		{
			System.out.print(node.getData() + " --> ");
			node = node.getNext();
		}
		System.out.println(node.getData());
	}

	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.addAtStart(1);
		list.addAtStart(2);
		list.addAtStart(3);
		list.addAtStart(4);
		list.addAtStart(5);
		list.print();

		list.reverse();
		list.print();

		list.reverse();
		list.print();

		list.reverseRecursively();
		list.print();

		list.reverseRecursively();
		list.print();
	}
}
