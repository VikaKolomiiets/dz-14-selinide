package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    @BeforeClass
    public void setUpClass(){
        Configuration.browser = "chrome";
        Configuration.browserSize="1024x768";
    }

    @BeforeMethod
    public void setUpMethod(){
       Selenide.open("https://demoqa.com/");
    }

    @AfterClass
    public void tearDownClass(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
