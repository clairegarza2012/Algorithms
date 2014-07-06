import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import edu.neumont.csc250.Steganog;
import edu.neumont.ui.Picture;

public class SteganogTest {

	private Steganog nog = new Steganog();
	
	@Test
	public void Test() {
		Picture pic = new Picture("matrix.png");
		Assert.assertNotNull(pic);
		
		Picture picWithMessage = null;

		try {
			picWithMessage = nog.embedIntoImage(pic, "a message/");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//picWithMessage.save("newPic.png");
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