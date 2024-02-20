package com.lec.spring.controller;

import com.lec.spring.domain.Book;
import com.lec.spring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
// ↑ 롬복(Lombok) 어노테이션으로, 클래스에 선언된 final이나 @NonNull인 필드에 대한 생성자를 자동으로 생성합니다.
@RestController
// ↑ 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션입니다.
// 각 메서드의 반환 값은 HTTP 응답으로 변환되어 클라이언트에게 전송됩니다.
@CrossOrigin
// ↑ CORS(Cross-Origin Resource Sharing)를 허용하기 위한 어노테이션으로, 다른 도메인에서의 요청을 허용합니다.
public class BookController {

    private final BookService bookService;
    // ↑ BookService 인터페이스를 주입받는 생성자를 생성하고, 해당 필드를 불변(final)으로 선언합니다.

    @GetMapping("/")
    // ↑ HTTP GET 요청을 처리하는 메서드로, 서버의 루트 경로("/")로 들어오는 요청에 대한 처리를 담당합니다.
    public ResponseEntity<?> home() {
        return new ResponseEntity<String>("ok", HttpStatus.OK);
        // ↑ ResponseEntity를 사용하여 HTTP 응답을 생성하고, "ok" 문자열을 반환합니다.
    }

    // 목록
    @GetMapping("/book")
    // ↑ HTTP GET 요청을 처리하는 메서드로, "/book" 경로로 들어오는 도서 목록 조회 요청에 대한 처리를 담당합니다.
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(bookService.모두가져오기(), HttpStatus.OK);
        // ResponseEntity를 사용하여 HTTP 응답을 생성하고, bookService.모두가져오기()를 호출하여 도서 목록을 반환합니다.
    }

    @PostMapping("/book")
    // HTTP POST 메서드에 매핑되는 엔드포인트를 지정하는 어노테이션입니다.
    // "/book" 경로로 POST 요청이 들어왔을 때 이 메서드가 실행됩니다.
    public ResponseEntity<?> save(@RequestBody Book book) {
        // @RequestBody 어노테이션은 HTTP 요청의 본문(body)에 담겨 있는 데이터를 자바 객체로 변환하도록 지시합니다.
        // 여기서는 클라이언트가 전송한 JSON 형식의 도서 정보를 Book 객체로 변환합니다.

        return new ResponseEntity<>(bookService.저장하기(book), HttpStatus.CREATED); // 201
        // 메서드는 ResponseEntity<?>를 반환합니다. <?>는 제네릭 타입이지만, 여기서는 어떤 타입이든 상관 없다는 의미로 사용됩니다.
    }

    @GetMapping("/book/{id}")
    // HTTP GET 메서드에 매핑되는 엔드포인트를 지정하는 어노테이션입니다.
    // "/book/{id}" 경로로 GET 요청이 들어왔을 때 이 메서드가 실행됩니다.
    // {id}는 경로 변수로, 실제로는 클라이언트가 전달하는 도서의 고유한 식별자입니다.
    public ResponseEntity<?> findById(@PathVariable Long id) {
        // @PathVariable 어노테이션은 경로 변수({id})의 값을 메서드 파라미터인 id에 바인딩합니다.

        return new ResponseEntity<>(bookService.한건가져오기(id), HttpStatus.OK);
        // new ResponseEntity<>(...)는 HTTP 응답을 생성하는데 사용되는 객체입니다. 이를 통해 조회된 도서 정보와 HTTP 상태코드를 반환합니다.
        // bookService.한건가져오기(id)는 주어진 도서 ID에 해당하는 도서 정보를 조회하는 BookService의 한건가져오기 메서드를 호출합니다. 이때, 실제로 조회된 도서 객체가 반환됩니다.
        // HttpStatus.OK는 HTTP 응답 상태코드로, 200 OK를 의미합니다. 요청이 성공적으로 처리되었음을 나타냅니다.
    }

    @PutMapping("/book")
    public ResponseEntity<?> update(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.수정하기(book), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.삭제하기(id), HttpStatus.OK);
    }


}
