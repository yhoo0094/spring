package co.company.test.config;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker{

	@Override
	public void volumeup() {
		System.out.println("AppleSpeaker");
	}
	
}
