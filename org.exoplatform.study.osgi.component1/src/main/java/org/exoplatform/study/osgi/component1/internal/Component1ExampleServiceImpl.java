package org.exoplatform.study.osgi.component1.internal;

import org.exoplatform.study.osgi.component.common.ExampleService;



/**
 * Internal implementation of our example OSGi service
 */
public final class Component1ExampleServiceImpl
    extends ExampleService{
    private static final String NAME = "Component 1";

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

