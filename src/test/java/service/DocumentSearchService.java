package service;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentSearchService {
    String docName=null;
    public void chkUserIsOnHome(WebDriver driver) {
        System.out.println(driver.getTitle());
    }

    public void verifyUser(WebDriver driver) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
       String user =driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='side-nav-home-user-section']//div//div//div[2]"))).getText();
        Assert.assertEquals("check valid user","admin QAEF-AppControl-VF.com",user);
    }

    public void navigateToLibrary(WebDriver driver) {
        driver.findElement(By.xpath("//nav[@class='vv-navbar']//ul//li[3]/a")).click();
    }

    public WebElement getSearchBar(WebDriver driver) {
        return driver.findElement(By.id("search_main_box"));
    }

    public void enterDocument(WebElement theSearchBar, WebDriver driver, String docName) {
        this.docName=docName;
        theSearchBar.sendKeys(docName);
    }

    public void click(WebDriver driver) {
        driver.findElement(By.id("search_main_button")).click();
    }

    public void checkIfDocumentAvailable(WebDriver driver) {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        String DocName=null;
        try {
             DocName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"doc_6\"]/div/div[3]/div/div[2]/div[1]/a/span"))).getText();
            boolean present=false;
            if(DocName.contains(this.docName)){
                present=true;
            }
            Assert.assertTrue(present);
            System.out.println(docName+" Doc found");
        }catch (Exception e){
            System.out.println("Document not found");
        }

    }
}
