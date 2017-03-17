/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.component;

/**
 *
 * @author U523344
 */
public class BaseComponent {

    public void setEvent(String event) {
        this.event = event;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEvent() {
        return event;
    }

    public String getElement() {
        return element;
    }

    public String getData() {
        return data;
    }
    private String event;
    private String element;
    private String data;

    public BaseComponent(String event, String element, String data) {
        this.event = event;
        this.element = element;
        this.data = data;
    }

    @Override
    public String toString() {
        return "\nEvent:" + this.event + "\nElement:"+ this.element +"\ndata:"+this.data;
    }
}
