package edu.neumont.csc250;

import java.io.IOException;

import edu.neumont.ui.Picture;

public class Test {

	public static void main(String[] args) {

		Picture pic = new Picture("matrix.png");
		
		Steganog nog = new Steganog();
		
//		Picture picWithMessage = null;
//		
//		try {
//			picWithMessage = nog.embedIntoImage(pic, "My favorite Doctor from the British Television Science Fiction Show, 'Doctor Who' is the 10th Doctor played by David Tenant. I like 10 the most because he had amazing adventures and I like his over arching story. And I love Daleks and 10 got the most Daleks that I know of I have only seen new who./");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		picWithMessage.save("newPic.png");
		Picture pic2 = new Picture("newPic.png");

		String message = "";
		
		try {
			message = nog.retreiveFromImage(pic2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(message);
	}

}
