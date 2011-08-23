package org.exoplatform.study.osgi.component2.internal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

/**
 * Internal implementation of our example OSGi service
 */
public final class Component2HttpServletServiceFactory implements ServiceFactory<HttpServlet> {


	@Override
	public HttpServlet getService(Bundle bundle, ServiceRegistration registration) {
		// TODO Auto-generated method stub
		return new Component2HttpServletServiceImpl();
	}

	@Override
	public void ungetService(Bundle bundle, ServiceRegistration registration,
			HttpServlet service) {
		// TODO Auto-generated method stub
		
	}
}
