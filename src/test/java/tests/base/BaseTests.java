package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTests {

    @BeforeClass
    public void setUpClass(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com/";
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
