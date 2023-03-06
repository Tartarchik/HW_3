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
        $("#user-content-3-using-junit5-extend-test-class")
                .parent()
                .sibling(0)
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
        sleep(5000);
    }
}
