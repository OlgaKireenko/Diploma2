package ru.netology.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BuyTourWithCreditPage {
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

    public void shouldCompare(String attributeName, String expectedAttributeValue) {
        month.shouldHave(Condition.attribute(attributeName, expectedAttributeValue));
    }


    public void findSuccessContent() {

        finalMessage.shouldBe(visible, Duration.ofMinutes(1)).shouldHave(exactText("Операция одобрена Банком."));
    }

    public void findFailMessage() {
        finalMessage.shouldBe(visible, Duration.ofMinutes(1)).shouldHave(exactText("Ошибка! Банк отказал в проведении операции"));
    }

    public void wrongFormatMessage() {
        underLineMessage.shouldBe(visible);
    }

    public void findExpiredCardMessage() {
        expiredCardUnderlineMessage.shouldBe(visible);
    }
}

