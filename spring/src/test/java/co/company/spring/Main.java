package co.company.spring;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.company.spring.config.MvcConfiguration;
import co.company.spring.controller.Greeter;

public class Main {
	public static void main(String[] args) {
		//Greeter g = new Greeter();
		//g.setformat("%s, 안녕하세요");
		AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext(MvcConfiguration.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
