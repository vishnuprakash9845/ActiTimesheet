package euro.genomics.scripts;

import org.testng.annotations.Test;

import euro.genomics.generics.Excel;
import euro.genomics.generics.WaitForMoment;
import euro.genomics.pom.EnterTimeTrackPage;
import euro.genomics.pom.LoginPage;

public class VerifyProductVersion extends BaseTest{

	@Test
	public void testVerifyProductVersion()
	{
		String sheet="VerifyProductVersion";
		String un=Excel.getCellValue(XL_PATH,sheet,1, 0);
		String pw=Excel.getCellValue(XL_PATH,sheet,1, 1);
		String version=Excel.getCellValue(XL_PATH,sheet,1, 2);
		
		//enter valid un and pw
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pw);
		//click login
		l.clickLogin();
		WaitForMoment.wait(3);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickHelp();		
		e.clickAboutActiTIME();
		WaitForMoment.wait(2);
		e.verifyProductVersion(version);
		e.clickCloseButton();
		//click on logout
		e.clickLogoutLink();
		
		WaitForMoment.wait(5);
	}
	
}
