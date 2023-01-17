import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Common.VtigerBaseclass;
import POMclasses.DocumentPage;

public class DocumentTest  extends VtigerBaseclass
{
	@Test
	public void Dcocument() throws EncryptedDocumentException, IOException 
	{
		DocumentPage documentPage = new DocumentPage(driver);
		documentPage.document(driver);
		
	}

}
