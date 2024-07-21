package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Data {


    @BeforeMethod
    public void setUp(){

        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://coderspace.io/giris");
    }
    @AfterMethod
    public  void tearDown(){
        driver.quit();
    }
}
