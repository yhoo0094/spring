package co.company.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //@Controller, @Service, @Repository, 
public class TV {
	@Autowired 
	@Qualifier("appleSpeaker")
	
//	@Resource(name = "apple") //Autowired+Qualifier
	Speaker speaker;
	public void volumeup() {
		speaker.volumeup();
	}
	
	public TV() {
		System.out.println("TV 생성됨");
	}
	public void init() {
		System.out.println("객체 생성됨");
	}
	public void destroy() {
		System.out.println("객체 소멸됨");
	}
}
