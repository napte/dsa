package com.naptex.study.dsa.datastructures;

public class StackLinkedList<T> implements Stack<T>
{
	private LinkedList<T> list = new LinkedList<>();
	private int size;

	@Override
	public void push(T e)
	{
		size++;
		list.addAtStart(e);
	}

	@Override
	public T pop()
	{
		size--;
		return list.removeAtStart();
	}

	@Override
	public T top()
	{
		return list.getStart().getData();
	}

	@Override
	public int size()
	{
		return size;
	}

	public static void main(String[] args)
	{
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println(stack.pop());
		System.out.println(stack.pop());

		stack.push(123);
		stack.push(234);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
