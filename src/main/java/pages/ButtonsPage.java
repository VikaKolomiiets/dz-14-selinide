package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ButtonsPage{

    private List<SelenideElement> buttons = $$x("//button[contains(@class, 'primary')]");
    private final String CLICK_ME_BUTTON = "Click Me";
    private SelenideElement appearedMessage = $("#dynamicClickMessage");


    public String getTestAfterClickOnButtonClickMe(){
        try{
            buttons.stream()
                    .filter(e -> e.getText().equals(CLICK_ME_BUTTON))
                    .findFirst()
                    .get()
                    .click();
        } catch (NoSuchElementException e){
            throw new NoSuchElementException("element is not found");
        }
        return appearedMessage.getText();
    }
}
