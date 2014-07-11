package edu.neumont.csc250;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;

import edu.neumont.ui.Picture;

public class Steganog {

	/**
	 * Takes a clean image and changes the prime-indexed pixels to secretly
	 * carry the message
	 **/
	public Picture embedIntoImage(Picture cleanImage, String message) 
			throws IOException {

		String myMessage = message.toUpperCase();
		
		Picture dirtyImage = cleanImage;

		int totalPixles = dirtyImage.height() * dirtyImage.width();
		
		PrimeIterator it = new PrimeIterator(totalPixles);
		
		int messageIndex = 0;
		int y = 0;
		String currentCharacter;
		int x;
		int xIndex;
		
		while(it.hasNext() && messageIndex < message.length()){
			x = it.next();
			if(x > dirtyImage.width() * (y + 1))
				y++;
			xIndex = x % dirtyImage.width();

			currentCharacter = Integer.toBinaryString((char)(myMessage.charAt(messageIndex) - 32));
			for (int i = currentCharacter.length(); i < 6; i++){
				currentCharacter = "0" + currentCharacter;
			}
			messageIndex++;
			
			Color oldColor = dirtyImage.get(xIndex, y);
			
			int rr = oldColor.getRed();
			String red = Integer.toBinaryString(rr);
			for (int i = red.length(); i < 8; i++){
				red = "0" + red;
			}
			String redFront = red.substring(0, 6);
			String r = currentCharacter.substring(0, 2);
			redFront += r;
			
			int gg = oldColor.getGreen();
			String green = Integer.toBinaryString(gg);
			for (int i = green.length(); i < 8; i++){
				green = "0" + green;
			}
			String greenFront = green.substring(0, 6);
			String g = currentCharacter.substring(2, 4);
			greenFront += g;
			
			int bb = oldColor.getBlue();
			String blue = Integer.toBinaryString(bb);
			for (int i = blue.length(); i < 8; i++){
				blue = "0" + blue;
			}
			String blueFront = blue.substring(0, 6);
			String b = currentCharacter.substring(4);
			blueFront += b;
			
			int redInt = Integer.parseInt(redFront, 2);
			int greenInt = Integer.parseInt(greenFront, 2);
			int blueInt = Integer.parseInt(blueFront, 2);

			Color color = new Color(redInt, greenInt, blueInt); // all integers
			dirtyImage.set(xIndex, y, color);
		}

		return dirtyImage;
	}

	/**
	 * Retreives the embedded secret from the secret-carrying image
	 */
	public String retreiveFromImage(Picture imageWithSecretMessage)
			throws IOException {
		
		String message = "";

		int totalPixles = imageWithSecretMessage.height() * imageWithSecretMessage.width();
		
		PrimeIterator it = new PrimeIterator(totalPixles);
		
		int y = 0;
		int x = 0;
		int xIndex;
		
		while(it.hasNext()){
			x = it.next();
			if(x > imageWithSecretMessage.width() * (y + 1))
				y++;
			xIndex = x % imageWithSecretMessage.width();
			
			Color color = imageWithSecretMessage.get(xIndex, y);
			
			int red = color.getRed();
			String redBits = Integer.toBinaryString(red);
			for (int i = redBits.length(); i < 8; i++){
				redBits = "0" + redBits;
			}
			String redChar = redBits.substring(6);
			
			int green = color.getGreen();
			String greenBits = Integer.toBinaryString(green);
			for (int i = greenBits.length(); i < 8; i++){
				greenBits = "0" + greenBits;
			}
			String greenChar = greenBits.substring(6);
			
			int blue = color.getBlue();
			String blueBits = Integer.toBinaryString(blue);
			for (int i = blueBits.length(); i < 8; i++){
				blueBits = "0" + blueBits;
			}
			String blueChar = blueBits.substring(6);
			
			String character = redChar + greenChar + blueChar;
			
			char letter = (char)(Integer.parseInt(character, 2) + 32);
			if(letter == '/')
				break;
			message += letter;
			
		}
		
		return message;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
