package edu.neumont.csc252;

public class HuffmanCompressor {

	public byte[] compress(HuffmanTree tree, byte[] b){

		byte[] compressed = new byte[b.length];

		for (int i = 0; i < b.length; i++){
			byte newByte = this.findNewByte(tree.getRoot(), b[i], (byte)1);
			System.out.println(newByte);
			compressed[0] = newByte;
		}

		return compressed;
	}

	private byte findNewByte(FrequencyNode root, byte b, byte newByte) {

		if (root.getValue().length == 1){
			return newByte;
		}
		
		byte[] bytes = root.getLeft().getValue();
		for (byte by: bytes){
			if (by == b){
				return (byte) (findNewByte(root.getLeft(), b, (byte)(newByte * 2 + 0)));
			}
		}
		
		bytes = root.getRight().getValue();
		for (byte by: bytes){
			if (by == b){
				return (byte) (findNewByte(root.getRight(), b, (byte)(newByte * 2 + 1)));
			}
		}
		
		return 0;
	}

	public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] b){

		return null;
	}

}
