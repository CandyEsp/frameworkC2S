package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelDataObjects;
import org.openqa.selenium.WebDriver;

public class HomeCinePage extends BaseClass {
    protected WebDriver browser;
    private String message;


    public HomeCinePage(WebDriver driver) {
        super(driver);
        browser = Hook.getDriver();
    }

    public void toSignIn(Integer ncase) throws Throwable {
        message = "Se ingresa a la página de inicio";
        try
        {
            String url = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_URL);
            this.browser.get(url);
            waitVisibleElement(browser,AutomationObjects.CONTINUAR_HOME, 5);
            click(browser, AutomationObjects.CONTINUAR_HOME);
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
        waitToBeClickable(browser,AutomationObjects.BUTTON_INICIAR_SESION,10);
        click(browser,AutomationObjects.BUTTON_INICIAR_SESION);
    }
}
