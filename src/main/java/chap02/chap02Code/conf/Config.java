// XML 방식이 아닌, 자바 코드(어노테이션) 을 이용한 스프링 설정 방식
// 더욱 직관적

package chap02.chap02Code.conf;

import chap02.chap02Code.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration // 해당 클래스가 Spring 설정 클래스임을 의미
public class Config {

	// 빈 객체
	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}

	// 빈 객체의 이름을 name 속성으로 설정
	@Bean(name = "user2")
	public User user() {
		return new User("madvirus", "qwer");
	}

	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		return userRepo;
	}

	@Bean
	public PasswordChangeService pwChangeSvc() {
		// 다른 빈 객체를 참조하는 경우에는
		// 다른 빈 객체를 가져오는 메소드를 호출
		return new PasswordChangeService(userRepository());
	}

	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}

	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}

}
