package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataHelper {
    public static String generateMonth() {

        return LocalDate.now().plusMonths(3).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generatePreviousYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateSysdateYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateSysdateYearPlusTen() {
        return LocalDate.now().plusYears(10).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateSysdateYearMinusThree(){

        return LocalDate.now().minusYears(3).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generatePreviousMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getNotValidMonth() {
        return ("24");
    }

    public static String getTreeSymbols() {
        return ("122");
    }

    public static String getOneSymbolMonth() {
        return ("1");
    }

    public static String getTreeLetters() {
        return ("FFF");
    }

    public static String getActiveCardNumber() {
        return ("4444 4444 4444 4441");
    }

    public static String getNonActiveCardNumber() {
        return ("4444 4444 4444 4442");
    }

    public static String generateCVV() {
        Faker faker = new Faker();
        return faker.number().digits(3);
    }

    //TO DO: имя генерировать по другому
    public static String generateFullName() {
        Faker faker = new Faker(new Locale("eng"));
        String surname = faker.name().fullName();
        return surname;
    }

    public static String generateExtraLongFullName() {
       String surname = "Ivaaaaaaaaaaaaaaaaaaaaaaaaan Ivaaaaaaaaaaaaaaaaaaaaaaaaaaaaanov";
        return surname;
    }
    public static String generateCyrillicSymbolsFullName() {
        String surname = "Иван Иванов";
        return surname;
    }

    public static String generateExtraShortFullName() {
        String surname = "I I";
        return surname;
    }

    public static String getExtraLongCardNumber() {
        return ("4444 4444 4444 44444444");
    }

    public static String getSpecSymbols() {
        return ("!!$&&");
    }
}






