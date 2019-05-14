package Extent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Button {
@Test
public void m1() throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")	;
		ExtentHtmlReporter html=new ExtentHtmlReporter(new File("C:\\Users\\admin\\Desktop\\Navya\\test1.html"));
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Test yantra");
		html.config().setReportName("Regression test suite");
		
		ExtentReports ex=new ExtentReports();
		ex.attachReporter(html);
		ex.setSystemInfo("Enivornment", "Test");
		ex.setSystemInfo("Eng_name", "navya");
		ex.setSystemInfo("Build_no", "1.2");
		ex.setSystemInfo("platform", "window 10");
		ExtentTest test=ex.createTest("Homepage");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		WebElement un = driver.findElement(By.xpath("//div[text()='Login ']"));
//		un.click();
		int x1 = un.getLocation().getX();
		int y1 = un.getLocation().getY();
		int h1 = un.getSize().getHeight();
		int w1 = un.getSize().getWidth();
	BufferedImage img=ImageIO.read(src);
	BufferedImage drsc = img.getSubimage(x1, y1, h1, w1+70);
		ImageIO.write(drsc, "png", src);
		File f = new File("D:\\Monday\\Selenium\\screen\\selenium2.png");
FileUtils.copyFile(src, f);
	}

}
