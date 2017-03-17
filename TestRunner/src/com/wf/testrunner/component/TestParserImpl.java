/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.component;

import com.wf.testrunner.exception.TestRunnerException;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author U523344
 */
public class TestParserImpl extends TestParser {
    
    public TestParserImpl(String filePath) {
        this.setFilePath(filePath);
    }
    
    @Override
    public File loadTest(final String filepath) {
        final File file = new File(filepath);
        return file;
    }

    @Override
    public Elements getTestRootElement(final File file) {
        Document document = null;
        Elements elements = null;
        try {
            document = Jsoup.parse(file, "UTF-8");
            elements = document.getElementsByTag("tr");
        } catch (IOException ex) {
            document = null;
            throw new TestRunnerException(ex, TestParserImpl.class.getName());
        }
        return elements;
    }

    @Override
    public TestComponent getTestComponents(final Elements elements) {
        if(Optional.ofNullable(elements).isPresent() && elements.size() > 0) {
            final TestComponent component = new TestComponent();
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                Elements childElements = element.getElementsByTag("td");
                if(childElements.size() > 2) {
                    component.add(childElements.get(0).text(), childElements.get(1).text(),childElements.get(2).text());
                }
            }
            return component;
        } else {
            throw new TestRunnerException("Invalid test file..");
        }
    }

    @Override
    public void processTest(final TestComponent testComponent) {
        System.out.print(testComponent.getBaseComponents());
        TestProcessor processor = new TestProcessor(null, testComponent, "Chrome");
        processor.process();
    }
}
