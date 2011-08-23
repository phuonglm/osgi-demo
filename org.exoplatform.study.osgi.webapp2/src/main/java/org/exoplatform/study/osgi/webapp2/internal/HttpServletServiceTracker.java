package org.exoplatform.study.osgi.webapp2.internal;

import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.util.tracker.ServiceTracker;

public class HttpServletServiceTracker extends ServiceTracker {
    public static LinkedList<String> urls = new LinkedList<String>();

    public HttpServletServiceTracker(BundleContext context) {
        super(context, HttpServlet.class.getName(), null);
    }
    
    public Object addingService(ServiceReference reference) {
    	String url = (String) reference.getProperty("url");
    	String prefix = this.context.getBundle().getHeaders().get("Web-ContextPath");
    	if(url !=null && !url.isEmpty()){
    		HttpServlet HttpServletService = (HttpServlet) context.getService(reference);
    		
	        registerHttpServlet(HttpServletService, prefix  + url);
	        System.out.println("WebApp2 got new HttpServlet with url (" + url + "). Going add it to list");
    	}
        return context.getService(reference);
    }
    
    public void removedService(ServiceReference reference, Object service) {
    	String url = (String) reference.getProperty("url");
        System.out.println("WebApp2 got HttpServlet (" + url + ") be removed. Going remove it to list");
        unRegisterHttpServlet(this.context.getBundle().getHeaders().get("Web-ContextPath") + url);
        context.ungetService(reference);
    }
    
    private void registerHttpServlet(HttpServlet servlet, String url){
    	ServiceReference<HttpService> reference = (ServiceReference<HttpService>) this.context.getServiceReference(HttpService.class.getName());
    	if(reference !=null){
    		HttpService httpService =  this.context.getService(reference);
    		try {
				httpService.registerServlet(url, servlet, null, null);
				urls.add(url);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamespaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    private void unRegisterHttpServlet(String url){
    	ServiceReference<HttpService> reference = (ServiceReference<HttpService>) this.context.getServiceReference(HttpService.class.getName());
    	if(reference !=null){
    		HttpService httpService =  this.context.getService(reference);
			httpService.unregister(url);
			urls.remove(url);
    	}
    }    
}
