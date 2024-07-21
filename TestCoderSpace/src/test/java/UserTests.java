import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;


public class UserTests extends BaseTest {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test(description = "Başarılı Login Kullanıcı Girişi Kontrol")
    public void loginSuccesful() throws InterruptedException {
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();


        sleep(5000);
        homePage.ozetKontrol();
    }

    @Test(description = "Hatalı şifre girişi kontrol")
    public void notValidLogin() throws InterruptedException {
        loginPage
                .emailDoldur(email)
                .passwordDoldur("dsfsf12")
                .loginTikla();
        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);
    }

    @Test(description = "Hatalı E-mail girişi")
    public void notValidEmail() throws InterruptedException {
        loginPage
                .emailDoldur("harlemglobetrott7854ers7@gmail.com")
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);
    }

    @Test(description = "Boş veri girişi kontrol")
    public void requiredBlankControl() throws InterruptedException {
        loginPage
                .emailDoldur("")
                .passwordDoldur("")
                .loginTikla();

        sleep(5000);
        loginPage.bosHataMesajiKontrolu(bosHataMesaji)
                .emailDoldur(email)
                .loginTikla()
                .bosHataMesajiKontrolu("")
                .passwordDoldur(password)
                .loginTikla();

        sleep(5000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        homePage.ozetKontrol();
    }

    @Test(description = "minimum kontrol")
    public void minControl() throws InterruptedException {
        loginPage
                .emailDoldur("1")
                .passwordDoldur( "2")
                .loginTikla();
        sleep(5000);
        loginPage
                .bosHataMesajiKontrolu("Geçerli bir e-posta adresi girin. ")
                .emailDoldur("mail@gmail.com")
                .passwordDoldur("2")
                .loginTikla();
        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);
    }

    @Test(description = "maksimum kontrol")
    public void maxControl() throws InterruptedException {
        loginPage
                .emailDoldur("aaaaaaaaaaaaaaa11aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com")
                .passwordDoldur(password)
                .loginTikla();

        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);

        sleep(3000);
        loginPage
                .emailTemizle()
                .passwordTemizle()
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();

        sleep(5000);
        homePage.ozetKontrol();
    }

    @Test(description = "logo kontrol")
    public void logoControl(){
        loginPage.logoKontrol();
    }

    @Test(description = "kamera ikonu sayfada görünüp görünmediği kontrolü")
    public void camIconControl() throws InterruptedException{
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        homePage.kameraIkonKontrol();
    }


}
