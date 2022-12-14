package chap02.chap02Code.main;

import chap02.chap02Code.*;
import chap02.chap02Code.conf.ConfigWithXmlImport;
import chap02.chap02Code.sensor.Sensor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlAndJava {

	public static void main(String[] args) {
		useBean(new GenericXmlApplicationContext("classpath:config-with-java.xml"));
		useBean(new AnnotationConfigApplicationContext(ConfigWithXmlImport.class));
	}

	private static void useBean(AbstractApplicationContext ctx) {
		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		PasswordChangeService pwChgSvc =
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");

		Sensor sensor1 = ctx.getBean("sensor1", Sensor.class);
		System.out.println(sensor1);

		ctx.close();
	}

}
