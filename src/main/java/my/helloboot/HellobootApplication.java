package my.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication {
	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(sc -> sc.addServlet("hello", new HttpServlet() {
			@Override
			protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String requestURI = req.getRequestURI();
				String method = req.getMethod();
				if(requestURI.equals("/hello") && method.equals(HttpMethod.GET.name())) {
					new HelloController().hello(req, resp);
				} else {
					resp.setStatus(HttpStatus.NOT_FOUND.value());
				}
			}
		}).addMapping("/*"));
		webServer.start();
	}

	static class HelloController {
		void hello(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			String name = req.getParameter("name");
			resp.setStatus(HttpStatus.OK.value());
			resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
			resp.getWriter().println("Hello " + name);
		}
	}
}
