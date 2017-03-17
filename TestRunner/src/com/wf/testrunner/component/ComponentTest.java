/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.component;

/**
 *
 * @author U523344
 */
public class ComponentTest {
    
    public static void main(String args[]) {
      String filePath = "C:/Users/U523344/Desktop/App.html";
      ComponentTest testProcessor = new ComponentTest();
      testProcessor.process(filePath);
    }

    private void process(String filePath) {
        TestParser parser = TestParser.getParser(filePath);
        parser.performTest();
    }
    
    
}
