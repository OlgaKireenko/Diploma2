package ru.netology.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BuyTourPage {

    private SelenideElement banner = $(byText("Оплата по карте"));
    public static SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private static SelenideElement month = $("[placeholder='08']");
    private static SelenideElement year = $("[placeholder='22']");
    private static SelenideElement cvv = $("[placeholder='999']");
    private static SelenideElement owner = $(byText("Владелец")).parent().$("input");
    private static SelenideElement buy = $("form button");
    private static SelenideElement finalMessage = $(".notification__content");
    private static SelenideElement underLineMessage = $(byText("Неверный формат"));
    public void buyClick(){
        buy.click();
    }
    public void putActiveCardNumber() {
        cardNumber.setValue(String.valueOf(DataHelper.getActiveCardNumber()));
        ///cardNumber.setValue("4444 4444 4444 4441");
    }


    public void putNotActiveCardNumber() {
        cardNumber.setValue(String.valueOf(DataHelper.getNonActiveCardNumber()));
    }

    public void putValidMonth() {
        month.setValue(String.valueOf(DataHelper.getValidMonth()));
    }

    public void putValidYear() {
        year.setValue(String.valueOf(DataHelper.getValidYear()));
    }

    public void putValidCVV() {
        cvv.setValue(String.valueOf(DataHelper.getValidCVV()));
    }

    public void putValidOwner() {
        owner.setValue(DataHelper.getValidSurname());
    }

    public void putShortCardNumber() {
        cardNumber.setValue(String.valueOf(DataHelper.getTreeSymbols()));
    }

    public void putLettersInCardNumber() {
        cardNumber.setValue(DataHelper.getTreeLetters());
    }

    public void putNotValidMonth() {
        month.setValue(String.valueOf(DataHelper.getNotValidMonth()));
    }

    public void putTreeSymbolsInMonth() {
        month.setValue(String.valueOf(DataHelper.getTreeSymbols()));

    }

    public void shouldCompareMonth() {
        month.shouldHave(Condition.attribute("value", "12"));

    }
    public void shouldCompareCard(){
        cardNumber.shouldHave(Condition.attribute("value", ""));
    }

    public void putExtraLongCardNumber(){
        cardNumber.setValue(String.valueOf(DataHelper.getExtraLongCardNumber()));
    }
    public void shouldCompareCardExtraLong(){
        cardNumber.shouldHave(Condition.attribute("value", "4444 4444 4444 4444"));

    }
    public void putSpecSymbols(){
        cardNumber.setValue(String.valueOf(DataHelper.getSpecSymbols()));
    }

    public void findSuccessContent(){

        finalMessage.shouldBe(visible, Duration.ofMinutes(1)).shouldHave(exactText("Успешно. Операция одобрена банком"));
    }

    public void findFailMessage(){
        finalMessage.shouldBe(visible, Duration.ofMinutes(1)).shouldHave(exactText("Ошибка! Банк отказал в проведении операции"));
    }

    public void wrongFormatMessage(){
        underLineMessage.shouldBe(visible);

    }

}



