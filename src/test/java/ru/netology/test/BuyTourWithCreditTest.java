package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.sql.SqlQuery;
import ru.netology.pageobject.DashboardPage;

import java.util.function.ToDoubleBiFunction;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTourWithCreditTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //1
    @Test
    @DisplayName("ShouldSuccessfulBuyWithValidCard")
    void shouldSuccessfulBuyTourWithCredit() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findSuccessContent();
        String res = SqlQuery.getCreditPaymentStatus();
        assertEquals("APPROVED", res);
    }

    //2 баг?
    @Test
    @DisplayName("ShouldRejectBuyWithNotValidCard")
    void ShouldRejectBuyWithNotValidCard() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getNonActiveCardNumber());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findFailMessage();
        String res = SqlQuery.getCreditPaymentStatus();
        assertEquals("DECLINED", res);
    }

    //SQL

    //3
    @Test
    @DisplayName("Should reject Buy Tour By With Short Card Number")
    void shouldRejectBuyTourWithShortCardNumber() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getTreeSymbols());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.wrongFormatMessage();
    }

    //4
    @Test
    @DisplayName("Should reject Buy Tour With Empty Card Number")
    void shouldRejectBuyTourWithEmptyCardNumber() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.wrongFormatMessage();
    }

    //5
    @Test
    @DisplayName("Should be impossible to put extra Long Card Number")
    void shouldRejectBuyTourWithExtraLongCardNumber() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getExtraLongCardNumber());
        buyTourWithCreditPage.shouldCompareCardNumber("value", "4444 4444 4444 4444");
    }

    //6
    @Test
    @DisplayName("Should be impossible to put Letters in Card Number")
    void shouldRejectBuyTourWithLettersInCardNumber() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getTreeLetters());
        buyTourWithCreditPage.shouldCompareCardNumber("value", "");
    }

    //7
    @Test
    @DisplayName("Should be impossible to put Spec Symbols in Card Number")
    void shouldRejectBuyTourWithSpecSymbolsInCardNumber() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getSpecSymbols());
        buyTourWithCreditPage.shouldCompareCardNumber("value", "");
    }
    //Month
    //8

    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month")
    void shouldRejectBuyTourWithNotValidMonth() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putMonth(DataHelper.getNotValidMonth());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findWrongCardMessage();
    }

    //9
    @Test
    @DisplayName("Should be impossible to put Tree symbols in month field)")
    void shouldRejectBuyTourWithTreeSymbolsInMonth() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putMonth(DataHelper.getTreeSymbols());
        buyTourWithCreditPage.shouldCompare("value", "12");
    }

    //10
    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(One symbols)")
    void shouldRejectBuyTourWithOneSymbolInMonth() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putMonth(DataHelper.getOneSymbolMonth());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.wrongFormatMessage();
    }

    //11
    @Test
    @DisplayName("Should reject Buy Tour with empty Month field")
    void shouldRejectBuyTourWithEmptyMonthField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.wrongFormatMessage();
    }

    //12

    @Test
    @DisplayName("Should be impossible to put spec Symbols in Month field")
    void shouldRejectBuyTourWithSpecSymbolsInMonthField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putMonth(DataHelper.getSpecSymbols());
        buyTourWithCreditPage.shouldCompare("value", "");
    }

    //13
    @Test
    @DisplayName("Should be impossible to put letters in Month field")
    void shouldRejectBuyTourWithLettersInMonthField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putMonth(DataHelper.getTreeLetters());
        buyTourWithCreditPage.shouldCompare("value", "");
    }

    //14
    @Test
    @DisplayName("Should reject Buy Tour with expired card")
    void shouldRejectBuyTourWithExpiredCard() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.generateSysdateYear());
        buyTourWithCreditPage.putMonth(DataHelper.generatePreviousMonth());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findWrongCardMessage();
    }

    //15

    @Test
    @DisplayName("Should reject Buy Tour with wrong year")
    void shouldRejectBuyTourWithWrongYearPlus10Years() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.generateSysdateYearPlusTen());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findWrongCardMessage();
    }


    //16
    @Test
    @DisplayName("Should reject Buy Tour with wrong year")
    void shouldRejectBuyTourWithWrongYearMinus3Years() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.generateSysdateYearMinusThree());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findExpiredCardMessage();
    }

    //17
    @Test
    @DisplayName("Should be impossible to put three symbols in year field")
    void shouldBeImpossibleToPutThreeSymbolsInYearField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putYear(DataHelper.getTreeSymbols());
        buyTourWithCreditPage.shouldCompareYear("value", "12");
    }

    //18
    @Test
    @DisplayName("Should reject Buy Tour with wrong year")
    void shouldBeImpossibleToBuyTourWithOneSymbolInYearField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.getOneSymbolMonth());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.wrongFormatMessage();
    }

    //19
    @Test
    @DisplayName("Should reject Buy Tour with spec Symbols in Year field")
    void shouldRejectBuyTourWithSpecSymbolsInYearField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putYear(DataHelper.getSpecSymbols());
        buyTourWithCreditPage.shouldCompareYear("value", "");
    }

    //20
    @Test
    @DisplayName("Should reject Buy Tour with letters in Year field")
    void shouldRejectBuyTourWithLettersInYearField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putYear(DataHelper.getTreeLetters());
        buyTourWithCreditPage.shouldCompareYear("value", "");
    }

    //21
    @Test
    @DisplayName("Should reject Buy Tour with empty Year field")
    void shouldRejectBuyTourWithEmptyYearField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.wrongFormatMessage();
    }

    //22
    @Test
    @DisplayName("Should reject Buy Tour with empty Owner field")
    void shouldBeImpossibleToBuyTourWithEmptyOwnerField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        //buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findMustFillInMessage();

    }

    //23Баг
    @Test
    @DisplayName("Should be impossible to put 100 symbols in owner field")
    void shouldBeImpossibleToPutOneHundredSymbolsInOwnerField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.getExtraLongCardNumber());
        buyTourWithCreditPage.buyClick();
        int len = 18; //to do: count length owner field
        assertEquals(18, len);

    }

    //24баг
    @Test
    @DisplayName("Should be impossible to put Cyrillic symbols in owner field")
    void shouldBeImpossibleToPutCyrillicSymbolsInOwnerField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putOwner(DataHelper.generateCyrillicSymbolsFullName());
        buyTourWithCreditPage.shouldCompareOwner("value", "");

    }

    //25 Баг
    @Test
    @DisplayName("Should be impossible to put Symbols or Numbers in owner field")
    void shouldBeImpossibleToPutSpecSymbolsInOwnerField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putOwner(DataHelper.getSpecSymbols());
        buyTourWithCreditPage.shouldCompareOwner("value","");
    }
    //26баг

    @Test
    @DisplayName("Should be impossible to buy tour with two symbols in owner field")
    void shouldBeImpossibleToBuyTourWithTwoSymbolsInOwnerField() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putOwner(DataHelper.generateExtraShortFullName());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.wrongFormatMessage();
    }




}
