import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import POMclasses.*;
import Common.VtigerBaseclass;

public class CreatecampaignTest extends VtigerBaseclass {
	
	@Test
	public void campaign() throws EncryptedDocumentException, IOException {
		
		createCampaignPage createCampaignPage= new createCampaignPage(driver);
		createCampaignPage.campaign(driver);
	}

}