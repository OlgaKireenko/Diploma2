package ru.netology.data;
import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Data_Helper {

    private static int month;
    //private int year;
    //private String owner;
    //private int cvv;

    //TO DO: Может здесь написать методы?
    public static int getValidMonth(){
    return (12);
    }
    public static int getNotValidMonth(){
    return (24);
    }
    public static int getTreeSymbolsMonth(){
        return (122);
    }
    public static int getOneSymbolMonth(){
        return (1);

    }
    public static String getTreeLetters(){
        return ("FFF");
    }

    @Value
    public static class CardNumber {
        private String number;

        public static CardNumber getActiveCardNumber() {
            return new CardNumber("4444 4444 4444 4441");
        }

        public static CardNumber getNonActiveCardNumber() {
            return new CardNumber("4444 4444 4444 4442");
        }
    }
}



   // @Value

//public static Month getValidMonth (){        return new Month(12);}

//}


