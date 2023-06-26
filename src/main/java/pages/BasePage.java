package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private List<SelenideElement> pageButtons = $$(".card-body");
    private SelenideElement elementsPageButton = $(".card-body");


    @Step("Go to ElementsPage by click on the Button with name Elements")
    public ElementsPage clickElementsPageButtonWithCode() {
        pageButtons.stream()
                .filter(e -> e.getText().equals("Elements"))
                .findFirst()
                .get()
                .click();
        return new ElementsPage();
    }

    @Step("Go to ElementsPage by click on the Button with name Elements")
    public ElementsPage clickElementsPageButton() {
        elementsPageButton
                .shouldBe(Condition.visible)
                .click();
        return new ElementsPage();
    }

}
