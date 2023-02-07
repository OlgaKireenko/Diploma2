package ru.netology.page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    public SelenideElement buyButton = $("button").shouldHave(text("Купить"));

    public BuyTourPage clickButtonBuy() {
        buyButton.click();
        return new BuyTourPage();
    }
}