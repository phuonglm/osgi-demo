package org.exoplatform.study.osgi.component1.internal;

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
public final class Component1HttpServletServiceImpl extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7001892381422799327L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello, From servlet in component 1 </TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Hello, From servlet in component 1<br/>");
		out.println("My classLoader is: " + this.getClass().getClassLoader().toString() );
		out.println("</BODY></HTML>");
	}
}
