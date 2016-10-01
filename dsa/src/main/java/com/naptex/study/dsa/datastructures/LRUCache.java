package com.naptex.study.dsa.datastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V>
{
	private static class ListNode<V>
	{
		private V data;
		private ListNode<V> next;
		private ListNode<V> prev;

		public ListNode(V data)
		{
			super();
			this.data = data;
		}

		public ListNode<V> getNext()
		{
			return next;
		}

		public void setNext(ListNode<V> next)
		{
			this.next = next;
		}

		public ListNode<V> getPrev()
		{
			return prev;
		}

		public void setPrev(ListNode<V> prev)
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
	}

	private Map<K, ListNode<V>> map;
	private ListNode<V> head;
	private K tailKey;
	private ListNode<V> tailValue;
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
			ListNode<V> node = map.get(key);
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
			ListNode<V> node = map.get(key);
			node.setData(value);
			bringAtHead(node);
		}
		else
		{
			size++;
			ListNode<V> node = new ListNode<>(value);
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
		ListNode<V> node = head;
		System.out.print("[");
		while (node != null)
		{
			V data = node.getData();
			System.out.print(data + "  ");
			node = node.getNext();
		}
		System.out.println("]");
	}

	private void bringAtHead(ListNode<V> node)
	{
		if (node == head)
		{
			return;
		}

		ListNode<V> prev = node.getPrev();
		ListNode<V> next = node.getNext();
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
	}

	private void removeTail()
	{
		ListNode<V> prev = tailValue.getPrev();
		if (prev == null)
		{
			// list is now empty
			head = null;
			tailValue = null;
			return;
		}
		else
		{
			prev.setNext(null);
			tailValue = prev;
		}
		map.remove(tailKey);
	}

	private void insertAtHead(K key, ListNode<V> node)
	{
		if (head == null)
		{
			node.setNext(null);
			node.setPrev(null);
			head = node;
			tailKey = key;
			tailValue = node;
		}
		else
		{
			node.setPrev(null);
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}

	public static void main(String[] args)
	{
		LRUCache<Integer, String> cache = new LRUCache<>(4);
		cache.set(1, "AA");
		cache.set(2, "BB");
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.set(3, "CC");
		System.out.println("After setting value for 3 " + cache.get(3));
		cache.set(4, "DD");
		cache.printLRUOrder();
		cache.get(1);
		cache.printLRUOrder();
		cache.set(5, "EE");
		cache.set(1, "aaa");
		System.out.println("After updating value of 1 " + cache.get(1));
	}
}
