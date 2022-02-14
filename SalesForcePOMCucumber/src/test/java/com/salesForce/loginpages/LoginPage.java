package com.salesForce.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesForce.base.BasePage;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="Login") WebElement loginButton;
	@FindBy(id="rememberUn") WebElement RememberMe;
	@FindBy(id="forgot_password_link") WebElement forgotPasswod;
	@FindBy(id="error") WebElement loginError;
	@FindBy(id="idcard-identity") WebElement uname_placeholder;
	//ForgotPassword
	@FindBy(id="un") WebElement forgotPwdUname;
	@FindBy(id="continue") WebElement continueButton;
	@FindBy(id="header") WebElement chk_Your_email_header;
	
	public void enterintoUsername(String UsrName)
	{
		waitUntilVisible(username);
		enterText(username, UsrName);
	}
	public void clearUsername()
	{
		clearElement(username);
	}
	public void clearPassword()
	{
		clearElement(password);
	}
	public String getTextOfUsername()
	{
		//String u_name_text=username.getText();
		return uname_placeholder.getText();
	}
	
	public String getUnameError()
	{
		return loginError.getText();
	}
	public void enterIntoPassword(String PWord)
	{
		waitUntilVisible(password);
		enterText(password, PWord);
	}
	public void clickLoginButton()
	{
		waitUntilVisible(loginButton);
		clickElement(loginButton);
	}
	public void clickRememberMe()
	{
		waitUntilVisible(RememberMe);
		clickElement(RememberMe);
	}
	public void clickForgotPassword()
	{
		waitUntilVisible(forgotPasswod);
		clickElement(forgotPasswod);
	}
	
	public void enterInUnameForgot(String uname)
	{
		waitUntilVisible(forgotPwdUname);
		enterText(forgotPwdUname,uname);
	}
	
	public void clickContinue()
	{
		waitUntilVisible(continueButton);
		clickElement(continueButton);
	}
	
	public String get_chk_email_header()
	{
		return chk_Your_email_header.getText();
	}
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
}


