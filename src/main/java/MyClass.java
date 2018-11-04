import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(GenerateReport.class)
public class MyClass extends Settings {

    @Test
    public void testSample () throws Exception {

        driver.get("https://crm.zoho.com/");

        waitForElement(driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")), 5);
        takeScreenshot("1");
        driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")).click();

        waitForElement(driver.findElement(By.id("lid")), 5).clear();
        Assert.assertTrue(driver.findElement(By.id("lid")).isDisplayed());
        driver.findElement(By.id("lid")).sendKeys("anna@blondie.lv");

        Assert.assertTrue(driver.findElement(By.id("pwd")).isDisplayed());
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("AnnaBlondie!");


        takeScreenshot("2");

        Assert.assertTrue(driver.findElement(By.id("signin_submit")).isDisplayed());
        driver.findElement(By.id("signin_submit")).click();


        waitForElement(driver.findElement(By.xpath("//a[contains(text(),'Leads')]")),10);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).isDisplayed());

        takeScreenshot("3");

        driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();


        waitForElement(driver.findElement(By.xpath("//button[@data-zcqa='cv_createbtn']")), 10);
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-zcqa='cv_createbtn']")).isDisplayed());
        takeScreenshot("4");

        driver.findElement(By.xpath("//button[@data-zcqa='cv_createbtn']")).click();

        waitForElement(driver.findElement(By.id("Crm_Leads_FIRSTNAME")), 10).clear();
        Assert.assertTrue(driver.findElement(By.id("Crm_Leads_FIRSTNAME")).isDisplayed());
        driver.findElement(By.id("Crm_Leads_FIRSTNAME")).sendKeys("Anna");

        Assert.assertTrue(driver.findElement(By.id("Crm_Leads_LASTNAME")).isDisplayed());
        driver.findElement(By.id("Crm_Leads_LASTNAME")).sendKeys("Blondie");

        Assert.assertTrue(driver.findElement(By.id("Crm_Leads_COMPANY")).isDisplayed());
        driver.findElement(By.id("Crm_Leads_COMPANY")).sendKeys("Blondie's company");

        takeScreenshot("5");

        Assert.assertTrue(driver.findElement(By.id("saveLeadsBtn")).isDisplayed());
        driver.findElement(By.id("saveLeadsBtn")).click();


        waitForElement(driver.findElement(By.xpath("(//a[@id='backArrowDV']/span)[2]")), 10).click();

        waitForElement(driver.findElement(By.xpath("//a[contains(text(),'Anna Blondie')]")),10);

        takeScreenshot("6");

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Anna Blondie')]")).isDisplayed());

    }

}