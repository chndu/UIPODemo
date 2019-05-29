package com.crm.qa.testcases;


import com.crm.qa.base.TestBase;
import com.crm.qa.log.LogType;
import com.crm.qa.log.Logger;
import com.crm.qa.pages.GraphLinkPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GraphLinkPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    GraphLinkPage graphLinkPage;



    @BeforeMethod
    public void setUp() throws InterruptedException{
        initialization();
        testUtil = new TestUtil();
        graphLinkPage = new GraphLinkPage();
        Logger.Output(LogType.LogTypeName.INFO,"登录");
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        TestUtil.runTimeInfo("Success", "login successful");
    }

    @Test(priority=1)
    public void clickGrapLink(){
        Logger.Output(LogType.LogTypeName.INFO,"Home页点击跳转行内企业客户关联分析行内企业客户关联分析");
        graphLinkPage.selectGraphLink();
    }

    @Test(priority = 2)
    public void clickBlock() {
        clickGrapLink();
        switchWindow();
        graphLinkPage.selectBlackList();

    }

    @Test(priority = 3)
    public void clickGuaranteeList(){
        clickGrapLink();
        switchWindow();
        Logger.Output(LogType.LogTypeName.INFO,"点击担保TAB");
        graphLinkPage.selectGuaranteeList();
    }


    @AfterMethod
    public void tearDown(){
        Logger.Output(LogType.LogTypeName.INFO,"退出");
        driver.quit();
    }

}
