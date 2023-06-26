package tests.buttons;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import tests.base.BaseTests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ButtonsMessageTest extends BaseTests {

    @Test
    public void testClickMeButtonPositive() {
        BasePage basePage = new BasePage();
        String actualText = basePage
                .clickElementsPageButtonWithCode()
                .clickOnButtonPageComponentWithReturnPage()
                .getTestAfterClickOnButtonClickMe();
        String expectedText = "You have done a dynamic click";
        Assert.assertEquals(actualText, expectedText, "Text is not equal to expected after click on ClickMe button.");
    }

    @Test
    public void testClickMeButtonSelenidePositive() {
        BasePage basePage = new BasePage();
        Assert.assertTrue(
                basePage.clickElementsPageButton().
                        clickOnButtonPageComponent().
                        isAppearedRequiredMessageText());
    }
}
