package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittograh {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chittorgarh.com/");
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<String> securitynamelist = new ArrayList<String>();
		WebElement table2 = driver
				.findElement(By.xpath("//div//table[@class='table table-bordered table-condensed table -striped']"));
		List<WebElement> rowvalues = table2.findElements(By.xpath("//tr"));
		for (int i = 1; i <= rowvalues.size() - 1; i++) {
			WebElement findElement = rowvalues.get(i).findElement(By.xpath("//th[" + i + "]"));
			if (findElement.getText().equals("Security Name")) {
				for (int j = 1; j <= rowvalues.size() - i; j++) {
					String securitynameval = table2.findElement(By.xpath("//tr[" + j + "]")).getText();
					securitynamelist.add(securitynameval);

				}
				System.out.println(securitynamelist);
				Set<String> targetSet = new TreeSet<String>(securitynamelist);
				System.out.println(targetSet);
				if (targetSet.size() < securitynamelist.size()) {
					System.out.println("The List contains duplicate security names");
				}
				break;
			}

		}
		driver.close();

	}
}
