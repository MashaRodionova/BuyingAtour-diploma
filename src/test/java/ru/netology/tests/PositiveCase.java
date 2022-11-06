package ru.netology.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.LandingPage;

import static com.codeborne.selenide.Selenide.open;

public class PositiveCase {
    @BeforeEach
    void setup() {
        open("http://localhost:8080/");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void shouldApprovedPurchaseByCard() {
        LandingPage landingPage = new LandingPage();
        landingPage.buyByCardWithValidInfo();
        landingPage.findNotificationOk("Операция одобрена Банком.");

    }

    @Test
    public void shouldDeclinedPurchaseByCard() {
        LandingPage landingPage = new LandingPage();
        landingPage.buyByCardWithInvalidInfo();
        landingPage.findNotificationError("Ошибка! Банк отказал в проведении операции.");
    }
}
