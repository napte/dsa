package com.naptex.study.dsa.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class BSTTest
{
	private final BST<Integer> bst = new BST<>();

	@Test
	public void testInsertAtNodeLeft()
	{
		Node<Integer> node = new Node<Integer>(20);
		Node<Integer> expectedLeft = new Node<>(10);

		bst.insertAtNode(node, 10);
		Assert.assertNull(node.getRight());
		Assert.assertNotNull(node.getLeft());
		Node<Integer> left = node.getLeft();
		Assert.assertEquals(expectedLeft, left);
	}

	@Test
	public void testInsertAtNodeRight()
	{
		Node<Integer> node = new Node<Integer>(20);
		Node<Integer> expectedRight = new Node<>(30);

		bst.insertAtNode(node, 30);
		Assert.assertNull(node.getLeft());
		Assert.assertNotNull(node.getRight());
		Node<Integer> right = node.getRight();
		Assert.assertEquals(expectedRight, right);
	}

	@Test
	public void testInsertLeftLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer smallest = new Integer(10);
		Node<Integer> expectedLeftOfLeft = new Node<>(smallest);

		bst.insertAtNode(root, smallest);

		Assert.assertNull(left.getRight());
		Assert.assertNotNull(left.getLeft());
		Node<Integer> leftOfLeft = left.getLeft();
		Assert.assertEquals(expectedLeftOfLeft, leftOfLeft);
	}

	@Test
	public void testInsertLeftRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer floor = new Integer(30);
		Node<Integer> expectedRightOfLeft = new Node<>(floor);

		bst.insertAtNode(root, floor);

		Assert.assertNull(left.getLeft());
		Assert.assertNotNull(left.getRight());
		Node<Integer> rightOfLeft = left.getRight();
		Assert.assertEquals(expectedRightOfLeft, rightOfLeft);
	}

	@Test
	public void testInsertRightLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer ceil = new Integer(50);
		Node<Integer> expectedLeftOfRight = new Node<>(ceil);

		bst.insertAtNode(root, ceil);

		Assert.assertNull(right.getRight());
		Assert.assertNotNull(right.getLeft());
		Node<Integer> leftOfRight = right.getLeft();
		Assert.assertEquals(expectedLeftOfRight, leftOfRight);
	}

	@Test
	public void testInsertRightRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer largest = new Integer(70);
		Node<Integer> expectedRightOfRight = new Node<>(largest);

		bst.insertAtNode(root, largest);

		Assert.assertNull(right.getLeft());
		Assert.assertNotNull(right.getRight());
		Node<Integer> rightOfRight = right.getRight();
		Assert.assertEquals(expectedRightOfRight, rightOfRight);
	}

	@Test
	public void testSearchAtNodeBase()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		bst.setRoot(root);

		Node<Integer> expectedRoot = bst.searchAtNode(root, root.getData());
		Assert.assertEquals(expectedRoot, root);
		Node<Integer> expectedLeft = bst.searchAtNode(left, left.getData());
		Assert.assertEquals(expectedLeft, left);
		Node<Integer> expectedRight = bst.searchAtNode(right, right.getData());
		Assert.assertEquals(expectedRight, right);
	}

	@Test
	public void testSearchAtNodeLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		bst.setRoot(root);

		Node<Integer> expectedLeft = bst.searchAtNode(root, left.getData());
		Assert.assertEquals(expectedLeft, left);
	}

	@Test
	public void testSearchAtNodeRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		bst.setRoot(root);

		Node<Integer> expectedRight = bst.searchAtNode(root, right.getData());
		Assert.assertEquals(expectedRight, right);
	}

	@Test
	public void testSearchAtNodeMissingElement()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		bst.setRoot(root);

		Node<Integer> expectedNullLeftLeft = bst.searchAtNode(root,
				new Integer(9));
		Assert.assertNull(expectedNullLeftLeft);
		Node<Integer> expectedNullLeftRight = bst.searchAtNode(root,
				new Integer(30));
		Assert.assertNull(expectedNullLeftRight);
		Node<Integer> expectedNullRightLeft = bst.searchAtNode(root,
				new Integer(50));
		Assert.assertNull(expectedNullRightLeft);
		Node<Integer> expectedNullRightRight = bst.searchAtNode(root,
				new Integer(9999));
		Assert.assertNull(expectedNullRightRight);
	}
}