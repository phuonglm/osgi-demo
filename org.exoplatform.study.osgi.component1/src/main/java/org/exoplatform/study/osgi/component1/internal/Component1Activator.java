package org.exoplatform.study.osgi.component1.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.exoplatform.study.osgi.component.common.ExampleService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Extension of the default OSGi bundle activator
 */
public final class Component1Activator implements BundleActivator{
    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext context ) throws Exception{
        System.out.println( "STARTING org.exoplatform.study.osgi.component1" );

        Dictionary props = new Properties();
        // add specific service properties here...

        System.out.println( "REGISTER org.exoplatform.study.osgi.component1.ExampleService" );

        // Register our example service implementation in the OSGi service registry
        context.registerService( ExampleService.class.getName(), new Component1ExampleServiceImpl(), props );
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop( BundleContext context ) throws Exception {
        System.out.println( "STOPPING org.exoplatform.study.osgi.component1" );
    }
}

