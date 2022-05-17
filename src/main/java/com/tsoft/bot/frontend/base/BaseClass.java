package com.tsoft.bot.frontend.base;

import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.exceptions.FrontEndException;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import com.tsoft.bot.frontend.utility.Sleeper;
import com.tsoft.bot.frontend.objects.ExcelDataObjects;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;


public class BaseClass {

    protected static GenerateWord generateWord = new GenerateWord();
    private static final int SLEEP_IN_MIL = 200;
    protected List<HashMap<String, String>> getDataForSignIn() throws Throwable {
        return ExcelReader.data(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE);
    }
    protected List<HashMap<String, String>> getDataForMovie() throws Throwable {
        return ExcelReader.data(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.PELICULA_PAGE);
    }

    public BaseClass(WebDriver driver){
    }

    protected void click(WebDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).click();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    public String getText(WebElement element){
        return element.getText();
    }

    protected void selectItem(WebDriver driver, By locator , String obj) throws IOException {

        try {
         Select selectList = new Select(driver.findElement(locator));
         selectList.selectByIndex(Integer.parseInt(obj));

          }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }
       protected void clear(WebDriver driver, By locator) throws IOException {
        try {
            driver.findElement(locator).clear();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected void typeText(WebDriver driver, By locator, String inputText) throws IOException {
        try {
            driver.findElement(locator).sendKeys(inputText);
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected Boolean isDisplayed(WebDriver driver, By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException we){
            driver.close();
            return false;
        }
    }

    protected void selectByVisibleText(WebDriver driver, By locator, String text) throws IOException {
        try {
            Select typeSelect = new Select(driver.findElement(locator));
            typeSelect.selectByVisibleText(text);
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    public static Exception handleError(WebDriver driver, String codigo, String msg) throws Throwable {
        stepWarning(driver, msg);
        return new FrontEndException(StringUtils.trimToEmpty(codigo), msg);
    }

    protected static void sleep(int milisegundos) {

        Sleeper.sleep(milisegundos);
    }

    protected static void stepPass(WebDriver driver, String descripcion) {
        try {
            ExtentReportUtil.INSTANCE.stepPass(driver, descripcion);
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-StepPass: " + t);
            throw t;
        } catch (Exception e) {
            Logger.getLogger("[LOG]-StepPass: " + e);
        }
    }

    private static void stepWarning(WebDriver driver, String descripcion) throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepWarning(driver, descripcion);
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-StepWarning: " + t);
            throw t;
        }
    }

    protected void stepFail(WebDriver driver, String descripcion) throws Exception {
        try {
            ExtentReportUtil.INSTANCE.stepFail(driver, descripcion);
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-StepFail: " + t);
            throw t;
        }
    }

    public static void stepFailNoShoot(String descripcion) {
        try {
            ExtentReportUtil.INSTANCE.stepFailNoShoot(descripcion);
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-StepFailNoShoot: " + t);
            throw t;
        }
    }

    public static void scroll(WebDriver driver, int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-Scroll: " + t);
            throw t;
        }
    }

    public static void zoom(WebDriver driver, int size) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom = '" + size + "%'");
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-zoom: " + t);
            throw t;
        }
    }

    protected void errorNoElementFound(WebDriver driver, By locator) throws IOException {
        Serenity.recordReportData().withTitle("Error").andContents("- No se encontró el elemento : " + locator);
        generateWord.sendText("Error : No se encontró el elemento : " + locator);
        generateWord.addImageToWord(driver);
        driver.close();
    }

    /* has been adding more methods*/
    protected void addImageReport(WebDriver driver,String title)
    {
        try
        {
            Serenity.recordReportData().withTitle(title).downloadable().fromFile(ScreenShotClass.takeScreenShoot(driver));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    protected void  waitToBeClickable(WebDriver driver, By locator, int time) throws WebDriverException{
        try {

            WebDriverWait wait = new WebDriverWait(driver, time, SLEEP_IN_MIL);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-zoom: " + t);
            throw t;
        }
    }

    protected void waitVisibleElement(WebDriver driver, By locator, int time)throws WebDriverException{
        try{
            WebDriverWait wait = new WebDriverWait(driver, time, SLEEP_IN_MIL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (RuntimeException t){
            Logger.getLogger("[LOG]-zoom: " + t);
            throw t;
        }
    }





}