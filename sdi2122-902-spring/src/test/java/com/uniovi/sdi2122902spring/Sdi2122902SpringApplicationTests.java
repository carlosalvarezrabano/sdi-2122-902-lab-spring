package com.uniovi.sdi2122902spring;

import com.uniovi.sdi2122902spring.pageobjects.PO_HomeView;
import com.uniovi.sdi2122902spring.pageobjects.PO_Properties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Sdi2122902SpringApplicationTests {

    static String PathFirefox="C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    static String Geckodriver="C:\\Users\\carlo\\Downloads\\PL-SDI-Sesión5-material\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";

    static WebDriver driver=getDriver(PathFirefox, Geckodriver);
    static String URL="http://localhost:8090";

    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    @BeforeEach
    public void setUp() {
        driver.navigate().to(URL);
    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    @BeforeAll
    static public void begin() {

    }

    @AfterAll
    static public void end() {
        driver.quit();
    }

    @Test
    @Order(1)
    void PR01A() {
        PO_HomeView.checkWelcomeToPage(driver, PO_Properties.getSPANISH());
    }

    @Test
    @Order(2)
    void PR01B() {
        List<WebElement> welcomeMessageElement = PO_HomeView.getWelcomeMessageText(driver,
                PO_Properties.getSPANISH());
        Assertions.assertEquals(welcomeMessageElement.get(0).getText(),
                PO_HomeView.getP().getString("welcome.message", PO_Properties.getSPANISH()));
    }

    @Test
    @Order(3)
    void PR02() {
        PO_HomeView.clickOption(driver,"signup","class","btn btn-primary");
    }

    @Test
    @Order(4)
    void PR03() {
        PO_HomeView.clickOption(driver,"login","class","btn btn-primary");
    }

    @Test
    @Order(5)
    void PR04() {
        PO_HomeView.checkChangeLanguage(driver,"btnSpanish","btnEnglish",
                PO_Properties.getSPANISH(), PO_Properties.getENGLISH());
    }

}
