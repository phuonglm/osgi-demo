package org.exoplatform.study.osgi.webapp1.internal;

import java.util.LinkedList;

import org.exoplatform.study.osgi.component.common.ExampleService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class ExampleServiceTracker extends ServiceTracker {
    public static LinkedList<ExampleService> exampleServices = new LinkedList<ExampleService>();
    
    public ExampleServiceTracker(BundleContext context) {
        super(context, ExampleService.class.getName(), null);
    }
    
    public Object addingService(ServiceReference reference) {
        ExampleService exampleService = (ExampleService) context.getService(reference);
        System.out.println("WebApp1 got new ExampleService (" + exampleService.getName() + "). Going add it to list");
        exampleServices.add(exampleService);
        return context.getService(reference);
    }
    
    public void removedService(ServiceReference reference, Object service) {
        System.out.println("WebApp1 got ExampleService (" + ((ExampleService)service).getName() + ") be removed. Going remove it to list");
        exampleServices.remove(service);
        context.ungetService(reference);
    }
}
