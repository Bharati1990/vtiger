import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Common.VtigerBaseclass;
import POMclasses.ProductPage;

public class ProductTest extends VtigerBaseclass 
{
	@Test
	
	public void product() throws EncryptedDocumentException, IOException
	{
		ProductPage productPage = new ProductPage(driver);
		productPage.product();
	}

}
