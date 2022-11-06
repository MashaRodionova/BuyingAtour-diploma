package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LandingPage {

    private SelenideElement buttonBuy = $x(".//span[text()='Купить']");
    private SelenideElement buttonBuyByCredit = $x(".//span[text()='Купить в кредит']");
    private SelenideElement headingPaymentCard = $x(".//h3[text() = 'Оплата по карте']");
    private SelenideElement fieldCardNumber = $x(".//fieldset/div[1]//span//input");
    private SelenideElement fieldMonth = $x(".//fieldset/div[2]/span/span[1]//input");
    private SelenideElement fieldYear = $x(".//fieldset/div[2]/span/span[2]//input");
    private SelenideElement fieldCardHolder = $x(".//fieldset/div[3]/span/span[1]//input");
    private SelenideElement fieldCVC = $x(".//fieldset/div[3]/span/span[2]//input");
    private SelenideElement buttonContinue = $x(".//span[text() = 'Продолжить']");
    private SelenideElement notificationError = $("div.notification_status_error div.notification__content");
    private SelenideElement notificationOk = $("div.notification_status_ok div.notification__content");

    public void buyByCardWithValidInfo(){
        buttonBuy.click();
        headingPaymentCard.shouldHave(Condition.exactText("Оплата по карте"));
        DataHelper.CardInfo cardInfo = new DataHelper().getValidCardInfo();
        fieldCardNumber.setValue(cardInfo.getNumber());
        fieldMonth.setValue(cardInfo.getMonth());
        fieldYear.setValue(cardInfo.getYear());
        fieldCardHolder.setValue(cardInfo.getCardHolder());
        fieldCVC.setValue(cardInfo.getCvc());
        buttonContinue.click();
    }

    public void buyByCardWithInvalidInfo(){
        buttonBuy.click();
        headingPaymentCard.shouldHave(Condition.exactText("Оплата по карте"));
        DataHelper.CardInfo cardInfo = new DataHelper().getInvalidCardInfo();
        fieldCardNumber.setValue(cardInfo.getNumber());
        fieldMonth.setValue(cardInfo.getMonth());
        fieldYear.setValue(cardInfo.getYear());
        fieldCardHolder.setValue(cardInfo.getCardHolder());
        fieldCVC.setValue(cardInfo.getCvc());
        buttonContinue.click();
    }

    public void findNotificationError(String expectedText){
        notificationError.shouldHave(Condition.exactText(expectedText), Duration.ofSeconds(10));
    }

    public void findNotificationOk(String expectedText){
        notificationOk.shouldHave(Condition.exactText(expectedText), Duration.ofSeconds(10));
    }

}
