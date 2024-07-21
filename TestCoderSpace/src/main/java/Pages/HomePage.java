package Pages;

import Base.BaseLibrary;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BaseLibrary {
    public HomePage ozetKontrol(){
        String value = driver.findElement(By.cssSelector("[class='col-12 col-xl-4 profile-menu-wrapper'] span")).getText(); // Özet buton isim kontrolu
        Assert.assertEquals("Özet", value);
        return this;
    }

    public HomePage kameraIkonKontrol(){
        String value = String.valueOf(driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div[1]/div/div[1]/span")).isDisplayed());
        Assert.assertEquals("true",value);
        return this;
    }

}
