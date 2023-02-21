package ru.netology.page_object;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Data_Helper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class BuyTourPage {
private SelenideElement banner = $(byText("Оплата по карте"));
public SelenideElement cardNumber =  $("[placeholder='0000 0000 0000 0000']");
private SelenideElement month =  $("[placeholder='08']");
private SelenideElement year = $("[placeholder='22']");
private SelenideElement cvv = $("[placeholder='999']");
private SelenideElement owner =$(byText("Владелец")).parent().$("input");


public BuyTourPage(){
    banner.shouldBe(visible);
    }
public void PutActiveCardNumber(){
    cardNumber.setValue (String.valueOf(Data_Helper.getActiveCardNumber()));
    };
public void PutValidMonth(){
    month.setValue(String.valueOf(12));
}
public void PutValidYear(){
    year.setValue(String.valueOf(25));
}
public void PutValidCVV(){
    cvv.setValue(String.valueOf(111));
}
public void PutValidOwner(){
    owner.setValue("Ivanov");
}

        };



