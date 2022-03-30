package amlerok;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.*;


public class HomeWork1 {

    @BeforeAll
    void beforeAll() {
        browserSize=("1920x1080");
    }


    @BeforeEach
    void precondition() {
        open("https://go.mail.ru/");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @ValueSource(strings = {"Selenide","JUnit 5"})
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в майле для запроса \"{0}\"")
    void commonSearchTest(String testData) {
      $(".DesktopInput-preWrappedWhiteSpace").setValue(testData);
      $("button[type='submit']").click();
      $$("li.result__li").find(text(testData)).shouldBe(visible);
    }

    @CsvSource({
            "Selenide, concise UI tests in Java",
            "JUnit 5, [Udemy]"
    })
    @ParameterizedTest(name = "Проверка отображения поисковых результатов в майле для запроса \"{0}\"")
    void commonSearchTest(String testData, String expectedText) {
      $(".DesktopInput-preWrappedWhiteSpace").setValue(testData);
      $("button[type='submit']").click();
      $$("li.result__li").find(text(expectedText)).shouldBe(visible);
    }

    static Stream<Arguments> mixedArgumentsMegaSuperStarTest() {
return Stream.of(
        Arguments.of("Selenide", List.of(2,3,4), true),
        Arguments.of("JUnit 5",  List.of(5,8,9), false)
       );
    }

    @MethodSource(value = "mixedArgumentsMegaSuperStarTest")
    @ParameterizedTest(name = "Name {2}")
    void mixedArgumentsTest(String firstArg, List<Integer> secondArg, boolean aBooleanValue) {
         System.out.println(("String:" + firstArg + "list:" + secondArg.toString() + "boolean:" + aBooleanValue));
    }
}
