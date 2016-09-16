package com.naptex.study.dsa.datastructures;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NaiveDisjointSetTest
{
	private static final String SANDUKLYA = "sanduklya";
	private static final String DAYA = "daya";
	private static final String NIKHIL = "nikhil";
	private static final String TAMYA = "tamya";

	private static NaiveDisjointSet<String> disjointSet = new NaiveDisjointSet<>();

	@BeforeClass
	public static void init()
	{
		disjointSet.makeSet(NIKHIL);
		disjointSet.makeSet(DAYA);
		disjointSet.makeSet(SANDUKLYA);
		disjointSet.makeSet(TAMYA);
	}

	@Test
	public void testmakeSet()
	{
		int sizeBefore = disjointSet.size();
		disjointSet.makeSet("A-NEW-ONE");
		int sizeAfter = disjointSet.size();
		Assert.assertEquals(sizeBefore + 1, sizeAfter);
	}

	@Test
	public void testFindset()
	{
		Assert.assertEquals(TAMYA, disjointSet.findSet(TAMYA));
	}

	@Test
	public void testUnion()
	{
		int sizeBefore = disjointSet.size();
		disjointSet.union(NIKHIL, TAMYA);
		disjointSet.union(DAYA, SANDUKLYA);
		int sizeAfter = disjointSet.size();
		Assert.assertEquals(2, (sizeBefore - sizeAfter));
		Assert.assertEquals(NIKHIL, disjointSet.findSet(TAMYA));
		Assert.assertEquals(NIKHIL, disjointSet.findSet(NIKHIL));
		Assert.assertEquals(DAYA, disjointSet.findSet(DAYA));
		Assert.assertEquals(DAYA, disjointSet.findSet(SANDUKLYA));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnionNonExisting()
	{
		disjointSet.union(NIKHIL, "__NON__EXISTING__!@#1432rekafdkjsa");
	}
}
