/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.exception;

/**
 *
 * @author U523344
 */
public class TestRunnerException extends RuntimeException {
    
    public TestRunnerException(String message) {
        super(message);
    }
    
    public TestRunnerException(Throwable throwable,String message) {
        super(message, throwable);
    }
            
}
