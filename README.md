<h1>도서 정보 CRUD 서버</h1>
<ul>
<li>client 에서 도서명과 저자를 입력, DB insert</li>
<li>DB에 저장된 전체 도서 Select</li>
<li>client 에서 수정한 도서 정보를 DB 에 Update</li>
<li>client 에서 삭제한 도서 정보를 DB 에서 Delete</li>
</ul>
<br/>

<h2>사용기술</h2>
💾 Databases<br>
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)


📚 Frameworks, Platforms and Libraries<br>
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![Chart.js](https://img.shields.io/badge/chart.js-F5788D.svg?style=for-the-badge&logo=chart.js&logoColor=white)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![React Router](https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)


☁️ Hosting/SaaS<br>
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)


💻 IDEs/Editors<br>
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)


📋 Languages<br>
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)


🎋 ORM<br>
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)


🥅 Other<br>
![ESLint](https://img.shields.io/badge/ESLint-4B3263?style=for-the-badge&logo=eslint&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)


🗄️ Servers<br>
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)


🕓 Version Control<br>
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)



<br>
<h2>UI</h2>

# JUnit

### JAVA 언어를 기반으로 하는 단위 테스트 프레임워크

소프트웨어의 각 부분이 의도한 대로 작동하는지 확인하기 위한 테스트를 작성하는 데 사용된다.
JUnit은 테스트 주도 개발(TDD) 및 지속적인 통합(CI)과 같은 소프트웨어 개발 방법론에서 중요한 역할을 한다.
<br>

JUnit은 간단한 어노테이션과 메서드를 사용하여 테스트를 정의하고, 이를 실행하여 소프트웨어의 특정 부분이 올바르게 동작하는지 확인한다.
테스트 메서드는 주로 특정 기능이나 모듈을 테스트하는 데 사용되며, 테스트 케이스를 묶어 테스트 스위트를 만들 수 있다.
<br>

JUnit은 테스트의 실행 결과를 쉽게 확인할 수 있는 테스트 보고서를 제공하고,
테스트 케이스 간에 의존성을 최소화하여 각각의 테스트를 독립적으로 실행할 수 있도록 지원한다.
이러한 특성은 코드의 신뢰성을 높이고 유지보수를 쉽게 만든다.
<br>

JUnit은 Java 언어에 특화되어 있지만, 다양한 언어와 환경에 대한 유사한 테스트 프레임워크도 존재한다.
<hr>
<ul>
<li>
@Slf4j
</li>
<li>
@WebMvcTest
</li>
<li>
@MockBean
</li>
<li>
@AutoConfigureMockMvc
</li>
<li>
@Transactional
</li>
</ul>
<hr>

### @Slf4j

'@Slf4j'는 Java에서 로깅을 지원하는 라이브러리 중 하나인 SLF4J(Simple Logging Facade for Java)를 이용하여
간편하게 로깅 코드를 작성할 수 있도록 도와주는 롬복(Lombok) 어노테이션이다.
'@Slf4j' 어노테이션을 사용하면 해당 클래스에 SLF4J의 Logger를 자동으로 생성해준다.
이 Logger를 통해 로깅을 수행할 수 있으며, 코드에 직접 Logger를 선언하고 초기화하는 작업을 줄여준다.

    import lombok.extern.slf4j.Slf4j;

    @Slf4j
    public class MyClass {

        public void myMethod() {
            log.debug("Debug message");
            log.info("Info message");
            log.warn("Warning message");
            log.error("Error message");
        }
    }

위 코드에서 '@Slf4j' 어노테이션을 사용하면 log라는 이름의 Logger가 자동으로 생성된다.
그리고 myMethod() 메서드에서는 해당 Logger를 사용하여 다양한 로그 레벨의 메시지를 출력할 수 있다.
로그 레벨은 순서대로 디버그(Debug), 정보(Info), 경고(Warning), 오류(Error)이다.

이렇게 SLF4J와 롬복을 함께 사용하면 로깅 코드를 간결하게 작성할 수 있고, 필요에 따라 로그 레벨을 조절하여 원하는 정보를 얻을 수 있다.
<br>
<hr>

### @WebMvcTest

'@WebMvcTest'는 스프링 프레임워크에서 제공하는 특별한 테스트 어노테이션 중 하나로, 웹 애플리케이션의 컨트롤러(Controller)를 테스트하는 데 사용된다.
이 어노테이션은 스프링 MVC 컨트롤러에 대한 테스트 환경을 설정하고, 해당 컨트롤러의 테스트를 수행할 수 있도록 지원한다.

'@WebMvcTest'를 사용하면 웹 계층(Web layer)의 테스트에 필요한 빈(Bean)들만 로드되므로,
전체 애플리케이션 컨텍스트를 구성하는 것보다 가볍고 빠르게 테스트를 수행할 수 있다.

    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
    import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
    
    @WebMvcTest(MyController.class)
    public class MyControllerTest {
    
        @Autowired
        private MockMvc mockMvc;
    
        @Test
        public void testHomeController() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/"))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andExpect(MockMvcResultMatchers.view().name("home"));
        }
    }

이 예제에서는 '@WebMvcTest' 어노테이션을 사용하여 MyController 클래스를 테스트한다.
MockMvc는 스프링 MVC 테스트를 위한 가짜(Mock) 웹 환경을 제공하는 객체로,
컨트롤러의 동작을 모의(Mock)로 테스트할 수 있게 도와준다.

'testHomeController' 메서드에서는 '/' 경로로 GET 요청을 보내고, 그 결과를 검증한다.
예상하는 결과는 HTTP 상태 코드가 200(OK)이어야 하고, 뷰 이름은 "home"이어야 한다.

이렇게 '@WebMvcTest'를 사용하면 해당 컨트롤러의 테스트를 위한 슬라이스 테스트를 수행할 수 있다.
이는 전체 애플리케이션을 구동하지 않고도 특정 컨트롤러에 대한 테스트를 빠르게 수행할 수 있게 해준다.
<br>
<hr>

### @MockBean

'@MockBean'은 스프링 프레임워크의 테스트에서 사용되는 어노테이션 중 하나로,
테스트에서 모의(Mock) 객체를 생성하고 주입하는데 사용된다.
이를 통해 외부 의존성을 가진 빈을 모의화하고, 해당 빈이 예상대로 동작하도록 조작할 수 있다.

가장 흔한 사용 사례는 통합 테스트 시에 외부 서비스나 레포지토리와 같은 의존성을 가진 빈을 모의화하여 테스트하는 것이다.

간단한 예제를 통해 '@MockBean'을 설명한다.
아래는 서비스(MyService)에서 외부 레포지토리(MyRepository)를 사용하는 경우의 테스트다.

    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.boot.test.mock.mockito.MockBean;
    import org.springframework.test.web.servlet.MockMvc;
    import static org.mockito.Mockito.when;
    
    @WebMvcTest(MyController.class)
    public class MyControllerTest {
    
        @Autowired
        private MockMvc mockMvc;
    
        @MockBean
        private MyService myService; // MyService에 의존하는 MyController 테스트를 수행하고자 함
    
        @Test
        public void testHomeController() throws Exception {
            // 모의 MyService가 반환할 값을 지정
            when(myService.getData()).thenReturn("MockedData");
    
            mockMvc.perform(MockMvcRequestBuilders.get("/"))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andExpect(MockMvcResultMatchers.view().name("home"))
                   .andExpect(MockMvcResultMatchers.model().attribute("data", "MockedData"));
        }
    }

위 예제에서 '@MockBean'을 사용하여 MyService를 모의화하고,
해당 모의 객체를 테스트 대상인 MyController에 주입한다.
그리고 when(myService.getData()).thenReturn("MockedData")를 사용하여
MyService의 getData() 메서드가 호출될 때 "MockedData"를 반환하도록 지정한다.

이렇게 하면 외부 의존성이 있는 빈을 실제로 실행하지 않고, 모의 객체를 통해 테스트를 수행할 수 있다.
이는 특히 통합 테스트에서 외부 서비스와의 연동을 피하고, 의존성을 쉽게 제어하며, 테스트의 안정성을 높이는 데 도움이 된다.
<br>
<hr>

### @AutoConfigureMockMvc

'@AutoConfigureMockMvc'는 스프링 부트 테스트에서 사용되는 어노테이션으로,
MockMvc를 자동으로 설정하여 웹 애플리케이션의 HTTP 요청 및 응답을 테스트하기 위한 환경을 제공한다.
이 어노테이션을 사용하면 MockMvc를 명시적으로 구성하지 않아도 편리하게 웹 계층을 테스트할 수 있다.

'@AutoConfigureMockMvc'를 사용하면 Spring Boot 테스트 컨텍스트에서 MockMvc를 자동으로 설정하므로,
컨트롤러의 테스트를 진행할 때 테스트할 URL 엔드포인트로 HTTP 요청을 보내고 결과를 검증할 수 있다.

간단한 예제를 통해 '@AutoConfigureMockMvc'를 설명하겠다.

    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.http.MediaType;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
    import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
    
    @WebMvcTest(MyController.class)
    @AutoConfigureMockMvc
    public class MyControllerTest {
    
        @Autowired
        private MockMvc mockMvc;
    
        @Test
        public void testHomeController() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/")
                   .contentType(MediaType.APPLICATION_JSON))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andExpect(MockMvcResultMatchers.view().name("home"));
        }
    }

위 예제에서 @WebMvcTest 어노테이션은 특정 컨트롤러(MyController)를 테스트하고,
'@AutoConfigureMockMvc'는 해당 컨트롤러의 테스트를 위한 MockMvc를 자동으로 구성한다.
그러면 테스트 메서드에서는 MockMvc를 사용하여 "/" 경로로 GET 요청을 보내고, 결과를 검증한다.

'@AutoConfigureMockMvc'를 사용하면 명시적으로 MockMvc를 설정하지 않아도 된다는 장점이 있으며,
간단한 웹 계층 테스트를 더 쉽게 수행할 수 있게 도와준다.
<br>
<hr>

### @Transactional

'@Transactional'은 스프링 프레임워크에서 트랜잭션을 처리하기 위한 어노테이션 중 하나다.
이 어노테이션은 메서드나 클래스에 사용되어, 해당 메서드 또는 클래스의 메서드들이 트랜잭션 내에서 실행되도록 지정한다.
스프링의 트랜잭션 관리 기능을 쉽게 사용할 수 있도록 도와준다.

일반적으로 '@Transactional'은 서비스 계층이나 데이터 액세스 계층의 메서드에서 사용되며,
이 어노테이션을 붙인 메서드는 트랜잭션 내에서 실행되어 데이터베이스의 변경을 안전하게 처리할 수 있다.
만약 메서드 실행 중에 예외가 발생하면 해당 트랜잭션은 롤백된다.

간단한 예제를 통해 @Transactional을 설명하겠다.

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;
    
    @Service
    public class MyService {
    
        @Autowired
        private MyRepository myRepository;
    
        @Transactional
        public void updateData() {
            // 트랜잭션 내에서 실행되는 로직
            myRepository.updateSomeData();
        }
    }

위 예제에서 @Transactional 어노테이션이 updateData 메서드에 적용되어 있다.
이 메서드가 호출되면, 스프링은 트랜잭션을 시작하고 updateSomeData 메서드가 실행될 때까지 해당 트랜잭션을 유지한다.
만약 updateSomeData 메서드 실행 중에 예외가 발생하면 트랜잭션은 롤백되고, 예외가 발생하지 않으면 트랜잭션이 커밋된다.

@Transactional 어노테이션은 다양한 속성을 가지고 있어 트랜잭션의 동작을 세밀하게 제어할 수 있다.
예를 들면, 트랜잭션의 읽기 전용(read-only) 속성을 지정하거나, 특정 예외가 발생했을 때 롤백 여부를 결정할 수 있다.
<br>
<hr>
