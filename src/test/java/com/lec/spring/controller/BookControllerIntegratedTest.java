package com.lec.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.spring.domain.Book;
import com.lec.spring.repository.BookRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @SpringBootTest https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html
 * ● Spring Boot 통합 테스트. (모든 bean 들이 IoC 에 올리고 테스트)
 * <p>
 * ● custom Environment properties  사용가능
 * <p>
 * ● webEnvironment mode 제공
 * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.WebEnvironment.html
 * MOCK : (디폴트) 실제 tomcat 을 올리는게 아니라 '다른 (가짜)tomcat' 으로 테스트
 * RANDOM_PORT : 실제 tomcat + 임의 Port 로 테스트.
 * DEFINED_PORT : 실제 tomcat + application.properties 에 정의된 port
 * <p>
 * ● TestRestTemplate, WebTestClient bean 제공 ->  웹서버 기능 테스트용!
 */

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc // MockMvc Bean 을 IoC 에 등록
@Transactional // 각각의 테스트 함수가 종료될 때마다 Transaction 을 RollBack 해줌.
class BookControllerIntegratedTest {

    @Autowired
    private MockMvc mockMvc;

    // 통합테스트에선 EntityManager 또한 IoC 되어 있을테니 주입 가능.
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void init() {
        // auto increment 를 리셋
        String sql = "ALTER TABLE t2_book AUTO_INCREMENT = 1"; // MySQL 방식으로 리셋
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Test
    void test1() {

    }


    @Test
    public void 저장하기테스트() throws Exception {
        log.info("저장하기테스트() 시작==========================================");

        // ■ given : 테스트를 위한 준비
        Book book = new Book(null, "스프링 따라하기", "허지우");
        String content = new ObjectMapper().writeValueAsString(book);
        log.info("content : " + content);

        // ■ when : 행동을 지정
        // 통합테스트에선 실제 Service 가 IoC 된다. 그래서 Stub 이 필요없다.

        // Controller 테스트 실행
        ResultActions resultActions = mockMvc.perform(post("/book") // post 방식 요청
                .contentType(MediaType.APPLICATION_JSON) // request body 타입
                .content(content) // JSON
                .accept(MediaType.APPLICATION_JSON) // 'response' 타입은 이것이어야 한다.
        ); // porform() 실행결과로 '응답'을 받아낼수있다.

        // ■ then : 검증
        resultActions
                // 기대하는 결과
                .andExpect(status().isCreated()) // 201 응답을 기대함.
                .andExpect(jsonPath("$.title").value("스프링 따라하기"))
                .andExpect(jsonPath("$.id").value("1")) // 위에 @BeforeEach 로 id를 초기화했다.
                // JsonPath : Json 객체를 탐색하기 위한 표준화된 방법
                //   SpringBoot 에는 이미 의존성이 자동으로 설정 되어 있다. → (spring-boot-starter-test 에 이미 포함된 라이브러리)
                //   JsonPath Online Evaluator 들 :
                //     https://jsonpath.com/,
                //     https://www.javainuse.com/jsonpath

                // 그 다음 행동 지정
                .andDo(print()) // 결과 콘솔에 출력
        ;
    }


    // Controller 에 대한 단위 테스트 코드

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAll_테스트() throws Exception {
        // given
        List<Book> books = List.of(
                new Book(1L, "스프링부트 따라하기", "허지우"),
                new Book(2L, "리액트 따라하기", "권희수"),
                new Book(3L, "쉬는시간이다", "김주희")
        );

        bookRepository.saveAll(books);


        // 테스트 수행
        ResultActions resultActions = mockMvc.perform(get("/book")
                .accept(MediaType.APPLICATION_JSON)
        );

        // then
        resultActions
                .andExpect(status().isOk()) // 200
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$.[2].title").value("쉬는시간이다"))
                .andDo(print());
    }
}
