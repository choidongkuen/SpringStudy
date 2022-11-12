package chap02.chap02Code.main;

import chap02.chap02Code.*;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// 스프링 컨테이너(GenericeApplicationContext 클래스)
		// 클래스패스에 위치한 config.xml 파일을 스프링 설정으로 사용하겠다.
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:config.xml");

		// 스프링 컨테이너를 통해 AuthenticationService 객체 구하기(IoC)
		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);

		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "11111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "111111");
		try {
			authSvc.authenticate("bkchoi2", "1111");
		} catch (UserNotFoundException ex) {
		}

		authSvc.authenticate("bkchoi", "1234");

		// 이름 설정 하지 않고 타입만 전달 => 타입에 해당하는 빈을 구해서 리턴
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1234");
		authSvc.authenticate("bkchoi", "5678");
		ctx.close();
	}

	private static void runAuthAndCatchAuthEx(
			AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		} catch (AuthException ex) {
		}
	}
}
