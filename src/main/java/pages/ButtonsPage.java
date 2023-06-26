package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

public class ButtonsPage {

    private List<SelenideElement> buttons = $$("[class *= 'primary']");
    private final String CLICK_ME_BUTTON = "Click Me";
    private SelenideElement appearedMessage = $("#dynamicClickMessage");
    private String TEXT_MESSAGE = "You have done a dynamic click";

    @Step("Get appeared text after click on the Button with name ClickMe")
    public String getTestAfterClickOnButtonClickMe() {
        try {
            buttons.stream()
                    .filter(e -> e.getText().equals(CLICK_ME_BUTTON))
                    .findFirst()
                    .get()
                    .click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("element is not found");
        }
        return appearedMessage.shouldBe(Condition.visible).getText();
    }

    @Step("Check appeared text after click on the Button with name ClickMe")
    public boolean isAppearedRequiredMessageText() {
        try {
            buttons.stream()
                    .filter(e -> e.getText().equals(CLICK_ME_BUTTON))
                    .findFirst()
                    .get()
                    .click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("element is not found");
        }
        return (appearedMessage.shouldBe(Condition.visible).shouldHave(Condition.text(TEXT_MESSAGE))) != null;
    }
}
