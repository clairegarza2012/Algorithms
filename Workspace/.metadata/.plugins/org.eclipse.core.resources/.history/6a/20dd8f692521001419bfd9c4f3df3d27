package edu.neumont.csc252.test;

import org.junit.Test;
import edu.neumont.csc252.FrequencyNode;
import edu.neumont.csc252.HuffmanCompressor;
import edu.neumont.csc252.HuffmanTree;

public class HuffmanTreeTest {

	@Test
	public void test() {

		String string = "Hello World!";

		HuffmanTree tree = new HuffmanTree(string.getBytes());

		FrequencyNode root = tree.getRoot();
		
		HuffmanCompressor compressor = new HuffmanCompressor();
		compressor.compress(tree, string.getBytes());
		
		//printLeafs(root);
	}
	
	private void printLeafs(FrequencyNode root){
		
		if (root.getValue().length <= 1){
			System.out.println(root.toString());
			return;
		}
		
		printLeafs(root.getLeft());
		printLeafs(root.getRight());
	}

}
