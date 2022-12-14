package chap02.chap02Code.main;

import chap02.chap02Code.*;
import chap02.chap02Code.conf.Config;
import chap02.chap02Code.conf.Config1;
import chap02.chap02Code.conf.Config2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainByJavaConfig {

	public static void main(String[] args) {
		useSingleClass();
		useMultipleClass();
	}

	private static void useSingleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config.class);
		useBean(ctx);
		ctx.close();
	}

	private static void useBean(AnnotationConfigApplicationContext ctx) {
		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		PasswordChangeService pwChgSvc =
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}

	private static void useMultipleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config1.class, Config2.class);
		useBean(ctx);
		ctx.close();
	}
}
