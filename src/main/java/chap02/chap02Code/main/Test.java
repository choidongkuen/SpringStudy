package chap02.chap02Code.main;

import chap02.chap02Code.AuthenticationService;
import chap02.chap02Code.PasswordChangeService;
import chap02.chap02Code.conf.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.security.util.Password;

public class Test {

    public static void main(String[] args) {

        // 객체 컨테이너
        AnnotationConfigApplicationContext ctx =
                // 설정 클래스명 대신 설정 클래스의 상위 패키지 위치를 전달하면 하위 모든 Configuration 어노테이션이 있는 클래스를 설정 파일로 사용
                new AnnotationConfigApplicationContext(Config.class);

        // 첫번째 빈 객체를 스프링 컨테이너를 통해 불러옴
        AuthenticationService authSvc =
                ctx.getBean("authenticationService",AuthenticationService.class);
        authSvc.authenticate("bkchoi","1234");


        // 첫번째 빈 객체를 스프링 컨테이너를 통해 불러옴
        PasswordChangeService pwChgSvc =
                ctx.getBean(PasswordChangeService.class);
        pwChgSvc.changePassword("bkchoi","1234","5678");


    }
}
