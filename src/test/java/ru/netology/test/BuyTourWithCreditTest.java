package ru.netology.test;

import ru.netology.sql.SqlQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.pageobject.DashboardPage;

import java.util.function.ToDoubleBiFunction;

import static com.codeborne.selenide.Selenide.open;

public class BuyTourWithCreditTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    //1
    @Test
    @DisplayName("CheckStatusInDB")
    void shouldSuccessfulBuyTourByCard() {
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        SqlQuery.clearDB();
        String res = SqlQuery.getDebitPaymentStatus();
        //TO DO: сделать сравнение        assertEquals (res; "APPROVED")
        //buyTourWithCreditPage.
    }


}
