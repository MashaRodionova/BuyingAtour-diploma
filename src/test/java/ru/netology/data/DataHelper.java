package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

public class DataHelper {

    private static Faker faker = new Faker(Locale.forLanguageTag("ru"));

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CardInfo{
        private String number;
        private String month;
        private String year;
        private String cardHolder;
        private String cvc;

    }

    public CardInfo getValidCardInfo(){
        return new CardInfo("4444444444444441", "11", "23", "Masha", "777");
    }


    public CardInfo getInvalidCardInfo(){
        return new CardInfo("4444444444444440", "11", "23", "Masha", "777");
    }
}
