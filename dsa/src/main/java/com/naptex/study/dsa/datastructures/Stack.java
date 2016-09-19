package com.naptex.study.dsa.datastructures;

public interface Stack<T>
{
	public void push(T e);

	public T pop();

	public T top();

	int size();
}
