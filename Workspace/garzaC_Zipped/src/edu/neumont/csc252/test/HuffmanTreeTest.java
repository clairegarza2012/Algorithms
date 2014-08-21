package edu.neumont.csc252.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Test;

import edu.neumont.csc252.HuffmanCompressor;
import edu.neumont.csc252.HuffmanTree;

public class HuffmanTreeTest {

	@Test
	public void test(){
		
		String string = "Hello World!";
		byte[] originalBytes = new byte[]{ -45, 12, 34, 45, -67, 12, -23 };
		
		HuffmanTree tree = new HuffmanTree(originalBytes);
		
		HuffmanCompressor hm = new HuffmanCompressor();
		byte[] compressedBytes = hm.compress(tree, originalBytes);
		byte[] decompressedBytes = hm.decompress(tree, originalBytes.length, compressedBytes);

		for (int i = 0; i < originalBytes.length; i++){

			System.out.println(i + ": " + (char)originalBytes[i] + " " + (char)decompressedBytes[i]);
		}
		
		System.out.println(Arrays.toString(decompressedBytes));
		
	}
	
}
