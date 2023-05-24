package ru.netology.test;

import ru.netology.data.DataHelper;
import ru.netology.sql.SqlQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.pageobject.DashboardPage;

import java.util.function.ToDoubleBiFunction;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTourWithCreditTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

//1
    @Test
    @DisplayName("ShouldSuccessfulBuyWthValidCard")
    void shouldSuccessfulBuyTourWithCredit(){
        var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
        buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        buyTourWithCreditPage.putYear(DataHelper.generateYear());
        buyTourWithCreditPage.buyClick();
        buyTourWithCreditPage.findSuccessContent();
    }




    //SQL
   // @Test
    //@DisplayName("CheckStatusInDB")
    //void shouldSuccessfulBuyTourByCard() {
        //var buyTourWithCreditPage = new DashboardPage().clickBuyWithCreditButton();
        //SqlQuery.clearDB();
        //buyTourWithCreditPage.putCardNumber(DataHelper.getActiveCardNumber());
       // buyTourWithCreditPage.putOwner(DataHelper.generateFullName());
        //buyTourWithCreditPage.putCVV(DataHelper.generateCVV());
        //buyTourWithCreditPage.putMonth(DataHelper.generateMonth());
        //buyTourWithCreditPage.putYear(DataHelper.generateYear());
        //buyTourWithCreditPage.buyClick();
        //String res = SqlQuery.getCreditPaymentStatus();
       // assertEquals("approved", res);    }
}
