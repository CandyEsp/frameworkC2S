package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelDataObjects;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {
    protected WebDriver browser;
    private String message;

    public LoginPage(WebDriver driver) {
        super(driver);
        browser = Hook.getDriver();
    }
    public void signIn(Integer ncase) throws Throwable {
        message = "Se inicia sesión en la pagina " + this.browser.getTitle();
        try
        {
            String username = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_USER);
            String password = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_PASWWORD);
            waitToBeClickable(browser,AutomationObjects.BTN_SIGNIN,5);

            clear(browser,AutomationObjects.TXT_SOCIO);
            typeText(browser,AutomationObjects.TXT_SOCIO,username);
            clear(browser,AutomationObjects.TXT_PSWRD);
            typeText(browser,AutomationObjects.TXT_PSWRD,password);
            click(browser, AutomationObjects.BTN_SIGNIN);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            addImageReport(browser,message);

        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
        waitVisibleElement(browser,AutomationObjects.CONTINUAR_HOME,10);
        click(browser,AutomationObjects.CONTINUAR_HOME);
    }
}
