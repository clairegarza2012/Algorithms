package edu.neumont.csc252;

import edu.neumont.io.Bits;

public class HuffmanCompressor {

	public byte[] compress(HuffmanTree tree, byte[] b){

		Bits bits = new Bits();

		for (int i = 0; i < b.length; i++){
			Bits temp = new Bits();
			tree.fromByte(b[i], temp);
			bits.addAll(temp);
		}

		while (bits.size() % 8 != 0){
			bits.add(false);
		}
		
		byte[] compressed = new byte[bits.size() / 8];

		String bitsString = "";
		int count = 1;
		int compressedIndex = 0;

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
		for (byte byte1 : b){
			String bString = Integer.toBinaryString((byte1+256)%256);

			while (bString.length() < 8){
				bString = 0 + "" + bString;
			}

			for (Character c: bString.toCharArray()){
				if (c == 49){
					bits.add(true);
				}else{
					bits.add(false);
				}
			}
		}
		
		for (int i = 0; i < decompressed.length; i++){
			
			byte byte1 = tree.toByte(bits);
			decompressed[i] = byte1;
		}

		return decompressed;
	}

}
