package com.naptex.study.dsa.datastructures;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest
{
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
