package Activity;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity05 {

	WebDriver driver;

	@Test (groups = {"HeaderTests", "ButtonTests"})
    public void pageTitleTest() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }
    
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void HeaderTest1() {
        WebElement header3 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header3.getText(), "Third header");
    }
    
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void HeaderTest2() {
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgba(251, 189, 8, 1)");
    }
    
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void ButtonTest1() {
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }
    
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void ButtonTest2() {
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgba(255, 255, 255, 1)");
    }

	@BeforeClass
	public void beforeMethod() {

		FirefoxBinary firefoxBinary = new FirefoxBinary();
        	firefoxBinary.addCommandLineOptions("--headless");
        	FirefoxOptions firefoxOptions = new FirefoxOptions();
        	firefoxOptions.setBinary(firefoxBinary);
        	WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.get("https://www.training-support.net/selenium/target-practice");
		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}

}
