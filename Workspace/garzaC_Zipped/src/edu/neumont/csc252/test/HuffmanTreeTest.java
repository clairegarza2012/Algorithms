package edu.neumont.csc252.test;

import org.junit.Test;
import edu.neumont.csc252.FrequencyNode;
import edu.neumont.csc252.HuffmanCompressor;
import edu.neumont.csc252.HuffmanTree;
import edu.neumont.io.Bits;

public class HuffmanTreeTest {

	@Test
	public void test() {

		String string = "Hello Kitty! Hello Kitty!";

		HuffmanTree tree = new HuffmanTree(string.getBytes());

		HuffmanCompressor compressor = new HuffmanCompressor();
		byte[] bytes = compressor.compress(tree, string.getBytes());

		byte[] bytes2 = compressor.decompress(tree, string.length(), bytes);
		
		for (byte b : bytes2){
			System.out.print((char)((int)b));
		}
		
	}
}
