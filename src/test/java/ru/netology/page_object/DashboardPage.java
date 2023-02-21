package ru.netology.page_object;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement buyButton = $("button").shouldHave(text("Купить"));
    //private SelenideElement heading = $("Order_cardImage__Q69ii").shouldBe(visible);
  ///  public DashboardPage() {
       // heading.shouldBe(visible);
    //}

    public BuyTourPage clickButtonBuy() {
        buyButton.click();
        return new BuyTourPage();
    }
}