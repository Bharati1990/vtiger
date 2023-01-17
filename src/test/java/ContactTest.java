import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Common.VtigerBaseclass;
import POMclasses.ContactPage;

public class ContactTest extends VtigerBaseclass {
	@Test
	
public void contact() throws EncryptedDocumentException, IOException
	{
	ContactPage contactPage = new ContactPage(driver);
	contactPage.contact();
	}

}
