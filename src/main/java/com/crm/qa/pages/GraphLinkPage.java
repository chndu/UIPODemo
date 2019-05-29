package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphLinkPage extends TestBase {

    @FindBy(className = "graph-link-img")
    WebElement graphLink;

    //集团派系
    @FindBy(xpath = "//ul/li[1]")
    WebElement groupList;

    //担保圈链
    @FindBy(xpath = "//ul/li[2]")
    WebElement guaranteeList;

    //黑名单关联族谱
    @FindBy(xpath = "//ul/li[3]")
    WebElement blackList;

    //上下游族谱
    @FindBy(xpath = "//ul/li[4]")
    WebElement upAndDwonList;


    public GraphLinkPage(){
        PageFactory.initElements(driver,this);
    }


    public void selectGraphLink(){
        graphLink.click();
    }

    public void selectGroupList() {
        driver.findElement(By.linkText("派系核心企业"));
    }

    public void selectGuaranteeList() {
        guaranteeList.click();
    }

    public void  selectBlackList(){
        blackList.click();
    }

    public void selectUpAndDwonList(){
        upAndDwonList.click();
    }
}
