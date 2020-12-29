package co.company.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //<bean> 등록
@Aspect	//<aop:aspect>
public class LogAdvice {
	
	//pointcut 정의하기
	@Pointcut("execution(* co.company.spring..*Impl.*(..))") //패키지 이름이 impl로 끝나는 모든 클래스(*)의 모든 메소드(..)
	public void allpointcut(){}
	
	@Before("allpointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] param = jp.getArgs();
		System.out.println("[공통로그] before" + method + "\n" + ((param != null && param.length>0)? param[0] : ""));
	}
}
