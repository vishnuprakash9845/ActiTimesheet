package euro.genomics.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EnterTimeTrackPage extends BasePage{

	@FindBy(id="logoutLink")
	private WebElement logoutLinks;
	
	@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
	private WebElement help;

	@FindBy(linkText="About actiTIME")
	//@FindBy(xpath="(//a[@class='item_link' and text()='About actiTIME']")
	private WebElement aboutActiTime;
	
	@FindBy(xpath="//span[@class='productVersion']")
	private WebElement productVersion;

	@FindBy(xpath="//img[@title='Close']")
	private WebElement closeButton;
	
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogoutLink()
	{
		logoutLinks.click();
	}
	
	public void clickHelp()
	{
		help.click();
	}

	public void clickAboutActiTIME()
	{
		aboutActiTime.click();
	}
	
	public void verifyProductVersion(String eVersion)
	{
		String aVersion=productVersion.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	public void clickCloseButton()
	{
		closeButton.click();
	}
}
