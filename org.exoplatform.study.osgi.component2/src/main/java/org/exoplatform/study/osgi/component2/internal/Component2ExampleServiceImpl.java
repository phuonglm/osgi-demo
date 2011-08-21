package org.exoplatform.study.osgi.component2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.exoplatform.study.osgi.component.common.ExampleService;



/**
 * Internal implementation of our example OSGi service
 */
public final class Component2ExampleServiceImpl
    extends ExampleService{
    private static final String NAME = "Component 2";

    @Override
    public String sayHello() {
        String text = "Hello from" + NAME;
        System.out.println(text);
        return text;
    }

    @Override
    public String getName() {
        return NAME;
    }   
}

