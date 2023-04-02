package ru.netology.data;
import lombok.Value;

import static com.codeborne.selenide.Selenide.$;

public class DataHelper {

    //TO DO: Может здесь написать методы?
    public static int getValidMonth(){
    return (12);
    }
    public static int getNotValidMonth(){
    return (24);
    }
    public static int getTreeSymbols(){
        return (122);
    }
    public static int getOneSymbolMonth(){
        return (1);

    }
    public static String getTreeLetters(){
        return ("FFF");
    }
   public static String getActiveCardNumber()
   { return ("4444 4444 4444 4441");
     }

     public static String getNonActiveCardNumber(){
         return ("4444 4444 4444 4442");
     }

     public static int getValidYear(){
        return (23);
     }
     public static int getValidCVV(){
        return  (202);
     }
     public static String getValidSurname(){
        return ("Ivanov");
     }
}






