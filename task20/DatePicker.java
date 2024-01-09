package task20;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {

		// Storing the String variable

		String date = "22";

		String month = "February";

		// Chrome Driver is implemented using WebDriver

		WebDriver driver = new ChromeDriver();

		// Window is maximized

		driver.manage().window().maximize();

		// navigate to the Url

		driver.get("https://jqueryui.com/datepicker/");

		// Switching to iframe

		driver.switchTo().frame(0);

		// Selecting the datepicker box

		WebElement dateBox = driver.findElement(By.id("datepicker"));

		dateBox.click();

		// While loop to check the variable month not equals the selecting month

		while (!(month.equals(

				// locating January month
				driver.findElement(
						By.xpath("(//div[contains(@class,'ui-datepicker-header')]//child::div//child::span)[1]"))
						.getText()))) {

			// Locating the Feburary month and selecting it.
			driver.findElement(By.xpath("(//a[@title='Next']//child::span)[1]")).click();

		}

		// locating the date element by td

		List<WebElement> dateTag = driver.findElements(By.tagName("td"));

		// foreach loop is used
		for (WebElement pickDate : dateTag) {

			// to check the variable stored in string and selected date
			if (pickDate.getText().equals(date)) {

				// Picking the date
				pickDate.click();

				break;
			}

		}

		//Printing the date in console
		
		String selectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
		
		System.out.println(selectedDate);
		
		
		// Close the browser
		
		driver.close();

		driver.quit();

	}

}

//Output:02/22/2024

