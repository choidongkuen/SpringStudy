package chap02.chap02Code.main;

import chap02.chap02Code.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainByJavaPackage {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext("net.madvirus.spring4.chap02.conf");

		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		PasswordChangeService pwChgSvc = 
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");

		ctx.close();
	}

}
