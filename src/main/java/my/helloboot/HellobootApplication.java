package my.helloboot;

import my.config.MySpringApplication;

@MySpringBootApplication
public class HellobootApplication {
	public static void main(String[] args) {
		MySpringApplication.run(HellobootApplication.class, args);
	}
}