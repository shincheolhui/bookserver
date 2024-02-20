package com.lec.spring.service;

import com.lec.spring.domain.Book;
import com.lec.spring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Transactional 선언은 '클래스' 혹은 '메서드' 에 가능.
//  @Transactional 이 선언된 메서드가 호출되면
//   트랜잭션을 시작하고
//   - 메소드가 정상적으로 리턴하게 되면 Commit 실행 (변경내역이 DB 저장, insert, update, delete <- DML)
//   - 중간에 예외가 발생되면 RollBack
@RequiredArgsConstructor // @NonNull, final 생성자 만들어짐.
@Service
public class BookService {

    private final BookRepository bookRepository;

    // DML 아님에도 @Transactional 를 붙인 이유
    // 1. JPA에 '변경감지' 라는 기능이 있는데. readOnly = true 를 하면 '변경감지' 동작을 안함 (내부 연산 기능 줄임)
    // 2. SELECT 에도 Transactional 이 붙어 있으니
    //  -> update 시의 정합성을 유지해줌.
    //  -> insert 의 유령 데이터 현상 (팬텀현상)은 못막음.

    @Transactional
    public Book 저장하기(Book book) { // insert 발생
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    // '부정합' 방지,
    // @Transactional(readOnly = true) 은 실제 DB의 값이 변경되어도 Transaction 끝날 때까지 해당 데이터는 최초에 select 한 값 그대로 가져오게 된다.
    public Book 한건가져오기(Long id) { // select 발생
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id를 확인하세요"));
    }

    @Transactional(readOnly = true)
    public List<Book> 모두가져오기() {
        return bookRepository.findAll(); // select
    }

    // id, title, subject -> 수정
    @Transactional
    public Book 수정하기(Book book) {
        // 영속화된 객체
        Book bookEntity = bookRepository.findById(book.getId())
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요"));

        // 영속화된 객체를 수정 (변경내역 발생)
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());

        // 리턴하고 종료될 때 -> 즉 transaction 이 종료될 때 -> 변경내역체크 (dirty check) 하여 DB에 반영 (update)
        return bookEntity;
    }

    @Transactional
    public String 삭제하기(Long id) {
        bookRepository.deleteById(id);
        return "ok";
    }

}

























