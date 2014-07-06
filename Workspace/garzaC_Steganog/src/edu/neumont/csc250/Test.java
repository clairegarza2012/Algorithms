package edu.neumont.csc250;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;
import edu.neumont.ui.Picture;

public class Test {

	static double count = 0;
	
	public static void main(String[] args) {

		Picture pic = new Picture("cat.png");

		Steganog nog = new Steganog();

		Timer timer = new Timer(1, new TimerListener());
		timer.start();
		
		Picture picWithMessage = null;

		String myMessage = "";
		for (int i = 0; i < 10; i++){
			myMessage += "a";
		}
		myMessage += '/';

		try {
			picWithMessage = nog.embedIntoImage(pic, myMessage);
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
		System.out.println(count/1000);
		
		timer.stop();
	}

	private static class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
		}
		
		
	}

	
}
