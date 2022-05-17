package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.AutomationObjects;
import org.openqa.selenium.WebDriver;

public class SelectSeatPage extends BaseClass {
    protected WebDriver browser;
    private String message;

    public SelectSeatPage(WebDriver driver) {
        super(driver);
        browser = Hook.getDriver();
    }
    public void SelectSeat() throws Throwable{
        message = "Se seleccionan los asientos";
        try{

            click(browser, AutomationObjects.ASIENTO_1);
            click(browser,AutomationObjects.ASIENTO_2);
            waitToBeClickable(browser,AutomationObjects.CONFIRMAR_ASIENTOS,5);
            click(browser,AutomationObjects.CONFIRMAR_ASIENTOS);
            stepPass(browser, message);
            generateWord.sendText(message);
            addImageReport(browser,message);
            generateWord.addImageToWord(browser);
        }
        catch (Exception we){
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
        waitToBeClickable(browser,AutomationObjects.TARIFA,10);
    }

    public void SelectPrice() throws Throwable{
        message = "Se elige la tarifa";
        try{
            click(browser,AutomationObjects.TARIFA);
            click(browser,AutomationObjects.TARIFA);
            generateWord.addImageToWord(browser);
            click(browser,AutomationObjects.CONFIRMAR_COMPRA);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
        }
        catch(Exception we){
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
        waitVisibleElement(browser,AutomationObjects.COMBO,10);
    }

}
