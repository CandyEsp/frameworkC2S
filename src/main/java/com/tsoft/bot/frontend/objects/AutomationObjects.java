package com.tsoft.bot.frontend.objects;

import org.openqa.selenium.By;

public class AutomationObjects {
    private AutomationObjects() {
    }
    //Validaciones
    public static final By TITULO_FUNCION=By.xpath("//span[contains(text(),'La función perfecta para ti.')]");
    public static final By PRECIO_FINAL=By.xpath("//div[@class='cart-desktop--balance']/div");
    public static final By BUTACAS_SELECCION=By.xpath("//div[@class=\"purchase-seating--content-selected-seats-indicator-label\"]");


    //Sign in
    public static final By TXT_SOCIO = By.name("cineplanet-code");
    public static final By TXT_PSWRD = By.name("password");
    public static final By BTN_SIGNIN = By.cssSelector("button[type=\"submit\"]");

    //Home page
    public static final By CONTINUAR_HOME = By.xpath("//button/span[contains(text(),'Continuar')]");
    public static final By BUTTON_INICIAR_SESION = By.cssSelector("a[href='/autenticacion/login']");

    //Select Cine
    public static final By PELICULA= By.xpath("//div[1]/select[@class='dropdown--select']");
    public static final By CIUDAD= By.xpath("//div[2]/select[@class='dropdown--select']");
    public static final By CINE= By.xpath("//div[3]/select[@class='dropdown--select']");
    public static final By FECHA= By.xpath("//div[4]/select[@class='dropdown--select']");
    public static final By FILTRAR= By.xpath("//span[contains(text(),'Filtrar')]");

    //Select Function
    public static final By DESPLEGAR= By.xpath("//span[@class='icon cineplanet-icon cineplanet-icon_more cineplanet-icon_18 cinema-showcases--summary-toggle-icon']");
    public static final By ESCOGER_HORARIO= By.xpath("//div[starts-with(@class, 'showtime-selector sessions-details--session-item')][1]/div/button");

    //Select Sitting
    public static final By ASIENTO_1=By.xpath("//table[@class='seat-map--table']/tbody/tr[5]/td[24]");
    public static final By ASIENTO_2=By.xpath("//table[@class='seat-map--table']/tbody/tr[5]/td[25]");
    public static final By CONFIRMAR_ASIENTOS=By.xpath("//button[starts-with(@class,'button call-to-action submit-button--button')]");

    //Select Price
    public static final By TARIFA=By.xpath("//div[1][@class='purchase-tickets--common-tickets']/div[2]/div[2]/div[2]/div/div[2]");
    public static final By CONFIRMAR_COMPRA= By.xpath("//div[@class=\"purchase-tickets-indicator-container\"]/div[2]/div/button");
    public static final By ACEPTAR_TERMINOS=By.xpath("//span[contains(text(),\"Aceptar\")]");
    public static final By COMBO= By.xpath("//div[1][starts-with(@class, 'candy-store-list-item candy-store-list-item')]/div[3]/div[1]/div/div[2]");
    public static final By CONFIRMAR_COMBO=By.xpath("//div[@class=\"candy-store--continue-button-center-container\"]/div/button");

    //Cancelar Compra
    public static final By CANCELAR=By.xpath("//div[2]/button");
    public static final By CANCELAR_COMPRA=By.xpath("//div[@class='alert--container']/div[2]/button[1]");







}