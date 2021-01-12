package co.company.spring.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
	@Scheduled(fixedDelay=5000)
	public void cromTest2() {
	    System.out.println("5초마다 호출이 됩니다");
	}
}
