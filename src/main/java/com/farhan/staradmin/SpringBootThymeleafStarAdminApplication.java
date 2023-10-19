//package com.farhan.staradmin;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringBootThymeleafStarAdminApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootThymeleafStarAdminApplication.class, args);
//	}
//}


package com.farhan.staradmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
src/main/java : 패키지와 클래스 파일
src/main/resource
-static : css/js 파일
-templates : html파일(표준)
-application.properties : 환경설정파일
-pom.xml : Maven 라이브러리 설정파일
*/
@SpringBootApplication
@MapperScan(basePackages = "com.farhan.staradmin")
public class SpringBootThymeleafStarAdminApplication {

	public static void main(String[] args) { // main
		SpringApplication.run(SpringBootThymeleafStarAdminApplication.class, args);
	}

}