package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelDataObjects;
import org.openqa.selenium.WebDriver;

public class SelectMoviePage extends BaseClass {
    protected WebDriver browser;
    private String message;

    public SelectMoviePage(WebDriver driver) {
        super(driver);
        browser = Hook.getDriver();
    }
    public void selectmovie(Integer ncase) throws Throwable {
        message = "Se selecciona la película y la sede del cine";
        scroll(browser, 0, 500);

        try{
            String pelicula = getDataForMovie().get(ncase -1).get(ExcelDataObjects.COLUMN_PELICULA);
            String ciudad = getDataForMovie().get(ncase -1).get(ExcelDataObjects.COLUMN_CIUDAD);
            String cine = getDataForMovie().get(ncase -1).get(ExcelDataObjects.COLUMN_CINE);
            String fecha = getDataForMovie().get(ncase -1).get(ExcelDataObjects.COLUMN_FECHA);

            waitToBeClickable(browser, AutomationObjects.PELICULA,5);
            selectItem(browser, AutomationObjects.PELICULA,pelicula);
            waitToBeClickable(browser,AutomationObjects.CIUDAD,5);
            selectItem(browser, AutomationObjects.CIUDAD,ciudad);
            waitToBeClickable(browser,AutomationObjects.CINE,5);
            selectItem(browser, AutomationObjects.CINE,cine);
            waitToBeClickable(browser,AutomationObjects.FECHA,5);
            selectItem(browser, AutomationObjects.FECHA,fecha);

            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            addImageReport(browser,message);
            click(browser,AutomationObjects.FILTRAR);

        }
        catch (Exception we){
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
        waitVisibleElement(browser,AutomationObjects.DESPLEGAR,10);
    }


}
