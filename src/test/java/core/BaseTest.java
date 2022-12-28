package core;

import base.LoginBase;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

public class BaseTest {
    protected BasePage basePage = new BasePage();


    @Rule
    public TestName testName = new TestName();


    @Before
    public void iniciar(){
        getDriver().get("https://seubarriga.wcaquino.me/login");
    }

    @After
    public void fechar() throws IOException {
        TakesScreenshot screen = (TakesScreenshot) getDriver();
        File arquivo =screen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "sreenshot" + File.separator  + testName.getMethodName() + ".jpg"));
        if (Propriedades.FECHAR_BROWSER)
            killDriver();
    }
}
