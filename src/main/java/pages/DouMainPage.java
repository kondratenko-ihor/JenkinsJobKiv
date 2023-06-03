package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class DouMainPage {
    private static String URL = "https://dou.ua";

    public static ElementsCollection headerElements = $$(".b-head ul li");


    public static void openDou() {
        open(URL);
    }

    public static void assertHeaderElements() {
        for (SelenideElement element : headerElements) {
            element.shouldBe(visible);
        }
    }
}
