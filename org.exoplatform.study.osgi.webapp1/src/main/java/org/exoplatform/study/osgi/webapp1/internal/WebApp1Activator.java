package org.exoplatform.study.osgi.webapp1.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.exoplatform.study.osgi.component.common.ExampleService;
import org.exoplatform.study.osgi.component.common.NormalClass;
import org.exoplatform.study.osgi.webapp1.Webapp1Service;

/**
 * Extension of the default OSGi bundle activator
 */
public final class WebApp1Activator
    implements BundleActivator
{
    ExampleServiceTracker exampleServiceTracker;
    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext context ) throws Exception {
        NormalClass.info = "set in WebApp1 Activator";
        exampleServiceTracker = new ExampleServiceTracker(context);
        exampleServiceTracker.open();
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop( BundleContext context )throws Exception{
        exampleServiceTracker.close();
    }
}

