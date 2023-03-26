package ru.netology.page_object;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import ru.netology.data.Data_Helper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement buyButton = $("button").shouldHave(text("Купить"));

    private SelenideElement buyWithCredit = $("button.button.button_view_extra.button_size_m.button_theme_alfa-on-white");

    private SelenideElement banner = $(byText("Оплата по карте"));
    public static SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private static SelenideElement month = $("[placeholder='08']");
    private static SelenideElement year = $("[placeholder='22']");
    private static SelenideElement cvv = $("[placeholder='999']");
    private static SelenideElement owner = $(byText("Владелец")).parent().$("input");


    public BuyTourPage clickButtonBuy() {
        buyButton.click();
        return new BuyTourPage();
    }
    public BuyTourWithCreditPage clickBuyWithCreditButton(){
        buyWithCredit.click();
        return new BuyTourWithCreditPage();
    }

    public static void PutActiveCardNumber() {
        cardNumber.setValue(String.valueOf(Data_Helper.CardNumber.getActiveCardNumber()));
        ///cardNumber.setValue("4444 4444 4444 4441");
    }

    public static void PutNotActiveCardNumber(){
        cardNumber.setValue(String.valueOf(Data_Helper.CardNumber.getNonActiveCardNumber()));
    }

    public static void PutValidMonth() {
        month.setValue(String.valueOf(Data_Helper.getValidMonth()));
    }

    public static void PutValidYear() {
        year.setValue(String.valueOf(25));
    }

    public static void PutValidCVV() {
        cvv.setValue(String.valueOf(111));
    }

    public static void PutValidOwner() {
        owner.setValue("Ivanov");
    }
    public static void PutShortCardNumber(){
        cardNumber.setValue("444");
    }
    public static void PutLettersInCardNumber(){
        cardNumber.setValue("ФФФ");
    }
    public static void PutNotValidMonth() {
        month.setValue(String.valueOf(Data_Helper.getNotValidMonth()));
    }

    public static void PutTreeSymbolsInMonth(){
        month.setValue(String.valueOf(Data_Helper.getTreeSymbolsMonth()));
    }
}
