package steps;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.*;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BuyTicketsSteps {
    private WebDriver browser ;
    private HomeCinePage home = new HomeCinePage(browser);
    private LoginPage login = new LoginPage(browser);
    private SelectMoviePage movie = new SelectMoviePage(browser);
    private SelectSeatPage seat = new SelectSeatPage(browser);
    private ChooseSchedulePage choose = new ChooseSchedulePage(browser);
    private CoonfirmPage confirm = new CoonfirmPage(browser);

    public BuyTicketsSteps() throws IOException {
        this.browser = Hook.getDriver();
    }

    @Dado("que el usuario ingresa a la pagina principal del cine {int}")
    public void queElUsuarioIngresaALaPaginaPrincipalDelCineCaso(Integer testCase)throws Throwable  {
        home.toSignIn(testCase);
    }

    @Cuando("inicia sesion con sus usuario y constrasena {int}")
    public void iniciaSesionConSusUsuarioYConstrasenaCaso(Integer testCase)throws Throwable  {
        login.signIn(testCase);
    }

    @Y("selecciona la pelicula {int}")
    public void seleccionaLaPeliculaCaso(Integer testCase)throws Throwable  {
        movie.selectmovie(testCase);

    }

    @Entonces("elige el horario de su preferencia")
    public void eligeElHorarioDeSuPreferencia() throws Throwable {
        choose.ChooseSchedule();
    }

    @Y("selecciona los asientos de la funcion")
    public void seleccionaLosAsientosDeLaFuncion() throws Throwable {
        seat.SelectSeat();
        seat.SelectPrice();

    }

    @Entonces("confirma su compra")
    public void confirmaSuCompra() throws Throwable  {
        confirm.SelectCombo();
        confirm.ObtenerMonto();
        confirm.Cancelar();

    }
}
