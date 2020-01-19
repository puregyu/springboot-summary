package com.devyu.webserver;
//package com.devyu;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.file.Files;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.catalina.Context;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//
//public class SpringbootSummaryApplication {
//	public static void main(String[] args) throws LifecycleException, IOException{
//		Tomcat tomcat = new Tomcat();
//		tomcat.setPort(8080);
//		
//		String docBase = Files.createTempDirectory("tomcat-basedir").toString();
//		Context context = tomcat.addContext("/", docBase);
//		
//		HttpServlet httpServlet = new HttpServlet() {
//			@Override
//			protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//					throws ServletException, IOException {
//				PrintWriter printWriter = resp.getWriter();
//				printWriter.println("<html><head><title>");
//				printWriter.println("hello, world");
//				printWriter.println("</title></head>");
//				printWriter.println("<body><h1>devyu~</h1></body>");
//				printWriter.println("</html>");
//			}
//		};
//		String servletName = "helloServlet";
//		tomcat.addServlet("/", servletName, httpServlet);
//		context.addServletMappingDecoded("/hello", servletName);
//		
//		tomcat.getConnector();
//		tomcat.start();
//		tomcat.getServer().await();
//	}
//}
