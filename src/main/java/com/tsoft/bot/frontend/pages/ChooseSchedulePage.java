package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.AutomationObjects;
import org.openqa.selenium.WebDriver;

public class ChooseSchedulePage extends BaseClass {
    protected WebDriver browser;
    private String message;

    public ChooseSchedulePage(WebDriver driver) {
        super(driver);
        browser = Hook.getDriver();
    }
    public void ChooseSchedule() throws Throwable{
        message = "Se escoge el horario de la función";
        try {

            click(browser,AutomationObjects.DESPLEGAR);
            waitToBeClickable(browser,AutomationObjects.ESCOGER_HORARIO,5);
            click(browser,AutomationObjects.ESCOGER_HORARIO);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            addImageReport(browser,message);
        }

        catch (Exception we){
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
        waitVisibleElement(browser,AutomationObjects.BUTACAS_SELECCION,10);
    }
}
