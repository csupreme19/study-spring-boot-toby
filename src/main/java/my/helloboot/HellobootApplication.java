package my.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class HellobootApplication {

	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory
						.getWebServer(sc -> sc.addServlet("dispatcherServlet",
										new DispatcherServlet(this))
								.addMapping("/*"));
				webServer.start();
			}
		};
		ctx.register(HellobootApplication.class);
		ctx.refresh();
	}
}
