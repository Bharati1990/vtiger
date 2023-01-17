import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Common.VtigerBaseclass;
import POMclasses.OrganizationsPage;

public class OrganizationsTest  extends VtigerBaseclass
{
	@Test
	
	public void organizations() throws EncryptedDocumentException, IOException {
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.organizations();
				
	}

}
