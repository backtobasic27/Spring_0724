package org.hello.core;


import org.hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "org.hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Configuration.class})
)
public class AutoAppConfig {

//   //수동 빈 등록
//    @Bean(name = "memoryMemberRepository")
//    MemoryMemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
