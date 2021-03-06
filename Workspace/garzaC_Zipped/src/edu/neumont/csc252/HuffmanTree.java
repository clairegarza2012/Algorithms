package edu.neumont.csc252;

import java.util.PriorityQueue;
import edu.neumont.io.Bits;

public class HuffmanTree {

	private FrequencyNode root;
	//private PriorityQueue<FrequencyNode> frequencies = new PriorityQueue<FrequencyNode>();
	private HeapBasedPriorityQueue<FrequencyNode> frequencies = new HeapBasedPriorityQueue<FrequencyNode>();
	//private AvlBasedPriorityQueue<FrequencyNode> frequencies = new AvlBasedPriorityQueue<FrequencyNode>();

	public HuffmanTree(byte[] b) {

		this.setFrequency(b);
		this.makeTree();
	}
	
	public HuffmanTree(){
		
		this.setTeacherFrequency();
		this.makeTree();
	}
	
	private void setTeacherFrequency() {

		String frequencys = "423, 116, 145, 136, 130, 165, 179, 197, 148, 125, 954, 156, 143, 145, 164, 241, 107, 149, 176, 153, 121, 164, 144, 166, 100, 138, 157, 140, 119, 138, 178, 289, 360, 120, 961, 195, 139, 147, 129, 192, 119, 146, 138, 184, 137, 196, 163, 331, 115, 160, 127, 172, 176, 181, 149, 194, 138, 154, 163, 167, 196, 174, 250, 354, 142, 169, 170, 209, 205, 179, 147, 245, 108, 179, 148, 186, 131, 160, 112, 219, 118, 204, 164, 154, 154, 175, 189, 239, 126, 145, 185, 179, 149, 167, 152, 244, 189, 257, 234, 208, 179, 170, 171, 178, 184, 189, 203, 184, 204, 208, 187, 163, 335, 326, 206, 189, 210, 204, 230, 202, 415, 240, 275, 295, 375, 308, 401, 608, 2099, 495, 374, 160, 130, 331, 107, 181, 117, 133, 476, 129, 137, 106, 107, 237, 184, 143, 122, 143, 1596, 205, 121, 170, 123, 124, 150, 132, 143, 133, 178, 308, 96, 102, 114, 176, 159, 149, 123, 199, 1156, 119, 144, 237, 131, 155, 143, 225, 92, 125, 117, 138, 135, 154, 124, 137, 121, 143, 149, 141, 177, 159, 247, 384, 302, 120, 95, 140, 87, 1460, 155, 199, 111, 198, 147, 182, 91, 148, 119, 233, 445, 1288, 138, 133, 122, 170, 156, 257, 143, 149, 180, 174, 132, 151, 193, 347, 91, 119, 135, 182, 124, 152, 109, 175, 152, 159, 166, 224, 126, 169, 145, 220, 119, 148, 133, 158, 144, 185, 139, 168, 244, 145, 167, 167, 262, 214, 293, 402";
		String[] frequencies = frequencys.split(", ");
	
		int index = 0;
		for (int i = -128; i <= 127; i++){
			
			FrequencyNode node = new FrequencyNode(Integer.parseInt(frequencies[index++]), new byte[]{ (byte)i });
			this.frequencies.offer(node);
		}
	}

	private void makeTree() {

		while (frequencies.size() > 1){
			FrequencyNode left = frequencies.poll();
			FrequencyNode right = frequencies.poll();
			
			byte[] byteArray = new byte[left.getValue().length + right.getValue().length];
			for (int i = 0; i < left.getValue().length; i++){
				byteArray[i] = left.getValue()[i];
			}
			for (int i = left.getValue().length; i < byteArray.length; i++){
				byteArray[i] = right.getValue()[i - left.getValue().length];
			}

			root = new FrequencyNode(left.getFrequency()+right.getFrequency(), byteArray);
			root.setLeft(left);
			root.setRight(right);
			
			frequencies.offer(root);
		}
	}

	public byte toByte(Bits bits){
		return toByteHelper(root, bits);
	}

	private byte toByteHelper(FrequencyNode root, Bits bits) {

		if (root.getValue().length == 1){
			return root.getValue()[0];
		}

		if (bits.size() > 0){
			if(bits.poll()){
				return toByteHelper(root.getRight(), bits);
			}else{
				return toByteHelper(root.getLeft(), bits);
			}
		}
		
		return 0;
	}

	public void fromByte(byte b, Bits bits){
		fromByteHelper(root, b, bits);
	}

	private void fromByteHelper(FrequencyNode root, byte b, Bits bits){

		if (root.getValue().length == 1){
			return;
		}

		byte[] bytes = root.getLeft().getValue();
		for (byte by: bytes){
			if (by == b){
				bits.add(false);
				fromByteHelper(root.getLeft(), b, bits);
			}
		}

		bytes = root.getRight().getValue();
		for (byte by: bytes){
			if (by == b){
				bits.add(true);
				fromByteHelper(root.getRight(), b, bits);
			}
		}

	}

	private void setFrequency(byte[] b){

		byte[] b2 = b.clone();
		for (int i = 0; i < b2.length; i++){

			double count = 1;
			for (int j = i + 1; j < b2.length; j++) {

				if (b2[i] == b2[j]){
					count ++;
					b2[j] = 0;
				}
			}

			double frequency = count / b.length;
			FrequencyNode node = new FrequencyNode( frequency, new byte[]{ b2[i] });
			if (node.getValue()[0] != 0){
				frequencies.offer(node);
			}

		}

	}

}
