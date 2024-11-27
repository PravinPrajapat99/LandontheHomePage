package service;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginService {
    public void getloginPage(WebDriver driver) {
        driver.get("https://karthikyelisetti-pvm-1.vaultpvm.com/auth/login?retURL=https%3A%2F%2Fkarthikyelisetti-pvm-1.vaultpvm.com%2Fui%2F");
    }

    public void enterUsernamePassword(String user, String pass, WebDriver driver) throws InterruptedException {
        WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username"))).sendKeys(user);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.name("continue"))).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_password"))).sendKeys(pass);
    }

    public void clickLogin(WebDriver driver) {
        driver.findElement(By.xpath("//form[@method='POST']//button[@type='submit']")).click();
    }

    public void checkIfNavigated(WebDriver driver) {
        Assert.assertEquals("check if landed on home page", "Veeva Vault - Login", driver.getTitle());
    }


}
