package ru.netology.test;
///import lombok.var;
import ru.netology.page_object.BuyTourPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data_Helper;

import static com.codeborne.selenide.Condition.text;
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
        $("button").shouldHave(text("Купить")).click();
        $("[placeholder='0000 0000 0000 0000']").setValue (String.valueOf(Data_Helper.getActiveCardNumber()));
         ///$(byText("Владелец")).setValue("FFFFFFFFF");
        $("[placeholder='08']").setValue(String.valueOf(Data_Helper.getValidMonth()));
        $("[placeholder='22']").setValue("25");
        $("[placeholder='999']").setValue("111");
        $(byText("Продолжить")).click();





        ///$(".notification__content").shouldHave(text("Неверно указан логин или пароль"))
        //$("").setValue("gg");


                //

///shouldHave(text("")) (String.valueOf(Data_Helper.getFirstCardNumber()))

    }
}
