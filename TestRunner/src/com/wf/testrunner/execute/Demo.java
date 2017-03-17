package com.wf.testrunner.execute;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    public static void main(String [] args) throws Exception {
       Demo demo = new Demo();
       demo.setUp();
       demo.testDemo();
    }

  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:/Users/U523344/Desktop/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://localhost.wellsfargo.com:15321/getting_started?product_code=PCM&subproduct_code=UNSLN";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }


  public void testDemo()  {
      
  try{
    driver.get(baseUrl);
    //driver.findElement(By.id("wfCustomer_wfCustomer_true")).click();
    WebElement webElement = driver.findElement(By.id("wfCustomer_wfCustomer_true"));
    performClick(webElement);
    
    //driver.findElement(By.id("onlineBankingCustomer_onlineBankingCustomer_false")).click();
   WebElement webElement1 = driver.findElement(By.id("onlineBankingCustomer_onlineBankingCustomer_false"));
   //System.out.print("\n\n\nAAAAAAA ::"+  webElement1.getTagName());
    performClick(webElement1);
    
   // WebElement webElement2 = driver.findElement(By.xpath("//form[@id='gettingStartedCommand']/section/div[2]/div/fieldset/div/div/div[2]/label"));
   //System.out.print("\n\n\nAAAAAAA ::"+  webElement1.getTagName());
    //performClick(webElement2);
    

    
    
    driver.findElement(By.cssSelector("button.btn-p")).click();
    System.out.print("\n\n\nDDDD ::");
    //driver.findElement(By.id("hiddenLoginContinue")).click();
    System.out.print("\n\n\nBBBBB ::");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.findElement(By.id("isJointApplicant_false")).click();
        WebElement webElement3 = driver.findElement(By.id("isJointApplicant_false"));
        
  System.out.print("\n\n\nAAAAAAA ::"+  webElement3.getTagName());
    performClick(webElement3);
    //driver.findElement(By.cssSelector("span.RadioButton-radio-container-CFT-p.RadioButton-selected-1dAHv")).click();
    driver.findElement(By.id("primaryApplicantInfo_personalInfo_name_firstName")).clear();
    driver.findElement(By.id("primaryApplicantInfo_personalInfo_name_firstName")).sendKeys("Sanath");
    driver.findElement(By.id("primaryApplicantInfo_personalInfo_name_lastName")).clear();
    driver.findElement(By.id("primaryApplicantInfo_personalInfo_name_lastName")).sendKeys("Madhav");
  }
    catch (Exception e) {
        System.out.print(e);
    }
  }
  
 public void performClick(WebElement webElement) throws Exception {
     if(webElement != null){
       System.out.print("\n\nNot null" + webElement.getTagName());
       //if(webElement.isEnabled())
       Actions actions = new Actions(driver);
    actions.moveToElement(webElement);
    actions.click().release().build().perform();
    
    //actions.release(webElement);
        //webElement.click();
    } else {
         System.out.print("\n\n\n Is null");
     }
 }

  
}
