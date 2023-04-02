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

    @Test
    @DisplayName("Should Successful Buy Tour By Card")
    void shouldSuccessfulBuyTourByCard() {

        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putNotActiveCardNumber();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        $("form button").click();
        $(".notification__content").shouldBe(visible, Duration.ofMinutes(2)).shouldHave(exactText("Успешно. Операция одобрена банком"));

    }

    @Test
    @DisplayName("Should reject Buy Tour By not valid Card")
    void shouldRejectBuyTourByNotValidCard() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putNotActiveCardNumber();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        $("form button").click();
        $(".notification__content").shouldBe(visible, Duration.ofMinutes(2)).shouldHave(text("Ошибка! Банк отказал в проведении операции"));
    }

    @Test
    @DisplayName("Should reject Buy Tour By With Short Card Number")
    void shouldRejectBuyTourWithShortCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putShortCardNumber();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        $("form button").click();
        $(byText("Неверный формат")).shouldBe(visible);
    }
    @Test
    @DisplayName("Should reject Buy Tour By Without Card Number")
    void shouldRejectBuyTourWithoutCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        $("form button").click();
        $(byText("Неверный формат")).shouldBe(visible);
    }

    @Test
    @DisplayName("Should reject Buy Tour with Letters in Card Number")
    void shouldRejectBuyTourWithLettersInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putLettersInCardNumber();
        buyTourPage.putValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        $("form button").click();
        $(byText("Неверный формат")).shouldBe(visible);
    }

    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month")
    void shouldRejectBuyTourWithNotValidMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putActiveCardNumber();
        buyTourPage.putNotValidMonth();
        buyTourPage.putValidYear();
        buyTourPage.putValidCVV();
        buyTourPage.putValidOwner();
        $("form button").click();
        $(byText("Неверно указан срок действия карты")).shouldBe(visible);
    }

    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(Tree symbols)")
    void shouldRejectBuyTourWithTreeSymbolsInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        buyTourPage.putActiveCardNumber();
        buyTourPage.putTreeSymbolsInMonth();
        $("form button").click();
        BuyTourPage.month.shouldHave(exactText(String.valueOf(12)));





    }
}


