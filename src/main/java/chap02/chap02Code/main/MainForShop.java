package chap02.chap02Code.main;

import chap02.chap02Code.*;
import chap02.chap02Code.conf.ConfigShop;
import chap02.chap02Code.search.SearchClientFactory;
import chap02.chap02Code.search.SearchServiceHealthChecker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForShop {

	public static void main(String[] args) {
		runByUsingXmlConfig();
		runByUsingJavaConfig();
	}

	private static void runByUsingXmlConfig() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-shop.xml");
		useBean(ctx);
		ctx.close();
	}

	private static void useBean(ApplicationContext ctx) {
		ProductService productService = ctx.getBean(ProductService.class);
		productService.createProduct(new ProductInfo());

		OrderService orderService = ctx.getBean(OrderService.class);
		orderService.order(new OrderInfo());

		SearchClientFactory orderSearchClientFactory = ctx.getBean("orderSearchClientFactory", SearchClientFactory.class);
		System.out.println(orderSearchClientFactory);
		
		SearchServiceHealthChecker healthChecker = ctx.getBean("searchServiceHealthChecker", SearchServiceHealthChecker.class);
		healthChecker.check();
	}

	private static void runByUsingJavaConfig() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ConfigShop.class);
		useBean(ctx);
		ctx.close();
	}

}
