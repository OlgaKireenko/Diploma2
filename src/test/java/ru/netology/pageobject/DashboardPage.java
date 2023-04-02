package ru.netology.pageobject;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement buyButton = $("button").shouldHave(text("Купить"));

    private SelenideElement buyWithCredit = $("button.button.button_view_extra.button_size_m.button_theme_alfa-on-white");


    public BuyTourPage clickButtonBuy() {
        buyButton.click();
        return new BuyTourPage();
    }

    public BuyTourWithCreditPage clickBuyWithCreditButton(){
        buyWithCredit.click();
        return new BuyTourWithCreditPage();
    }


}
