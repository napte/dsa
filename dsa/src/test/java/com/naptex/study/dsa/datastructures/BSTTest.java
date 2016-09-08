package com.naptex.study.dsa.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.naptex.study.dsa.datastructures.BinaryTree.Visitor;

public class BSTTest extends BinaryTreeTest
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
		Assert.assertEquals(left.getParent(), node);
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
		Assert.assertEquals(right.getParent(), node);
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
		Assert.assertEquals(leftOfLeft.getParent(), left);
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
		Assert.assertEquals(rightOfLeft.getParent(), left);
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
		Assert.assertEquals(leftOfRight.getParent(), right);
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
		Assert.assertEquals(rightOfRight.getParent(), right);
	}

	@Test
	public void testTransplantRootLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.transplant(root, left);
		Node<Integer> expectedRoot = left;
		Assert.assertEquals(expectedRoot, tree.getRoot());
	}

	@Test
	public void testTransplantRootRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.transplant(root, right);
		Node<Integer> expectedRoot = right;
		Assert.assertEquals(expectedRoot, tree.getRoot());
	}

	@Test
	public void testTransplantLeftLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		Node<Integer> right = new Node<Integer>(60);
		right.setParent(root);
		root.setLeft(left);
		root.setRight(right);

		Node<Integer> leftLeft = new Node<Integer>(10);
		left.setLeft(leftLeft);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.transplant(left, leftLeft);
		Assert.assertEquals(leftLeft.getParent(), root);
		Assert.assertEquals(leftLeft, root.getLeft());
	}

	@Test
	public void testTransplantLeftRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		Node<Integer> right = new Node<Integer>(60);
		right.setParent(root);
		root.setLeft(left);
		root.setRight(right);

		Node<Integer> leftRight = new Node<Integer>(30);
		left.setRight(leftRight);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.transplant(left, leftRight);
		Assert.assertEquals(leftRight.getParent(), root);
		Assert.assertEquals(leftRight, root.getLeft());
	}

	@Test
	public void testTransplantRightLeft()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		Node<Integer> right = new Node<Integer>(60);
		right.setParent(root);
		root.setLeft(left);
		root.setRight(right);

		Node<Integer> rightLeft = new Node<Integer>(50);
		left.setLeft(rightLeft);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.transplant(right, rightLeft);
		Assert.assertEquals(rightLeft.getParent(), root);
		Assert.assertEquals(rightLeft, root.getRight());
	}

	@Test
	public void testTransplantRightRight()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		Node<Integer> right = new Node<Integer>(60);
		right.setParent(root);
		root.setLeft(left);
		root.setRight(right);

		Node<Integer> rightRight = new Node<Integer>(70);
		left.setRight(rightRight);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.transplant(right, rightRight);
		Assert.assertEquals(rightRight.getParent(), root);
		Assert.assertEquals(rightRight, root.getRight());
	}

	@Test
	public void testDeleteWithOnlyLeftChild()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		root.setLeft(left);
		Node<Integer> leftLeft = new Node<Integer>(10);
		leftLeft.setParent(left);
		left.setLeft(leftLeft);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.deleteNode(left);
		Assert.assertEquals(root, leftLeft.getParent());
		Assert.assertEquals(leftLeft, root.getLeft());
	}

	@Test
	public void testDeleteWithOnlyRightChild()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		root.setLeft(left);
		Node<Integer> leftRight = new Node<Integer>(30);
		leftRight.setParent(left);
		left.setRight(leftRight);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.deleteNode(left);
		Assert.assertEquals(root, leftRight.getParent());
		Assert.assertEquals(leftRight, root.getLeft());
	}

	@Test
	public void testDeleteRootWithSuccessorRightChild()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		root.setLeft(left);
		Node<Integer> right = new Node<Integer>(50);
		right.setParent(root);
		root.setLeft(left);
		root.setRight(right);
		Node<Integer> rightRight = new Node<Integer>(60);
		right.setRight(rightRight);
		rightRight.setParent(right);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.deleteNode(root);
		Assert.assertEquals(left, right.getLeft());
		Assert.assertEquals(left.getParent(), right);
		Assert.assertEquals(rightRight, right.getRight());
		Assert.assertEquals(right, rightRight.getParent());
		Assert.assertEquals(right, tree.getRoot());
	}

	@Test
	public void testDeleteRootWithSuccessorNotRightChild()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		root.setLeft(left);
		Node<Integer> right = new Node<Integer>(60);
		right.setParent(root);
		root.setLeft(left);
		root.setRight(right);

		Node<Integer> rightLeft = new Node<Integer>(50);
		right.setLeft(rightLeft);
		rightLeft.setParent(right);
		Node<Integer> rightLeftRight = new Node<Integer>(55);
		rightLeft.setRight(rightLeftRight);
		rightLeftRight.setParent(rightLeft);
		Node<Integer> rightRight = new Node<Integer>(70);
		right.setRight(rightRight);
		rightRight.setParent(right);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.deleteNode(root);

		Assert.assertEquals(left, rightLeft.getLeft());
		Assert.assertEquals(left.getParent(), rightLeft);
		Assert.assertEquals(right, rightLeft.getRight());
		Assert.assertEquals(right.getParent(), rightLeft);
		Assert.assertEquals(rightRight, right.getRight());
		Assert.assertEquals(right, rightRight.getParent());
		Assert.assertEquals(rightLeftRight, right.getLeft());
		Assert.assertEquals(right, rightLeftRight.getParent());
		Assert.assertEquals(rightLeft, tree.getRoot());
	}

	@Test
	public void testDeleteWithSuccessorRightChild()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		left.setParent(root);
		root.setLeft(left);
		Node<Integer> right = new Node<Integer>(60);
		right.setParent(root);
		root.setLeft(left);
		root.setRight(right);

		Node<Integer> rightLeft = new Node<Integer>(50);
		right.setLeft(rightLeft);
		rightLeft.setParent(right);
		Node<Integer> rightLeftRight = new Node<Integer>(55);
		rightLeft.setRight(rightLeftRight);
		rightLeftRight.setParent(rightLeft);
		Node<Integer> rightRight = new Node<Integer>(70);
		right.setRight(rightRight);
		rightRight.setParent(right);
		BST<Integer> tree = new BST<>();
		tree.setRoot(root);

		tree.deleteNode(right);

		Assert.assertEquals(root, rightRight.getParent());
		Assert.assertEquals(root.getRight(), rightRight);
		Assert.assertEquals(rightLeft, rightRight.getLeft());
		Assert.assertEquals(rightRight, rightLeft.getParent());
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

	@Test(expected = IllegalArgumentException.class)
	public void testMinEmptyTree()
	{
		BST<Integer> emptyTree = new BST<>();
		emptyTree.getMin();
	}

	@Test
	public void testMinRoot()
	{
		Node<Integer> root = new Node<Integer>(40);
		Integer min = bst.getMinNode(root).getData();
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
		Integer min = bst.getMinNode(root).getData();
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
		Integer min = bst.getMinNode(root).getData();
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
		Integer min = bst.getMinNode(root).getData();
		Integer expectedMin = new Integer(20);

		Assert.assertEquals(expectedMin, min);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaxEmptyTree()
	{
		BST<Integer> emptyTree = new BST<>();
		emptyTree.getMax();
	}

	@Test
	public void testMaxRoot()
	{
		Node<Integer> root = new Node<Integer>(40);
		Integer max = bst.getMaxNode(root).getData();
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
		Integer max = bst.getMaxNode(root).getData();
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
		Integer max = bst.getMaxNode(root).getData();
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
		Integer max = bst.getMaxNode(root).getData();
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

	@Test
	public void testBstInorderTraversalNonRecursive()
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
		bstRandom.inorderTraversalNonRecursive(visitor);

		Assert.assertEquals(randomList, list);
	}
}
