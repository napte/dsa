package com.naptex.study.dsa.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.naptex.study.dsa.datastructures.BinaryTree.Visitor;

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

	@Test
	public void testMinRoot()
	{
		Node<Integer> root = new Node<Integer>(40);
		Integer min = bst.getMinNode(root);
		Integer expectedMin = new Integer(40);

		Assert.assertEquals(expectedMin, min);
	}

	@Test
	public void testMinOneLevel()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		Integer min = bst.getMinNode(root);
		Integer expectedMin = new Integer(20);

		Assert.assertEquals(expectedMin, min);
	}

	@Test
	public void testMinTwoLevelsLeftLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		Node<Integer> leftLeft = new Node<Integer>(10);
		left.setLeft(leftLeft);
		Integer min = bst.getMinNode(root);
		Integer expectedMin = new Integer(10);

		Assert.assertEquals(expectedMin, min);
	}

	@Test
	public void testMinTwoLevelsLeftRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		Node<Integer> leftRight = new Node<Integer>(30);
		left.setRight(leftRight);
		Integer min = bst.getMinNode(root);
		Integer expectedMin = new Integer(20);

		Assert.assertEquals(expectedMin, min);
	}

	@Test
	public void testMaxRoot()
	{
		Node<Integer> root = new Node<Integer>(40);
		Integer max = bst.getMaxNode(root);
		Integer expectedMax = new Integer(40);

		Assert.assertEquals(expectedMax, max);
	}

	@Test
	public void testMaxOneLevel()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		Integer max = bst.getMaxNode(root);
		Integer expectedMax = new Integer(60);

		Assert.assertEquals(expectedMax, max);
	}

	@Test
	public void testMaxTwoLevelsRightRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		Node<Integer> rightRight = new Node<Integer>(80);
		right.setRight(rightRight);
		Integer max = bst.getMaxNode(root);
		Integer expectedMax = new Integer(80);

		Assert.assertEquals(expectedMax, max);
	}

	@Test
	public void testMaxTwoLevelsRightLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		Node<Integer> rightLeft = new Node<Integer>(50);
		left.setRight(rightLeft);
		Integer max = bst.getMaxNode(root);
		Integer expectedMax = new Integer(60);

		Assert.assertEquals(expectedMax, max);
	}

	@Test
	public void testMinRandom()
	{
		int size = 100;
		List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++)
		{
			list.add((int) (Math.random() * size));
		}

		BST<Integer> bstRandom = new BST<>();
		for (int i = 0; i < size; i++)
		{
			bstRandom.insert(list.get(i));
		}

		Collections.sort(list);
		Assert.assertEquals(list.get(0), bstRandom.getMin());
	}

	@Test
	public void testMaxRandom()
	{
		int size = 100;
		List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++)
		{
			list.add((int) (Math.random() * size));
		}

		BST<Integer> bstRandom = new BST<>();
		for (int i = 0; i < size; i++)
		{
			bstRandom.insert(list.get(i));
		}

		Collections.sort(list);
		Assert.assertEquals(list.get(list.size() - 1), bstRandom.getMax());
	}

	@Test
	public void testFloorNull()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer floor = bst.getFloor(left);
		Assert.assertNull(floor);
	}

	@Test
	public void testCeilNull()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer ceil = bst.getCeil(right);
		Assert.assertNull(ceil);
	}

	@Test
	public void testFloor()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer floor = bst.getFloor(root);
		Integer expectedFloor = 20;
		Assert.assertEquals(expectedFloor, floor);
	}

	@Test
	public void testCeil()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);

		Integer ceil = bst.getCeil(root);
		Integer expectedCeil = 60;
		Assert.assertEquals(expectedCeil, ceil);
	}

	@Test
	public void testBstInorderTraversal()
	{
		int size = 1000;
		List<Integer> randomList = new ArrayList<>(size);
		for (int i = 0; i < size; i++)
		{
			randomList.add((int) (Math.random() * size));
		}

		BST<Integer> bstRandom = new BST<>();
		for (int i = 0; i < size; i++)
		{
			bstRandom.insert(randomList.get(i));
		}

		Collections.sort(randomList);
		final List<Integer> list = new ArrayList<>();
		Visitor<Integer> visitor = new Visitor<Integer>()
		{

			@Override
			public void visit(Node<Integer> node)
			{
				list.add(node.getData());
			}
		};
		bstRandom.inorderTraversal(visitor);

		Assert.assertEquals(randomList, list);
	}
}
