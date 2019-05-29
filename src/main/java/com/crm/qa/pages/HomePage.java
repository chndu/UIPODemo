package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	//定位全部
	@FindBy(xpath = "//li[1]/span")
	@CacheLookup
	WebElement allLink;

	//企业名
	@FindBy(xpath = "//li[2]/span")
	WebElement enterpriseNameLink;

	//主要人员
	@FindBy(xpath = "//li[3]/span")
	WebElement keypersonLink;
	
	//产品、品牌
	@FindBy(xpath = "//li[4]/span")
	WebElement productLink;

	//联系方式
	@FindBy(xpath = "li[5]/span")
	WebElement contactLink;

	//经营范围
	@FindBy(xpath = "li[6]/span")
	WebElement  businessLink;

	//首页输入框
	@FindBy(id = "searchInput")
	WebElement inputBox;

	//点击普通搜索
	@FindBy(id = "searchBtn")
	WebElement searchBtn;



	// Initializing the Page Objects:
	public HomePage() {

		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){

		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return allLink.isDisplayed();
	}
	
	public ContactsPage clickOnEnterpriseName(String keys) {
		driver.navigate().refresh();
		enterpriseNameLink.click();
		inputBox.sendKeys(keys);
		searchBtn.click();
		return new ContactsPage();
	}

	//实现二级菜单定位
	public void  secondMenuClick(){
		WebElement id = keypersonLink;
		id.click();

		WebElement web = id.findElement(By.xpath("二级菜单路径"));
		web.click();
	}


}
