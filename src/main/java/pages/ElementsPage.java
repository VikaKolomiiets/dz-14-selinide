package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ElementsPage{

    private List<SelenideElement> firstGroupComponents = $$x("//li[@id='item-3']");
    private List<SelenideElement> secondGroupComponents = $$("#item-4>.text");
    private SelenideElement buttonPageComponent = $("#item-4>.text");

    private final String TEXT_WEB_TABLES ="Web Tables";
    private final String TEXT_BUTTONS ="Buttons";


    public WebTablesPage clickOnWebTablesComponent(){
        firstGroupComponents.stream()
                .filter(e -> e.getText().equals(TEXT_WEB_TABLES))
                .findFirst()
                .get()
                .click();
        return new WebTablesPage();
    }
    @Step("Go to ButtonsPage by click on the Component with name Buttons")
    public ButtonsPage clickOnButtonPageComponentWithReturnPage(){
        secondGroupComponents.stream()
                .filter(e -> e.getText().equals(TEXT_BUTTONS))
                .findFirst()
                .get()
                .click();
        return new ButtonsPage();
    }
    @Step("Go to ButtonsPage by click on the Component with name Buttons")
    public ButtonsPage clickOnButtonPageComponent(){
        buttonPageComponent.shouldBe(Condition.visible).click();
        return new ButtonsPage();
    }




}
