/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.component;

/**
 *
 * @author U523344
 */
public interface ProcessorLifeCycle {
    
    void initWebDriver();
    void processInstruction();
    void cleanUp();
}
