package com.naptex.study.dsa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.naptex.study.dsa.datastructures.BSTTest;
import com.naptex.study.dsa.datastructures.BinaryTreeTest;
import com.naptex.study.dsa.datastructures.PriorityQueueTest;
import com.naptex.study.dsa.search.SelectionTest;
import com.naptex.study.dsa.sort.HeapSortTest;
import com.naptex.study.dsa.sort.MergeSortTest;
import com.naptex.study.dsa.sort.QuickSortTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BinaryTreeTest.class, BSTTest.class,
		PriorityQueueTest.class, SelectionTest.class, HeapSortTest.class,
		MergeSortTest.class, QuickSortTest.class })
public class DsaJunitTestSuite
{
	// the class remains empty, used only as a holder for the above annotations
}
