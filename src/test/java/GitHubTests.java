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
    void textTest()
    {
        open("https://github.com/");

        $("[placeholder ='Search GitHub']").setValue("Selenide").pressEnter();
        $$("ul.repo-list").first().$("a").click();
        $("#wiki-tab").click();
        $("li.wiki-more-pages-link").$("[type=button]").click();
        $(byText("SoftAssertions")).click();
        $x("//pre[.//span[contains(text(), \"@ExtendWith({SoftAssertsExtension.class})\\n\" +\n" +
                "                        \"class Tests {\\n\" +\n" +
                "                        \"  @Test\\n\" +\n" +
                "                        \"  void test() {\\n\" +\n" +
                "                        \"    Configuration.assertionMode = SOFT;\\n\" +\n" +
                "                        \"    open(\\\"page.html\\\");\\n\" +\n" +
                "                        \"\\n\" +\n" +
                "                        \"    $(\\\"#first\\\").should(visible).click();\\n\" +\n" +
                "                        \"    $(\\\"#second\\\").should(visible).click();\\n\" +\n" +
                "                        \"  }\\n\" +\n" +
                "                        \"}\")]]");
        sleep(5000);
    }
}