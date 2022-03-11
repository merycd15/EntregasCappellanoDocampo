import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SeleniumTestLaptop {
    //Seteo variable url con la dirección a la que quiero que navegue
    private String url = PropertiesFile.getProperty("url_base");
    //Seteo de Webdriver
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    public void NavigateToDemoblaze() throws InterruptedException {
        //Dirección a la que quiero que navegue
        driver.navigate().to(url);
        //Para poner el driver maximizado
        driver.manage().window().maximize();
        //Para comparar la dirección en la que está con la que quiero que esté
        assertEquals("https://www.demoblaze.com/index.html", driver.getCurrentUrl());
        //Le agrego un wait para darle tiempo a cargar el sitio
        //WebElement laptops = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops")));
        WebElement laptops = driver.findElement(By.linkText("Laptops"));
        //Una vez que carga el sitio, le doy click al elemento indicado
        laptops.click();
        //Le agrego un wait para darle tiempo a cargar el sitio
        //WebElement primerProductoSonyVaio = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.linkText("Sony vaio i5")));
        WebElement primerProductoSonyVaio = driver.findElement(By.linkText("Sony vaio i5"));
        //Muestro en consola para verificar que se carga bien
        System.out.println(primerProductoSonyVaio.getText());
        //Evalúo que el nombre es el correcto
        assertEquals(primerProductoSonyVaio.getText(),"Sony vaio i5");
        //Obtengo el nombre del primer producto
        //String nombrePrimerProduct = driver.findElement(By.linkText("Sony vaio i5")).getText();
        //Muestro en consola para verificar que se carga bien
        //System.out.println(primerProductoSonyVaio);

        //Doy tiempo a cargar la página
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Obtengo el precio del primer producto
//        String precioVaio = driver.findElement(By.xpath("//div[@id='tbodyid']//div[1]//div[1]//div[1]//h5[1]")).getText();
        String precioVaio = driver.findElement(By.xpath("(//h5[contains(text(),'$790')])[1]")).getText();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tbodyid']//div[1]//div[1]//div[1]//h5[1]")));
        //Muestro en consola para verificar que se carga bien
        System.out.println(precioVaio);
        //Evalúo que el precio es el correcto
        assertEquals(precioVaio,"$790");

        //Doy tiempo a cargar la página
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Una vez que carga el sitio, le doy click al elemento indicado
        primerProductoSonyVaio.click();

        //Le agrego un wait para darle tiempo a cargar el sitio
        WebElement primerProductoSonyVaioAddToCart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart")));
        //Una vez que carga el sitio, le doy click al elemento indicado
        primerProductoSonyVaioAddToCart.click();
        //Le agrego un wait para darle tiempo a cargar el sitio
        WebElement verCart = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        //Una vez que carga el sitio, le doy click al elemento indicado
        verCart.click();

        //Cierro el navegador
        driver. quit();
    }


}
