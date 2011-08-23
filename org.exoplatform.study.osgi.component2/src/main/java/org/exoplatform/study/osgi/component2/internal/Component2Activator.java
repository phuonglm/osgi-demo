package org.exoplatform.study.osgi.component2.internal;

import java.util.Dictionary;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.exoplatform.study.osgi.component.common.ExampleService;
import org.exoplatform.study.osgi.component2.internal.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Extension of the default OSGi bundle activator
 */
public final class Component2Activator
    implements BundleActivator
{
    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext context ) throws Exception{
        System.out.println( "STARTING org.exoplatform.study.osgi.component2" );

        Dictionary props = new Properties();
        // add specific service properties here...

        System.out.println( "REGISTER org.exoplatform.study.osgi.component2.ExampleService" );

        // Register our example service implementation in the OSGi service registry
        context.registerService( ExampleService.class.getName(), new Component2ExampleServiceImpl(), props );
        
        Dictionary servletProps = new Properties();
        servletProps.put("url", "/Component2HttpServlet");
        
        context.registerService( HttpServlet.class.getName(), new Component2HttpServletServiceFactory(), servletProps );
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop( BundleContext context ) throws Exception{
        System.out.println( "STOPPING org.exoplatform.study.osgi.component2" );
    }
}

