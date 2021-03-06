import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SeleniumTestLaptop {
    //Seteo variable url con la dirección a la que quiero que navegue
    private String url = PropertiesFile.getProperty("url_base");
    //Seteo de Webdriver
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void NavigateToDemoblaze(){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Dirección a la que quiero que navegue
        driver.navigate().to(url);
        //Para poner el driver maximizado
        driver.manage().window().maximize();
        //Para comparar la dirección en la que está con la que quiero que esté
        assertEquals("https://www.demoblaze.com/index.html", driver.getCurrentUrl());
        //Le agrego un wait para darle tiempo a cargar el sitio
        WebElement laptops = driver.findElement(By.linkText("Laptops"));
        //Una vez que carga el sitio, le doy click al elemento indicado
        laptops.click();

        //Una vez que carga el sitio, le doy click al elemento indicado
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sony vaio i5"))).click();


        //Le agrego un wait para darle tiempo a cargar el sitio
        String primerProductoSonyVaio = driver.findElement(By.cssSelector("h2.name")).getText();
        //Evalúo que el nombre es el correcto
        assertEquals(primerProductoSonyVaio,"Sony vaio i5");

        //Obtengo el precio del primer producto
        String precioVaio = driver.findElement(By.cssSelector("h3.price-container")).getText();
        //Muestro en consola para verificar que se carga bien
        System.out.println(precioVaio);
        //Evalúo que el precio es el correcto
        assertEquals(precioVaio,"$790 *includes tax");


        //Le agrego un wait para darle tiempo a cargar el sitio
        WebElement primerProductoSonyVaioAddToCart = driver.findElement(By.linkText("Add to cart"));
        //Una vez que carga el sitio, le doy click al elemento indicado
        primerProductoSonyVaioAddToCart.click();
        //Le agrego un wait para darle tiempo a cargar el sitio
        WebElement verCart = driver.findElement(By.id("cartur"));
        //Una vez que carga el sitio, le doy click al elemento indicado
        verCart.click();

        //Cierro el navegador
        driver. quit();
    }


}
