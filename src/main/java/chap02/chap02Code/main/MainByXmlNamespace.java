package chap02.chap02Code.main;

import chap02.chap02Code.*;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlNamespace {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-with-*.xml");
		AuthenticationService authSvc = 
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		authSvc.authenticate("bkchoi", "5678");
		ctx.close();
	}

}
