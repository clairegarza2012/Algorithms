package edu.neumont.csc252;

import java.util.PriorityQueue;
import edu.neumont.io.Bits;

public class HuffmanTree {

	private FrequencyNode root;
	private PriorityQueue<FrequencyNode> frequencies = new PriorityQueue<FrequencyNode>();

	public HuffmanTree(byte[] b) {

		this.setFrequency(b);

		this.makeTree();
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

			frequencies.add(root);
		}
		
	}

	public byte toByte(Bits bits){

		return (Byte) null;
	}

	public void fromByte(byte b, Bits bits){

	}

	private void setFrequency(byte[] b){

		for (int i = 0; i < b.length; i++){

			double count = 1;
			for (int j = i + 1; j < b.length; j++) {

				if (b[i] == b[j]){
					count ++;
					b[j] = 0;
				}
			}

			double frequency = count / b.length;
			FrequencyNode node = new FrequencyNode( frequency, new byte[]{ b[i] });
			if (node.getValue()[0] != 0){
				frequencies.add(node);
			}

		}
	}

	public PriorityQueue<FrequencyNode> getFrequencies(){
		return frequencies;
	}
	
	public FrequencyNode getRoot(){
		return root;
	}
}
