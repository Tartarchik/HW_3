import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void selenideTest()
    {
        open("https://github.com/");

        $("[placeholder ='Search GitHub']").setValue("Selenide").pressEnter();
        $$("ul.repo-list").first().$("a").click();
        $("#wiki-tab").click();
        $("li.wiki-more-pages-link").$("[type=button]").click();
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        sleep(5000);
    }
}
