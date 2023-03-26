package AmazonTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		String SearchItem = "samsung mobile";

		WebElement searchTextBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchTextBox.sendKeys(SearchItem);

		WebElement searchButton = driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		searchButton.click();

		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));

		List<WebElement> priceSymbol = driver
				.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		List<WebElement> priceList = driver
				.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));

		for (int i = 0; i < productList.size(); i++) {

			System.out.println("Product: " + productList.get(i).getText());
			System.out.println("Currency: " + priceSymbol.get(i).getText());
			System.out.println("Price: " + priceList.get(i).getText());

		}
	}

}
