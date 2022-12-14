package chap02.chap02Code.main;

import chap02.chap02Code.*;
import chap02.chap02Code.erp.ErpClient;
import chap02.chap02Code.erp.ErpClientFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForErp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-erp.xml");
		ErpClientFactory factory = ctx.getBean("factory", ErpClientFactory.class);
		ErpClient client = factory.create();
		client.connect();
		
		client.close();
		ctx.close();
	}

}
