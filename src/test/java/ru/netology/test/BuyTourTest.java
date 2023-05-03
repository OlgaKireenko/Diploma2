package ru.netology.test;
///import lombok.var;
///import lombok.var;

///import lombok.var;

import com.codeborne.selenide.commands.ShouldHave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
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
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.getTreeSymbols());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.findSuccessContent();

    }

    //2
    @Test
    @DisplayName("Should reject Buy Tour By not valid Card")
    void shouldRejectBuyTourByNotValidCard() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getNonActiveCardNumber());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.findFailMessage();
    }

    //3
    @Test
    @DisplayName("Should reject Buy Tour By With Short Card Number")
    void shouldRejectBuyTourWithShortCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getSpecSymbols());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //4
    @Test
    @DisplayName("Should reject Buy Tour With Empty Card Number")
    void shouldRejectBuyTourWithEmptyCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //5
    @Test
    @DisplayName("Should reject Buy Tour with extra Long Card Number")
    void shouldRejectBuyTourWithExtraLongCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getExtraLongCardNumber());
        buyTourPage.buyClick();
        buyTourPage.shouldCompare("value", DataHelper.getExtraLongCardNumber());
        buyTourPage.wrongFormatMessage();
    }

    //6
    @Test
    @DisplayName("Should reject Buy Tour with Letters in Card Number")
    void shouldRejectBuyTourWithLettersInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getTreeLetters());
        buyTourPage.buyClick();
        buyTourPage.shouldCompare("value", "");
        buyTourPage.wrongFormatMessage();
    }

    //7
    @Test
    @DisplayName("Should reject Buy Tour with Spec Symbols in Card Number")
    void shouldRejectBuyTourWithSpecSymbolsInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getSpecSymbols());
        buyTourPage.buyClick();
        buyTourPage.shouldCompare("value", "");
        buyTourPage.wrongFormatMessage();
    }
    //Month
    //8

    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month")
    void shouldRejectBuyTourWithNotValidMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putMonth(DataHelper.getNotValidMonth());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.findExpiredCardMessage();
    }

    //9
    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(Tree symbols)")
    void shouldRejectBuyTourWithTreeSymbolsInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putMonth(DataHelper.getTreeSymbols());
        buyTourPage.buyClick();
        buyTourPage.shouldCompare("value", "12");
    }

    //10
    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(One symbols)")
    void shouldRejectBuyTourWithOneSymbolInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putMonth(DataHelper.getOneSymbolMonth());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //11
    @Test
    @DisplayName("Should reject Buy Tour with empty Month field")
    void shouldRejectBuyTourWithEmptyMonthField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //12

    @Test
    @DisplayName("Should reject Buy Tour with spec Symbols in Month field")
    void shouldRejectBuyTourWithSpecSymbolsInMonthField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putMonth(DataHelper.getSpecSymbols());
        buyTourPage.shouldCompare("value", "");
    }

    //13
    @Test
    @DisplayName("Should reject Buy Tour with letters in Month field")
    void shouldRejectBuyTourWithLettersInMonthField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putMonth(DataHelper.getTreeLetters());
        buyTourPage.shouldCompare("value", "12");
    }

    //14
    @Test
    @DisplayName("Should reject Buy Tour with expired card")
    void shouldRejectBuyTourWithExpiredCard() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateSysdateYear());
        buyTourPage.putMonth(DataHelper.generatePreviousMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.findExpiredCardMessage();
    }

    //15

    @Test
    @DisplayName("Should reject Buy Tour with wrong year")
    void shouldRejectBuyTourWithWrongYearPlus10Years() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateSysdateYearPlusTen());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.findExpiredCardMessage();
    }

}




