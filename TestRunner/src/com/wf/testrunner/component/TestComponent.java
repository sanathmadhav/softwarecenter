/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author U523344
 */
public class TestComponent {
    
    private List<BaseComponent>  baseComponentList = null;
    
    void addComponent(BaseComponent baseComponent) {
        this.initList();
        baseComponentList.add(baseComponent);
    }

    public List<BaseComponent> getBaseComponents() {
        return baseComponentList;
    }

    void add(String event, String element, String data) {
        this.initList();
        baseComponentList.add(new BaseComponent(event, element, data));
    }

    private void initList() {
        if(!Optional.ofNullable(baseComponentList).isPresent()) {
            baseComponentList = new ArrayList<>();
        }
        
    }
    
}
