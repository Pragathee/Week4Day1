package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableCount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://html.com/tags/table/");
		int tablecount = driver.findElements(By.xpath("//table)")).size();
		System.out.println("Total Number of tables is " + tablecount);
		System.out.println("------------------------------------");
		for (int i = 1; i <= tablecount; i++) {
			int table1rowcount = driver.findElements(By.xpath("//table)[" + i + "]//tr")).size();
			System.out.println("The Total rows in the table is" + i + "is " + table1rowcount);
			int table1colcount = driver.findElements(By.xpath("//table)[" + i + "]//th")).size();
			System.out.println("The Total column in the table is" + i + "is " + table1colcount);
		}
		driver.close();
	}

}
