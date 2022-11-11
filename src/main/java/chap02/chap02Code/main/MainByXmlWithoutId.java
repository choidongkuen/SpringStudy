package chap02.chap02Code.main;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlWithoutId {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config-without-id.xml");
		String[] beanNames = ctx.getBeanDefinitionNames();
		for (String bn : beanNames)
			System.out.println(bn);
		ctx.close();
	}
}
