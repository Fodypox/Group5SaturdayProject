package Group5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HasanLanguagePageAssignment extends UtilityClass {
    public static void main(String[] args) {
        /**As a user, I should be able to click on “My Languages” button , then I should be navigated to the “My Languages” pages
         1- Once you are in My Account page
         2- Click on “My Languages” button

         1- User should be able to be navigated to My Languages Page.
         2- User should validate the title of page is “My Languages*/

        driver.get("https://demo.openmrs.org/openmrs/login.htm");


        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin" + Keys.TAB + "Admin123" + Keys.ENTER);

        List<WebElement> locationsList = driver.findElements(By.cssSelector("#sessionLocation>li"));
        locationsList.get((int) (Math.random() * 6)).click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        WebElement adminButton = driver.findElement(By.cssSelector(".nav-item.identifier"));
        Actions actions = new Actions(driver);
        actions.moveToElement(adminButton).perform();
        WebElement myAccount = driver.findElement(By.partialLinkText("My Account"));
        myAccount.click();

        WebElement languages = driver.findElement(By.cssSelector(".task>.icon-cog"));
        languages.click();

        String title = driver.getTitle();

        if (driver.getTitle().equals(title)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

}
