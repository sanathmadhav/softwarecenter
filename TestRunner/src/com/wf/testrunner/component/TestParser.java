/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.component;

import java.io.File;
import org.jsoup.select.Elements;

/**
 *
 * @author U523344
 */
public abstract class TestParser {
    
    private String filePath;

    protected void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public abstract File loadTest(final String filepath);
    
    public abstract Elements getTestRootElement(final File file);
    
    public abstract TestComponent getTestComponents(final Elements elements);
    
    public abstract void processTest(final TestComponent testComponent);
    
    public static TestParser getParser(String filePath) {
        return new TestParserImpl(filePath);
    }
    
    public void performTest() {
        final File file = this.loadTest(this.filePath);
        final Elements elements = this.getTestRootElement(file);
        final TestComponent testComponent = getTestComponents(elements);
        this.processTest(testComponent);
    }
    
    
}
