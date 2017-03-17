/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.execute;

/**
 *
 * @author U523344
 */
public class TestEvent {
    
    private BrowserEvents event;
    private String eventSource;
    private String conditionStmt;

    public BrowserEvents getEvent() {
        return event;
    }

    public void setEvent(BrowserEvents event) {
        this.event = event;
    }

    public String getConditionStmt() {
        return conditionStmt;
    }

    public void setConditionStmt(String conditionStmt) {
        this.conditionStmt = conditionStmt;
    }
}
