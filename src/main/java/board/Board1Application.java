package board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;



//스프링 부트 특성, 어플리케이션의 스프링 설정이 자동으로 구성
//앞서 multipartResolver를 등록했기 때문에 첨부파일 관련 자동 구성을 사용하지 않도록 해야함(아파치로 구현)
//스프링부트에서 자동으로 구성된 요소들 중, 첨부파일 관련 구성을 사용하지 않도록 하기 위해서는 스프링부트어플리케이션 어노테이션을 변경해야함
//@SpringBootApplication

@SpringBootApplication(exclude= {MultipartAutoConfiguration.class})
public class Board1Application {

	public static void main(String[] args) {
		SpringApplication.run(Board1Application.class, args);
	}

}
