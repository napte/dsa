package com.naptex.study.dsa.datastructures;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.naptex.study.dsa.datastructures.BinaryTree.Visitor;

public class BinaryTreeTest
{
	@Test
	public void testInorderTraversal()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.setRoot(root);

		final List<Integer> list = new ArrayList<>();
		Visitor<Integer> visitor = new Visitor<Integer>()
		{

			@Override
			public void visit(Node<Integer> node)
			{
				list.add(node.getData());
			}
		};
		tree.inorderTraversal(visitor);

		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(20);
		expectedList.add(40);
		expectedList.add(60);

		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void testInorderTraversalIterative()
	{
		Node<Integer> root = new Node<Integer>(40);
		Node<Integer> left = new Node<Integer>(20);
		Node<Integer> right = new Node<Integer>(60);
		root.setLeft(left);
		root.setRight(right);
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.setRoot(root);

		final List<Integer> list = new ArrayList<>();
		Visitor<Integer> visitor = new Visitor<Integer>()
		{

			@Override
			public void visit(Node<Integer> node)
			{
				list.add(node.getData());
			}
		};
		tree.inorderTraversalNonRecursive(visitor);

		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(20);
		expectedList.add(40);
		expectedList.add(60);

		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void testLevelwisePrintingEmptyTree() throws IOException
	{
		StringWriter out = new StringWriter();
		BinaryTree<String> tree = new BinaryTree<>();
		tree.getLevelwisePrint(out);
		String expected = "";
		Assert.assertEquals(expected, out.toString());
	}

	@Test
	public void testLevelwisePrintingRoot() throws IOException
	{
		Node<String> root = new Node<>("ROOT_NODE");
		StringWriter out = new StringWriter();
		BinaryTree<String> tree = new BinaryTree<>();
		tree.setRoot(root);
		tree.getLevelwisePrint(out);
		String expected = String.valueOf(root.getData());
		Assert.assertEquals(expected, out.toString());
	}

	@Test
	public void testLevelwisePrintingOneLevel() throws IOException
	{
		Node<String> root = new Node<>("ROOT_NODE");
		Node<String> left = new Node<>("LEFT_CHILD");
		Node<String> right = new Node<>("RIGHT_NODE");
		root.setLeft(left);
		root.setRight(right);
		BinaryTree<String> tree = new BinaryTree<>();
		tree.setRoot(root);

		StringWriter out = new StringWriter();
		tree.getLevelwisePrint(out);

		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(root.getData()));
		sb.append("\n");
		sb.append(String.valueOf(left.getData()));
		sb.append("\t");
		sb.append(String.valueOf(right.getData()));
		String expected = sb.toString();
		Assert.assertEquals(expected, out.toString());
	}

	@Test
	public void testLevelwisePrintingTwoLevels() throws IOException
	{
		Node<String> root = new Node<>("ROOT_NODE");
		Node<String> left = new Node<>("LEFT_CHILD");
		Node<String> right = new Node<>("RIGHT_NODE");
		Node<String> leftLeft = new Node<>("LEFT_LEFT");
		Node<String> rightRight = new Node<>("RIGHT_RIGHT");
		root.setLeft(left);
		root.setRight(right);
		left.setLeft(leftLeft);
		right.setRight(rightRight);
		BinaryTree<String> tree = new BinaryTree<>();
		tree.setRoot(root);

		StringWriter out = new StringWriter();
		tree.getLevelwisePrint(out);

		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(root.getData()));
		sb.append("\n");
		sb.append(String.valueOf(left.getData()));
		sb.append("\t");
		sb.append(String.valueOf(right.getData()));
		sb.append("\n");
		sb.append(String.valueOf(leftLeft.getData()));
		sb.append("\t");
		sb.append(String.valueOf(rightRight.getData()));
		String expected = sb.toString();
		Assert.assertEquals(expected, out.toString());
	}
}
