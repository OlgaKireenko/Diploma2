package ru.netology.data;
import lombok.Value;

public class Data_Helper {
    private Data_Helper() {
    }
    @Value
    public static class CardNumber {
        private String number;
    }

    public static CardNumber getActiveCardNumber() {
        return new CardNumber("4444 4444 4444 4441");
    }

    public static CardNumber getNonActiveCardNumber() { return new CardNumber("4444 4444 4444 4442");
    }

    @Value
    public static class Month{
        private int month;
    }
public static Month getValidMonth (){
        return new Month(12);
}

}
