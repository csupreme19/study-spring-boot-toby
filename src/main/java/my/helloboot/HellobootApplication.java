package my.helloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class HellobootApplication {
	public static void main(String[] args) {
		GenericApplicationContext ctx = new GenericApplicationContext();
		ctx.registerBean(HelloController.class);
		ctx.registerBean(SimpleHelloService.class);
		ctx.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(sc -> sc.addServlet("hello", new HttpServlet() {
			@Override
			protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String requestURI = req.getRequestURI();
				String method = req.getMethod();
				if(requestURI.equals("/hello") && method.equals(HttpMethod.GET.name())) {
					String name = req.getParameter("name");
					HelloController helloController = ctx.getBean(HelloController.class);
					String ret = helloController.hello(name);
					resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
					resp.getWriter().println(ret);
				} else {
					resp.setStatus(HttpStatus.NOT_FOUND.value());
				}
			}
		}).addMapping("/*"));
		webServer.start();
	}
}
