package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintTableValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://html.com/tags/table/");
		List<WebElement> rowelement = driver.findElements(By.xpath("//table)[1]//tr"));
		int rowcount = rowelement.size();
		System.out.println(rowcount);
		System.out.println(rowelement.get(0).getText());
		System.out.println("-----------------------------------");
		System.out.println(rowelement.get(1).getText());
		driver.close();
	}

}
