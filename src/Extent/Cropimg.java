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


public class Cropimg {

	@Test

	public void main() throws IOException  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")	;
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		WebElement w = driver.findElement(By.xpath("//td[@id='logoContainer']"));
	int x = w.getLocation().getX();
		int y = w.getLocation().getY();
		int h = w.getSize().getHeight();
		int width = w.getSize().getWidth();
		BufferedImage img=ImageIO.read(src);
		BufferedImage des = img.getSubimage(x, y, h, width);
		ImageIO.write(des, "png", src);
		File dsrc=new File("D:\\Monday\\Selenium\\screen\\selenium.png");
		FileUtils.copyFile(src, dsrc);
		

	}

}
