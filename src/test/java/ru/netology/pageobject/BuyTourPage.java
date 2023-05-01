package ru.netology.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import ru.netology.test.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import java.util.Date;


public class BuyTourPage {

    private SelenideElement banner = $(byText("Оплата по карте"));
    public static SelenideElement card = $("[placeholder='0000 0000 0000 0000']");
    private static SelenideElement month = $("[placeholder='08']");
    private static SelenideElement year = $("[placeholder='22']");
    private static SelenideElement cvv = $("[placeholder='999']");
    private static SelenideElement owner = $(byText("Владелец")).parent().$("input");
    private static SelenideElement buy = $("form button");
    private static SelenideElement finalMessage = $(".notification__content");
    private static SelenideElement underLineMessage = $(byText("Неверный формат"));
    private static SelenideElement expiredCardUnderlineMessage = $(byText("Неверно указан срок действия карты"));


    public void buyClick() {
        buy.click();
    }

    public void putCardNumber(String cardNumber) {
        card.setValue(cardNumber);
    }

    public void putMonth(String valueMonth) {
        month.setValue(valueMonth);
    }

    public void putYear(String valueYear) {
        year.setValue(valueYear);
    }

    public void putCVV(String valueCVV) {
        cvv.setValue(valueCVV);
    }

    public void putOwner(String valueOwner) {

        owner.setValue(valueOwner);
    }


    public void shouldCompareMonth() {
        month.shouldHave(Condition.attribute("value", "12"));

    }
    public void shouldCompareMonthEmpty() {
        month.shouldHave(Condition.attribute("value", ""));
    }

    public void shouldCompareCard() {
        card.shouldHave(Condition.attribute("value", ""));
    }

    public void shouldCompareCardExtraLong() {
        card.shouldHave(Condition.attribute("value", "4444 4444 4444 4444"));

    }


    public void findSuccessContent() {

        finalMessage.shouldBe(visible, Duration.ofMinutes(1)).shouldHave(exactText("Успешно. Операция одобрена банком"));
    }

    public void findFailMessage() {
        finalMessage.shouldBe(visible, Duration.ofMinutes(1)).shouldHave(exactText("Ошибка! Банк отказал в проведении операции"));
    }

    public void wrongFormatMessage() {
        underLineMessage.shouldBe(visible);

    }

    public void findExpiredCardMessage() {
        expiredCardUnderlineMessage.shouldBe(visible, Duration.ofMinutes(1)).shouldHave(exactText("Неверно указан срок действия карты"));
    }
}