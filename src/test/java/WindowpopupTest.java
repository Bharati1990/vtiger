import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Common.VtigerBaseclass;
import POMclasses.WindowpopupPage;

public class WindowpopupTest  extends VtigerBaseclass 
{
	@Test
	
	public void windowpopup() throws EncryptedDocumentException, IOException, InterruptedException {
		WindowpopupPage windowpopupPage = new WindowpopupPage(driver);
		windowpopupPage.windowpopup(driver);
				
	}
	

}
