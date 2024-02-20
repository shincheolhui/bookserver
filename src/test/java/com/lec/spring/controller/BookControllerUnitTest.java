package com.lec.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.spring.domain.Book;
import com.lec.spring.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Controller 의 단위 테스트 (Unit Test)
 * Controller 만 테스트
 * Controller 관련 로직만 메모리에 올리고 테스트 (ex: filter, ControllerAdvice)
 * 장점: 필요한 Bean 들만 올리니 통합테스트에 비해 빠르다
 * 단점: 이 단위 테스트를 통과했다 하여, 실제 서버에서 제대로 동작한다는 보장은 없다.
 * (분리되어 테스트 했기 때문에 다른 요소들과의 영향은 알수없다)
 * <p>
 * Controller 의 통합 테스트 (Integrated Test)
 * Controller 로 전체 Spring Application 을 테스트
 * '모든 Bean' 들을 메모리에(IoC) 올리고 테스트
 * 단점: 모든 Bean 들을 올려야 하니 단위테스트에 비해 시간이 더 걸린다.
 * 장점: 실제 서버에서도 테스트의 결과와 동일하게 동작.
 * <p>
 * 어떠한 기능에 대한 테스트인가에 따라 '단위테스트' 를 할지 '통합테스트' 를 할지 테스트를 작성해야 한다
 * 어떤 테스트이냐에 따라 사용하는 annotation 도 다르다.
 */


/**
 * @WebMvcTest https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html
 * ● Controller 단위 테스트.  MVC test 관련 요소만 메모리에 띄움
 * 포함하는 bean: @Controller, @ControllerAdvice, @JsonComponent, Converter/GenericConverter, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver
 * 포함하지 않는 bean: @Component, @Service, @Repository
 * <p>
 * ● Spring Security 와 MockMvc 의 auto-configure
 * ● @MockBean 나 @Import 와 같이 사용하여  to create any collaborators required by your @Controller beans.
 * ● @WebMvcTest 가 포함하는 annotation
 * - @ExtendWith(SpringExtension.class) 를 포함하고 있다. --> Spring 환경속에서 동작함
 * - @AutoConfigureMockMvc, @AutoConfigureWebMvc 등이 포함되어 있다.
 */

@Slf4j // log 찍어주는 용도로 사용.
@WebMvcTest
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc; // MVC 동작을 테스트 (request!), 서버가 동작하지 않는데 request를 해준다.


    // @Controller 를 IoC 에 띄우려 하는데... @Service 를 어케 주입 받을 수 있을까? (Service가 없어요!)
    // 이때 @MockBean 을 사용하여 IoC 환경에 bean 을 등록함 (가짜 Bean)

    @MockBean // IoC 환경에 '가짜' Service Bean 생성
    private BookService bookService;

    @Test
    void test1() {
        log.info("테스트() 시작 =================================");
    }

    @Test
    void test2() {
        log.info("테스트2() 시작================================");

        // @MockBean 으로 주입된 가짜 Service 는 기능을 수행하지 않을텐데??
        // 아래 결과는 뭘까?
        Book book = bookService.저장하기(new Book(null, "제목", "장고운"));
        System.out.println("book : " + book);
    }

    // BDDMockito 패턴 (BDD : Behavior-Driven Development)
    // given() - when() - then()
    // 어떤 상태에서(Given) 어떤 행동을 했을 때(When) 어떤 결과가 되는 지(Then)를 테스트
    @Test
    public void 저장하기테스트() throws Exception {
        log.info("저장하기테스트() 시작==========================================");

        // ■ given : 테스트를 위한 준비
        Book book = new Book(null, "스프링 따라하기", "허지우");
        String content = new ObjectMapper().writeValueAsString(book);
        log.info("content : " + content);

        // ■ when : 행동을 지정
        // 어짜피 주입된 Service 는 가짜다.  Service메소드들은 제대로 동작 안한다.
        //                               ( 이 경우 .저장하기(Book) )
        // 그래서 '행동 (when)'을 지정해주는 겁니다. ← 이를 Stub 이라 한다 : 테스트 용도로 하드 코딩한 값을 반환하는 구현체
        when(bookService.저장하기(book))
                .thenReturn(new Book(1L, "스프링 따라하기", "허지우"));
        // ↑ .저장하기() 의 리턴 결과값 이 이것이 되어야 한다.

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
                // JsonPath : Json 객체를 탐색하기 위한 표준화된 방법
                //   SpringBoot 에는 이미 의존성이 자동으로 설정 되어 있다. → (spring-boot-starter-test 에 이미 포함된 라이브러리)
                //   JsonPath Online Evaluator 들 :
                //     https://jsonpath.com/,
                //     https://www.javainuse.com/jsonpath

                // 그 다음 행동 지정
                .andDo(print()) // 결과 콘솔에 출력
        ;

        // ↑ given, when, then 을 통해  Service 나 Repository 없이 (신경쓰지 않고도)
        // Controller 에 대해서 동작 테스트를 할수 있다!

    }


    // Controller 에 대한 단위 테스트 코드
    @Test
    public void findAll_테스트() throws Exception {
        // given
        List<Book> books = List.of(
                new Book(1L, "스프링부트 따라하기", "허지우"),
                new Book(2L, "리액트 따라하기", "권희수")
        );

        // when
        when(bookService.모두가져오기()).thenReturn(books);

        // 테스트 수행
        ResultActions resultActions = mockMvc.perform(get("/book")
                .accept(MediaType.APPLICATION_JSON)
        );

        // then
        resultActions
                .andExpect(status().isOk()) // 200
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.[0].title").value("스프링부트 따라하기"))
                .andDo(print());
    }
}










