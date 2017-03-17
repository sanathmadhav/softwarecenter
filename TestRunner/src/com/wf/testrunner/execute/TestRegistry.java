/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.execute;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author U523344
 */
public class TestRegistry<TestEvent> {

    private List<TestEvent> testExceFlow = null;

    public void addEvent() throws EventException {
        if(testExceFlow == null) {
            testExceFlow = new LinkedList<TestEvent>();
        }
    }
}
