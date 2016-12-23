package euro.genomics.scripts;

import org.testng.annotations.Test;

import euro.genomics.generics.Excel;
import euro.genomics.generics.WaitForMoment;
import euro.genomics.pom.LoginPage;

public class InvalidLogin extends BaseTest{

	@Test
	public void testInvaliLogin()
	{
		int rc=Excel.getRowCount(XL_PATH, "InvalidLogin");
		
		for(int i=1;i<=rc;i++)
		{
			String un=Excel.getCellValue(XL_PATH, "InvalidLogin",i, 0);
			String pw=Excel.getCellValue(XL_PATH, "InvalidLogin",i, 1);
			
			LoginPage l=new LoginPage(driver);
			l.setUserName(un);
			l.setPassword(pw);
			l.clickLogin();
			
			WaitForMoment.wait(2);
			
			l.verifyErrMsgDisplayed();
			
			
		}
		
		WaitForMoment.wait(5);
	}
	
}
