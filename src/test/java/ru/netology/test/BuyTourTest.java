package ru.netology.test;
///import lombok.var;
///import lombok.var;

///import lombok.var;

import com.codeborne.selenide.commands.ShouldHave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.pageobject.BuyTourPage;
import ru.netology.pageobject.DashboardPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyTourTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    //1
    @Test
    @DisplayName("Should Successful Buy Tour By Card")
    void shouldSuccessfulBuyTourByCard() {

        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putNotActiveCardNumber();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        buyTourPage.buyClick();
        buyTourPage.findSuccessContent();

    }

    //2
    @Test
    @DisplayName("Should reject Buy Tour By not valid Card")
    void shouldRejectBuyTourByNotValidCard() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putNotActiveCardNumber();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        buyTourPage.buyClick();
        buyTourPage.findFailMessage();
    }

    //3
    @Test
    @DisplayName("Should reject Buy Tour By With Short Card Number")
    void shouldRejectBuyTourWithShortCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putShortCardNumber();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //4
    @Test
    @DisplayName("Should reject Buy Tour With Empty Card Number")
    void shouldRejectBuyTourWithEmptyCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //5
    @Test
    @DisplayName("Should reject Buy Tour with extra Long Card Number")
    void shouldRejectBuyTourWithExtraLongCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putExtraLongCardNumber();
        buyTourPage.buyClick();
        buyTourPage.shouldCompareCardExtraLong();
        buyTourPage.wrongFormatMessage();
    }
//6
    @Test
    @DisplayName("Should reject Buy Tour with Letters in Card Number")
    void shouldRejectBuyTourWithLettersInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putLettersInCardNumber();
        buyTourPage.buyClick();
        buyTourPage.shouldCompareCard();
        buyTourPage.wrongFormatMessage();
    }

    //7
    @Test
    @DisplayName("Should reject Buy Tour with Spec Symbols in Card Number")
    void shouldRejectBuyTourWithSpecSymbolsInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putSpecSymbols();
        buyTourPage.buyClick();
        buyTourPage.shouldCompareCard();
        buyTourPage.wrongFormatMessage();
    }
    //Month
    //8

    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month")
    void shouldRejectBuyTourWithNotValidMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putActiveCardNumber();
        buyTourPage.putNotValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }
//9
    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(Tree symbols)")
    void shouldRejectBuyTourWithTreeSymbolsInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putActiveCardNumber();
        buyTourPage.putTreeSymbolsInMonth();
        buyTourPage.buyClick();
        buyTourPage.shouldCompareMonth();
    }

    //10
    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(One symbols)")
    void shouldRejectBuyTourWithOneSymbolInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putActiveCardNumber();
        buyTourPage.putTreeSymbolsInMonth();
        buyTourPage.buyClick();
        buyTourPage.shouldCompareMonth();
    }

    //11
    @Test
    @DisplayName("Should reject Buy Tour with empty Month field")
    void shouldRejectBuyTourWithEmptyMonthField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putActiveCardNumber();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }









}


