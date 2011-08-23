<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.List" %>
<%@page import="org.exoplatform.study.osgi.dupdicate.test.DupdicateClass"%>
<%@page import="org.exoplatform.study.osgi.component.common.NormalClass"%>
<%@page import="org.exoplatform.study.osgi.webapp1.internal.ExampleServiceTracker"%>
<%@page import="org.exoplatform.study.osgi.webapp1.internal.HttpServletServiceTracker"%>
<%@ page import="org.exoplatform.study.osgi.component.common.ExampleService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>
<HEAD>
<TITLE>OSGi Test</TITLE>
<link rel="stylesheet" type="text/css" href="css/default.css" media="screen" />
<%
  List<ExampleService> exampleServices = ExampleServiceTracker.exampleServices;
  List<String> urls = HttpServletServiceTracker.urls;
%>
</HEAD>
<BODY>
<h2>
ClassName: <%=this.getClass().getName()%>  <br/>
ClassLoader: <%=this.getClass().getClassLoader().toString() %> <br/>
</h2>
<span style="text-align: center;">ClassLoader Infomation</span>
<table class="info">
  <tr>
    <th>sayHello()</th>
    <th>Component ClassLoader</th>
  </tr>
  <% for(int i=0; i < exampleServices.size(); i++){ %>
  <tr>
    <td><%=exampleServices.get(i).sayHello()%></td>
    <td><%=exampleServices.get(i).getClass().getClassLoader().toString() %></td>
  </tr>
  <%}%>
</table>

<span style="text-align: center;">Servlet service infomation</span>
<table class="info">
  <tr>
    <th>Servlet URL</th>
  </tr>
  <% for(int i=0; i < urls.size(); i++){ %>
  <tr>
    <td><a href="<%=urls.get(i)%>"><%=urls.get(i)%></a></td>
  </tr>
  <%}%>
</table>

<span style="text-align: center;">What about normal class i use directly</span>
<table class="info">
  <tr>
    <th>ClassName</th>
    <th>Static Field</th>
    <th>ClassLoader</th>
  </tr>
  <tr>
    <td><%=NormalClass.class.getName()%></td>
    <td><%=NormalClass.info %>
    <td><%=NormalClass.class.getClassLoader().toString() %></td>
  </tr>
</table>

<span style="text-align: center;">And dupdicate Class</span>
<table class="info">
  <tr>
    <th>ClassName</th>
    <th>Static Field</th>
    <th>ClassLoader</th>
  </tr>
  <tr>
    <td><%=DupdicateClass.class.getName()%></td>
    <td><%=DupdicateClass.VERSION %>
    <td><%=DupdicateClass.class.getClassLoader().toString() %></td>
  </tr>
</table>
</BODY>
</HTML>

