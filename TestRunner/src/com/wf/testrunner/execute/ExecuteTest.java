/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.testrunner.execute;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import org.junit.runner.JUnitCore;

/**
 *
 * @author U523344
 */
public class ExecuteTest {

    public static void main(String srg[]) throws Exception {
        /*JavaCompiler comp = ToolProvider.getSystemJavaCompiler();
         int status = comp.run(null, null, null, "C:/Users/U523344/Desktop/Demo.java");
         System.out.print(status);
         */

        File file = new File("C:/Users/U523344/Documents/NetBeansProjects/TestRunner/build/classes/com/wf/testrunner/execute");

        //convert the file to URL format
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        //load this folder into Class loader
        ClassLoader cl = new URLClassLoader(urls);

        //load the Address class in 'c:\\other_classes\\'
        Class cls = cl.loadClass("com.wf.testrunner.execute.Demo");

        //print the location from where this class was loaded
        ProtectionDomain pDomain = cls.getProtectionDomain();
        CodeSource cSource = pDomain.getCodeSource();
        URL urlfrom = cSource.getLocation();
        System.out.println(urlfrom.getFile());
        JUnitCore.runClasses(cls);


        /* MyClassLoader loader = new MyClassLoader(ToolProvider.getSystemToolClassLoader());
         Class<?> junitTest = loader.loadClass("C:/Users/U523344/Desktop/Demo.class");
         //Class.forName("com.example.tests.Demo", false, classLoader);
         JUnitCore.runClasses(junitTest);
         */
    }

    public void execute() {
        try {
            File file = new File("C:/Users/U523344/Documents/NetBeansProjects/TestRunner/build/classes/com/wf/testrunner/execute");

            //convert the file to URL format
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};

            //load this folder into Class loader
            ClassLoader cl = new URLClassLoader(urls);

            //load the Address class in 'c:\\other_classes\\'
            Class cls = cl.loadClass("com.wf.testrunner.execute.Demo");

            //print the location from where this class was loaded
            ProtectionDomain pDomain = cls.getProtectionDomain();
            CodeSource cSource = pDomain.getCodeSource();
            URL urlfrom = cSource.getLocation();
            System.out.println(urlfrom.getFile());
            JUnitCore.runClasses(cls);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}