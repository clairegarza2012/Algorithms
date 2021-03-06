package edu.neumont.csc252;

import edu.neumont.io.Bits;

public class HuffmanCompressor {

	public byte[] compress(HuffmanTree tree, byte[] b){

		Bits bits = new Bits();

		// turn all bytes into bits
		for (int i = 0; i < b.length; i++){
			Bits temp = new Bits();
			tree.fromByte(b[i], temp);
			bits.addAll(temp);
		}

		// This adds padding to the end of the last byte
		while (bits.size() % 8 != 0){
			bits.add(false);
		}
		
		// Makes sure the compressed byte[] length is only as long as it can be (bits size / 8)
		byte[] compressed = new byte[bits.size() / 8];

		// keeps track of the 0's and 1's in the current byte
		String bitsString = "";
		// makes sure the byte is 8 bits long
		int count = 1;
		// keeps track of the next index for the compressed byte[]
		int compressedIndex = 0;

		// stores bits into byte[]
		while (bits.peek() != null){

			if (bits.poll()){
				bitsString += "" + 1 + "";
			}else{
				bitsString += "" + 0 + "";
			}
			if (count == 8){
				int i = Integer.parseInt(bitsString, 2);
				Byte byte1 = new Byte((byte) i);
				compressed[compressedIndex++] = byte1;
				count = 0;
				bitsString = "";
			}
			count++;
		}

		return compressed;
	}

	public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] b){

		byte[] decompressed = new byte[uncompressedLength];

		Bits bits = new Bits();
		// get all bytes and turn into bits
		for (byte byte1 : b){
			// turns the byte into a binary string of length 8
			String bString = Integer.toBinaryString(byte1 & 255 | 256).substring(1);

			for (Character c: bString.toCharArray()){
				if (c == 49){
					bits.add(true);
				}else{
					bits.add(false);
				}
			}
		}
		
		// for all bits figure out what the original bytes are
		for (int i = 0; i < decompressed.length; i++){
			
			byte byte1 = tree.toByte(bits);
			decompressed[i] = byte1;
		}

		return decompressed;
	}

}
