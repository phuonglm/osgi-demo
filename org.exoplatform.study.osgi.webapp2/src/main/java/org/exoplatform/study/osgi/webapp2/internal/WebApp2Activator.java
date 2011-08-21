package org.exoplatform.study.osgi.webapp2.internal;

import org.exoplatform.study.osgi.component.common.NormalClass;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Extension of the default OSGi bundle activator
 */
public final class WebApp2Activator implements BundleActivator{
    ExampleServiceTracker exampleServiceTracker;
    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext context ) throws Exception{
        NormalClass.info = "set in WebApp2 Activator";
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

