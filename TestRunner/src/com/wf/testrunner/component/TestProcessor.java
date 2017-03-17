/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.component;

import com.wf.testrunner.exception.TestRunnerException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author U523344
 */
public class TestProcessor implements ProcessorLifeCycle {
    
    private WebDriver driver = null;
    private TestComponent testComponent = null;

    public TestProcessor(String baseURL, TestComponent testComponent, String browserType) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/U523344/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        this.testComponent = testComponent;
    }
    
    public void process() {
        this.initWebDriver();
        this.processInstruction();
        this.cleanUp();
    }
       
    @Override
    public void initWebDriver() {
        driver.get("https://localhost.wellsfargo.com:15321/getting_started?product_code=PCM&subproduct_code=UNSLN");
    }

    @Override
    public void processInstruction() {
        List<BaseComponent> baseComponentList = this.testComponent.getBaseComponents();
        
        for (BaseComponent baseComponent : baseComponentList) {
            String selector = "id"; 
            String event = baseComponent.getEvent();
            String element = baseComponent.getElement();
            if(element.indexOf("=") > -1) {
                String[] selectAndElement = element.split("=");
                if("id".equals(selectAndElement[0])) {
                    element = selectAndElement[1];
                }else if("css".equals(selectAndElement[0])) {
                    element = selectAndElement[1];
                    selector = "css";
                } else {
                    continue;
                }
            }
            String data = baseComponent.getData();
            this.processMircoInstructions(event, element, data, selector);
        }
    }

    @Override
    public void cleanUp() {
        driver = null;
    }

    private void processMircoInstructions(String event, String element, String data, String selector) {
        WebElement webElement = null;
        try {
           
            switch(event) {
                case "click":
                if("id".equals(selector)){
                    webElement = driver.findElement(By.id(element));
                } else if("css".equals(selector)) {
                    //if(element.contains("button."))
                    webElement = driver.findElement(By.cssSelector(element));
                }
                if(webElement != null) {
                    Thread.currentThread().sleep(100);
                    this.performClickOperation(webElement);
                }
                break;
            case "type":
                webElement = driver.findElement(By.id(element));
                if(webElement != null) {
                    Thread.currentThread().sleep(100);
                    this.performTextTypeOperation(webElement, data);
                }
                break;
            case "select":
                webElement = driver.findElement(By.id(element));
                if(webElement != null) {
                    Thread.currentThread().sleep(100);
                    this.performSelectOperation(webElement, data);
                }
                break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //throw new TestRunnerException(ex, "processMircoInstructions : " + element);
        }
    }

    private void performClickOperation(WebElement webElement) {
        try{
         if(webElement != null){
            System.out.print("\n\nNot null" + webElement.getTagName());
            //if(webElement.isEnabled())
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement);
            actions.click().release().build().perform();
        } else {
         System.out.print("\n\n\n Is null");
        }
        }catch (Exception e) {
            throw new TestRunnerException(e, "performClickOperation :" + e.getMessage());
        }
    }

    private void performTextTypeOperation(WebElement webElement, String data) {
        try{
         if(webElement != null){
            webElement.sendKeys(data);
        } else {
         System.out.print("\n\n\n Is null");
        }
        }catch (Exception e) {
            throw new TestRunnerException(e, "performTextTypeOperation :" + e.getMessage());
        }
    }

    private void performSelectOperation(WebElement webElement, String data) {
        try{
         if(webElement != null){
            Select dropdown = new Select(webElement);
            dropdown.selectByVisibleText(data);
        } else {
         System.out.print("\n\n\n Is null");
        }
        }catch (Exception e) {
            throw new TestRunnerException(e, "performSelectOperation :" + e.getMessage());
        }
    }
    
}
