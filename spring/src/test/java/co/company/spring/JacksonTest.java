package co.company.spring;

import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.company.spring.controller.SlipVO;

public class JacksonTest {

	@Test
	public void test1() {
		ObjectMapper mapper = new ObjectMapper();
		String str = "[{\"slipAmount\":27720,\"salDt\":\"202101\",\"customer\":\"149\",\"bankAcct\":\"1341\"},{\"slipAmount\":26400,\"salDt\":\"202101\",\"customer\":\"114\",\"bankAcct\":\"15513\"}]";
		try {
			JsonNode node = mapper.readTree(str);
			System.out.println(node.get(0).path("slipAmount"));
			
			SlipVO[] list = mapper.readValue(str, SlipVO[].class);
			System.out.println(list[0].getSlipAmount());
			
			URL url = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101");
			JsonNode movie = mapper.readTree(url);
			System.out.println(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
