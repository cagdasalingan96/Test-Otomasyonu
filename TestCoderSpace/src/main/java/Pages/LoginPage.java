package Pages;

import Base.BaseLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BaseLibrary {
    public LoginPage emailDoldur(String email){
        driver.findElement(By.name("login")).sendKeys(email);
        return this;
    }

    public LoginPage passwordDoldur(String password){
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public LoginPage loginTikla(){
        driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[1]/form/div[3]/button")).submit();
        return this;
    }

    public LoginPage hataMesajiKontrolu(String text){
        String value = driver.findElement(By.cssSelector("[class='alert alert-danger']")).getText();
        Assert.assertEquals(text, value);
        return this;
    }

    public LoginPage bosHataMesajiKontrolu( String text){
        String value = driver.findElement(By.cssSelector("[class='invalid-feedback']")).getText();
        Assert.assertEquals(text, value);
        return this;
    }

    public LoginPage emailTemizle(){
        driver.findElement(By.name("login")).clear();
        return this;
    }

    public LoginPage passwordTemizle(){
        driver.findElement(By.name("password")).clear();
        return this;
    }

    public LoginPage logoKontrol(){
        driver.findElement(By.xpath("//img[@class='header-logo-black']")).click();
        return this;
    }
}
