package chap02.chap02Code.main;

import chap02.chap02Code.*;
import chap02.chap02Code.sensor.Monitor;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSensor {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-sensor.xml");
		Monitor monitor = ctx.getBean(Monitor.class);
		System.out.println(monitor);
		ctx.close();
	}

}
