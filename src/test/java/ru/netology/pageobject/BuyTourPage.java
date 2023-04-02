package ru.netology.pageobject;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BuyTourPage {

    private SelenideElement banner = $(byText("Оплата по карте"));
    public static SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    public static SelenideElement month = $("[placeholder='08']");
    private static SelenideElement year = $("[placeholder='22']");
    private static SelenideElement cvv = $("[placeholder='999']");
    private static SelenideElement owner = $(byText("Владелец")).parent().$("input");

    public void putActiveCardNumber() {
        cardNumber.setValue(String.valueOf(DataHelper.getActiveCardNumber()));
        ///cardNumber.setValue("4444 4444 4444 4441");
    }

    public void putNotActiveCardNumber(){
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
    public void putShortCardNumber(){
        cardNumber.setValue(String.valueOf(DataHelper.getTreeSymbols()));
    }
    public void putLettersInCardNumber(){
        cardNumber.setValue(DataHelper.getTreeLetters());
    }
    public void putNotValidMonth() {
        month.setValue(String.valueOf(DataHelper.getNotValidMonth()));
    }

    public void putTreeSymbolsInMonth(){
        month.setValue(String.valueOf(DataHelper.getTreeSymbols()));

    }





}



