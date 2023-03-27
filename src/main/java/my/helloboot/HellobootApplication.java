package my.helloboot;

import my.config.MySpringApplication;
import my.config.MySpringBootApplication;

@MySpringBootApplication
public class HellobootApplication {
	public static void main(String[] args) {
		MySpringApplication.run(HellobootApplication.class, args);
	}
}