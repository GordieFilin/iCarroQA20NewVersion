package starttesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    WebDriver driver;
    //   RandomUtils randomUtils = new RandomUtils();

    @BeforeClass
    public void preconditions(){
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }




    public void registrationPositive(){
        String email = "hfhdj@mm.com";

        //  String email = randomUtils.generateEmail(7);
        System.out.println(email);

       driver.findElement(By.xpath("//a[contains(@href, '/registration')]")).click();

       WebElement inputName = driver.findElement(By.xpath("//input[@id ='name']"));
       inputName.click();
       inputName.clear();
       inputName.sendKeys("abc");

       WebElement inputName2 = driver.findElement(By.xpath("//input[@id ='lastName']"));
       inputName2.click();
       inputName2.clear();
       inputName2.sendKeys("abcd");


        WebElement inputEmail = driver.findElement(By.xpath("//input[@id ='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id ='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("123456Aa!");

        // checkbox

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#terms-of-use').click();");



        //////

        driver.findElement(By.xpath("//button[@type ='submit']")).click();


        WebElement textMessagePopUPh1 =driver.findElement(By.xpath("//div[@class='dialog-container']//h1[@class='title']"));
        String TextMessageH1 = textMessagePopUPh1.getText().trim().toUpperCase();
        String expectedResult ="REGISTERED";

        System.out.println(TextMessageH1);

        Assert.assertEquals(TextMessageH1,expectedResult);





    }



    @AfterClass
    public void postConditions(){
        driver.quit();
    }
}
