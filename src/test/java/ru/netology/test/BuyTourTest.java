package ru.netology.test;
 ///import lombok.var;
///import lombok.var;

import ru.netology.page_object.BuyTourPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data_Helper;
import ru.netology.page_object.DashboardPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;

class BuyTourTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    @DisplayName("Should Successful Buy Tour By Card")
    void shouldSuccessfulBuyTourByCard() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        DashboardPage.PutActiveCardNumber();
        DashboardPage.PutValidMonth();
        DashboardPage.PutValidYear();
        DashboardPage.PutValidCVV();
        DashboardPage.PutValidOwner();
        $("form button").click();
        $(".notification__content").shouldBe(visible, Duration.ofMinutes(2)).shouldHave(exactText("Успешно. Операция одобрена банком"));

    }

    @Test
    @DisplayName("Should reject Buy Tour By not valid Card")
    void shouldRejectBuyTourByNotValidCard() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        DashboardPage.PutNotActiveCardNumber();
        DashboardPage.PutValidMonth();
        DashboardPage.PutValidYear();
        DashboardPage.PutValidCVV();
        DashboardPage.PutValidOwner();
        $("form button").click();
        $(".notification__content").shouldBe(visible, Duration.ofMinutes(2)).shouldHave(text("Ошибка! Банк отказал в проведении операции"));
    }

    @Test
    @DisplayName("Should reject Buy Tour By With Short Card Number")
    void shouldRejectBuyTourWithShortCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        DashboardPage.PutShortCardNumber();
        DashboardPage.PutValidMonth();
        DashboardPage.PutValidYear();
        DashboardPage.PutValidCVV();
        DashboardPage.PutValidOwner();
        $("form button").click();
        $(byText("Неверный формат")).shouldBe(visible);
    }
    @Test
    @DisplayName("Should reject Buy Tour By Without Card Number")
    void shouldRejectBuyTourWithoutCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        DashboardPage.PutValidMonth();
        DashboardPage.PutValidYear();
        DashboardPage.PutValidCVV();
        DashboardPage.PutValidOwner();
        $("form button").click();
        $(byText("Неверный формат")).shouldBe(visible);
    }

    @Test
    @DisplayName("Should reject Buy Tour with Letters in Card Number")
    void shouldRejectBuyTourWithLettersInCardNumber() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        DashboardPage.PutLettersInCardNumber();
        DashboardPage.PutValidMonth();
        DashboardPage.PutValidYear();
        DashboardPage.PutValidCVV();
        DashboardPage.PutValidOwner();
        $("form button").click();
        $(byText("Неверный формат")).shouldBe(visible);
    }

    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month")
    void shouldRejectBuyTourWithNotValidMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        DashboardPage.PutActiveCardNumber();
        DashboardPage.PutNotValidMonth();
        DashboardPage.PutValidYear();
        DashboardPage.PutValidCVV();
        DashboardPage.PutValidOwner();
        $("form button").click();
        $(byText("Неверно указан срок действия карты")).shouldBe(visible);
    }

    @Test
    @DisplayName("Should reject Buy Tour with Not Valid Month(Tree symbols)")
    void shouldRejectBuyTourWithTreeSymbolsInMonth() {
        var buyTourPage = new DashboardPage().clickButtonBuy();
        DashboardPage.PutActiveCardNumber();
        DashboardPage.PutTreeSymbolsInMonth();
        $("form button").click();

    }
}


