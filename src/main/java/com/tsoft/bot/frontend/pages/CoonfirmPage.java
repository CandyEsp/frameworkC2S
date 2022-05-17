package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelDataObjects;
import org.openqa.selenium.WebDriver;

public class CoonfirmPage extends BaseClass {
    protected WebDriver browser;
    private String message;

    public CoonfirmPage(WebDriver driver) {
        super(driver);
        browser = Hook.getDriver();
    }
    public void SelectCombo() throws Throwable{
        message = "Se elige el combo";
        try{
            click(browser, AutomationObjects.COMBO);
            generateWord.addImageToWord(browser);
            click(browser,AutomationObjects.CONFIRMAR_COMBO);
            stepPass(browser, message);
            generateWord.sendText(message);
            addImageReport(browser,message);
            generateWord.addImageToWord(browser);
        }
        catch(Exception we){
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
        waitVisibleElement(browser,AutomationObjects.CANCELAR,10);
    }
    public void ObtenerMonto() throws Throwable{
        try{
            String monto = browser.findElement(AutomationObjects.PRECIO_FINAL).getText();
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PELICULA_PAGE, 1, ExcelDataObjects.COLUMN_MONTO,monto.substring(9,monto.length()));

        }
        catch (Exception we){
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PELICULA_PAGE, 1, 7, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void Cancelar() throws Throwable{
        message = "Se cancela la compra";
        try{
            click(browser,AutomationObjects.CANCELAR);
            generateWord.addImageToWord(browser);
            waitVisibleElement(browser,AutomationObjects.CANCELAR_COMPRA,10);
            click(browser,AutomationObjects.CANCELAR_COMPRA);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            addImageReport(browser,message);
        }
        catch(Exception we){
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

}
