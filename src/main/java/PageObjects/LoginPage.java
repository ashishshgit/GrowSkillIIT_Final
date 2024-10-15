package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	By signin=By.name("username");
	By signin_Pssrd=By.name("pw");
	By login_btn=By.name("Login");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement loginInput()
	{
		return driver.findElement(signin);
	}
	
	public WebElement loginPassword()
	{
		return driver.findElement(signin_Pssrd);
	}
	
	public WebElement loginBtn()
	{
		return driver.findElement(login_btn);
	}
	



}
