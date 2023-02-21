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

        buyTourPage.PutActiveCardNumber();
        buyTourPage.PutValidMonth();
        buyTourPage.PutValidYear();
        buyTourPage.PutValidCVV();
        buyTourPage.PutValidOwner();
        $(byText("Продолжить")).parent().$("button");/////???не могу найти кнопку
        ///$(".notification__content").shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText(""));


    }
}
