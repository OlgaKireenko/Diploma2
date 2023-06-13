package ru.netology.test;

import ru.netology.data.DataHelper;

import com.codeborne.selenide.commands.ShouldHave;
import org.junit.jupiter.api.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import ru.netology.pageobject.BuyTourPage;
import ru.netology.pageobject.DashboardPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qameta.allure.selenide.AllureSelenide;
import ru.netology.sql.SqlQuery;

class BuyTourTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


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
        String res = SqlQuery.getDebitPaymentStatus();
        assertEquals("APPROVED", res);

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
        String res = SqlQuery.getDebitPaymentStatus();
        assertEquals("DECLINED", res);
    }

    //3
    @Test
    @DisplayName("Should reject Buy Tour By With Short Card Number")
    void shouldRejectBuyTourWithShortCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getOneSymbolMonth());
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
    @DisplayName("Should be impossible to put extra Long value in Card Number")
    void ShouldBeImpossibleToPutExtraLongValueInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getExtraLongCardNumber());
        buyTourPage.shouldCompareCardNumber("value", "4444 4444 4444 4444");
    }

    //6
    @Test
    @DisplayName("Should be impossible to put Letters in Card Number")
    void shouldRejectBuyTourWithLettersInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getTreeLetters());
        buyTourPage.shouldCompare("value", "");
    }

    //7
    @Test
    @DisplayName("Should reject Buy Tour with Spec Symbols in Card Number")
    void shouldRejectBuyTourWithSpecSymbolsInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getSpecSymbols());
        buyTourPage.shouldCompare("value", "");
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
        buyTourPage.findWrongCardMessage();
    }

    //9
    @Test
    @DisplayName("Should be impossible to put Tree symbols in Month field")
    void shouldRejectBuyTourWithTreeSymbolsInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putMonth(DataHelper.getTreeSymbols());
        buyTourPage.shouldCompare("value", "12");
    }

    //10
    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(One symbol)")
    void shouldRejectBuyTourWithOneSymbolInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putCVV(DataHelper.getTreeSymbols());
        buyTourPage.putOwner(DataHelper.generateFullName());
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
    @DisplayName("Should be impossible to put spec Symbols in Month field")
    void shouldRejectBuyTourWithSpecSymbolsInMonthField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putMonth(DataHelper.getSpecSymbols());
        buyTourPage.shouldCompare("value", "");
    }

    //13
    @Test
    @DisplayName("Should be impossible to put letters in Month field")
    void shouldRejectBuyTourWithLettersInMonthField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putMonth(DataHelper.getTreeLetters());
        buyTourPage.shouldCompare("value", "");
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
        buyTourPage.findWrongCardMessage();
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
        buyTourPage.findWrongCardMessage();
    }
    //16
    @Test
    @DisplayName("Should reject Buy Tour with wrong year")
    void shouldRejectBuyTourWithWrongYearMinus3Years() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateSysdateYearMinusThree());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.findExpiredCardMessage();
    }
    //17
    @Test
    @DisplayName("Should be impossible to put three symbols in year field")
    void shouldBeImpossibleToPutThreeSymbolsInYearField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putYear(DataHelper.getTreeSymbols());
        buyTourPage.shouldCompareYear("value", "12");
    }
    //18
    @Test
    @DisplayName("Should reject Buy Tour with one Symbol in year")
    void shouldBeImpossibleToBuyTourWithOneSymbolInYearField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.getOneSymbolMonth());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //19
    @Test
    @DisplayName("Should be impossible to put spec Symbols in Year field")
    void shouldRejectBuyTourWithSpecSymbolsInYearField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.getSpecSymbols());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.shouldCompareYear("value", "");
    }

    //20
    @Test
    @DisplayName("Should be impossible to put letters in Year field")
    void shouldRejectBuyTourWithLettersInYearField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.getTreeLetters());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.shouldCompareYear("value", "");
    }

    //21
    @Test
    @DisplayName("Should reject Buy Tour with empty Year field")
    void shouldRejectBuyTourWithEmptyYearField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //22
    @Test
    @DisplayName("Should reject Buy Tour with empty Owner field")
    void shouldBeImpossibleToBuyTourWithEmptyOwnerField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.buyClick();
        buyTourPage.findMustFillInMessage();

    }

    //23Баг
    @Test
    @DisplayName("Should be impossible to put 100 symbols in owner field")
    void shouldBeImpossibleToPutOneHundredSymbolsInOwnerField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateExtraLongFullName());
        buyTourPage.buyClick();
        buyTourPage.shouldCompareOwner("value","Ivaaaaaaaaaaaaaaaaaaaaaaaaan Ivaaaaa");

    }

    //24баг
    @Test
    @DisplayName("Should be impossible to put Cyrillic symbols in owner field")
    void shouldBeImpossibleToPutCyrillicSymbolsInOwnerField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateCyrillicSymbolsFullName());
        buyTourPage.buyClick();
        buyTourPage.shouldCompareOwner("value", "");

    }

    //25баг
    @Test
    @DisplayName("Should be impossible to put Symbols or Numbers in owner field")
    void shouldBeImpossibleToPutSpecSymbolsInOwnerField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putOwner(DataHelper.getSpecSymbols());
        buyTourPage.shouldCompareOwner("value", "");
    }

    //26баг
    @Test
    @DisplayName("Should be impossible to buy tour with two symbols in owner field")
    void shouldBeImpossibleToBuyTourWithTwoSymbolsInOwnerField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putCVV(DataHelper.generateCVV());
        buyTourPage.putOwner(DataHelper.generateExtraShortFullName());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    //TO DO CVV test
    @Test
    @DisplayName("Should be impossible to buy tour with empty CVV field")
    void shouldBeImpossibleToBuyTourWithEmptyCVVField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    @Test
    @DisplayName("Should be impossible to put more than three numbers into the CVV field")
    void shouldBeImpossibleToPutMoreThanThreeNumInCVVField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putCVV(DataHelper.getExtraLongCardNumber());
        buyTourPage.shouldCompareCVV("value", "444");
    }

    @Test
    @DisplayName("Should be impossible to buy tour with one symbol in CVV field")
    void shouldBeImpossibleToBuyTourWithOneSymbolInCVVField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putCVV(DataHelper.getOneSymbolMonth());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    ///баг
    @Test
    @DisplayName("Should be impossible to buy tour with Three zero in CVV field")
    void shouldBeImpossibleToBuyTourWithThreeZeroInCVVField() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourPage.putYear(DataHelper.generateYear());
        buyTourPage.putMonth(DataHelper.generateMonth());
        buyTourPage.putOwner(DataHelper.generateFullName());
        buyTourPage.putCVV(DataHelper.getThreeZeros());
        buyTourPage.buyClick();
        buyTourPage.wrongFormatMessage();
    }

    @Test
    @DisplayName("Error underlines Should disappear after filing form")
    void  ErrorUnderLinesShouldDisappear(){
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.buyClick();
        buyTourPage.makeSuccessPaymentByDebitCard();
        buyTourPage.wrongFormatMessageShouldNotBeVisible();
        buyTourPage.mustFillInMessageShouldNotBeVisible();


    }
}




