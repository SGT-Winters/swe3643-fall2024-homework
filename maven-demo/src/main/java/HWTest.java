import com.microsoft.playwright.Locator;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

@UsePlaywright
public class HWTest {
    @Test
    void test(Page page) {
        page.navigate("https://demo.playwright.dev/todomvc/#/");
        page.getByPlaceholder("What needs to be done?").click();
        page.getByPlaceholder("What needs to be done?").fill("Working");
        page.getByPlaceholder("What needs to be done?").press("Enter");
        page.getByPlaceholder("What needs to be done?").fill("Eating");
        page.getByPlaceholder("What needs to be done?").press("Enter");
        page.getByPlaceholder("What needs to be done?").fill("Completeing Homework 3");
        page.getByPlaceholder("What needs to be done?").press("Enter");
        page.locator("li").filter(new Locator.FilterOptions().setHasText("Eating")).getByLabel("Toggle Todo").check();
        page.locator("li").filter(new Locator.FilterOptions().setHasText("Completeing Homework")).getByLabel("Toggle Todo").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear completed")).click();
        page.getByLabel("Toggle Todo").check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear completed")).click();
    }
}