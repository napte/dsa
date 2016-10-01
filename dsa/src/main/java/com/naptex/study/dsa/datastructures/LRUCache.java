package com.naptex.study.dsa.datastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V>
{
	private static class ListNode<K, V>
	{
		private final K key;
		private V data;
		private ListNode<K, V> next;
		private ListNode<K, V> prev;

		public ListNode(K key, V data)
		{
			super();
			this.key = key;
			this.data = data;
		}

		public ListNode<K, V> getNext()
		{
			return next;
		}

		public void setNext(ListNode<K, V> next)
		{
			this.next = next;
		}

		public ListNode<K, V> getPrev()
		{
			return prev;
		}

		public void setPrev(ListNode<K, V> prev)
		{
			this.prev = prev;
		}

		public V getData()
		{
			return data;
		}

		public void setData(V data)
		{
			this.data = data;
		}

		public K getKey()
		{
			return key;
		}
	}

	private Map<K, ListNode<K, V>> map;
	private ListNode<K, V> head;
	private ListNode<K, V> tail;
	int size = 0;
	private final int capacity;

	public LRUCache(int capacity)
	{
		map = new HashMap<>(capacity);
		this.capacity = capacity;
	}

	public V get(K key)
	{
		if (map.containsKey(key))
		{
			ListNode<K, V> node = map.get(key);
			bringAtHead(node);
			V result = node.getData();
			return result;
		}
		else
		{
			return null;
		}
	}

	public void set(K key, V value)
	{
		if (map.containsKey(key))
		{
			// just bring the value to front
			ListNode<K, V> node = map.get(key);
			node.setData(value);
			bringAtHead(node);
		}
		else
		{
			size++;
			ListNode<K, V> node = new ListNode<>(key, value);
			map.put(key, node);
			if (size > capacity)
			{
				removeTail();
			}
			insertAtHead(key, node);
		}
	}

	public void printLRUOrder()
	{
		ListNode<K, V> node = head;
		System.out.print("[");
		while (node != null)
		{
			V data = node.getData();
			System.out.print(data + "  ");
			node = node.getNext();
		}
		System.out.println("]");
	}

	private void bringAtHead(ListNode<K, V> node)
	{
		if (node == head)
		{
			return;
		}

		ListNode<K, V> prev = node.getPrev();
		ListNode<K, V> next = node.getNext();
		if (prev != null)
		{
			prev.setNext(next);
		}
		if (next != null)
		{
			next.setPrev(prev);
		}

		node.setNext(head);
		head.setPrev(node);
		node.setPrev(null);
		head = node;

		if (tail == node)
		{
			tail = prev;
		}
	}

	private void removeTail()
	{
		map.remove(tail.getKey());
		size--;

		ListNode<K, V> prev = tail.getPrev();
		if (prev == null)
		{
			// list is now empty
			head = null;
			tail = null;
			return;
		}
		else
		{
			prev.setNext(null);
			tail = prev;
		}
	}

	private void insertAtHead(K key, ListNode<K, V> node)
	{
		if (head == null)
		{
			node.setNext(null);
			node.setPrev(null);
			head = node;
			tail = node;
		}
		else
		{
			node.setPrev(null);
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}
}
