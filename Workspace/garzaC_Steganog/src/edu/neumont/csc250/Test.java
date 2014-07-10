package edu.neumont.csc250;

import java.io.IOException;
import edu.neumont.ui.Picture;

public class Test {
	
	public static void main(String[] args) {

		Picture pic = new Picture("jcMessage.png");

		Steganog nog = new Steganog();
		
		Picture picWithMessage = null;

		try {
			picWithMessage = nog.embedIntoImage(pic, "claire/");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//picWithMessage.save("newPic.png");
		Picture pic2 = new Picture("newPic.png");

		String message = "";

		try {
			message = nog.retreiveFromImage(picWithMessage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(message);
	}
	
}
