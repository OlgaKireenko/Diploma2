package ru.netology.data;
import lombok.Value;

public class Data_Helper {
    private Data_Helper() {
    }
    @Value
    public static class CardNumber {
        private String number;
    }

    public static CardNumber getFirstCardNumber() {
        return new CardNumber("4444 4444 4444 4441");
    }

    public static CardNumber getSecondCardNumber() {

        return new CardNumber("4444 4444 4444 4442");
    }


}
