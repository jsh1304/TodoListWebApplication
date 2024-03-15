package com.jj.springboot.todolistwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 투두 엔티티에 대한 데이터베이스 작업을 수행하는 Spring Data JPA Repository 인터페이스
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    /**
     * 주어진 사용자명(username)에 해당하는 모든 투두 엔티티를 조회
     * username 조회할 사용자명
     * @return 주어진 사용자명에 해당하는 모든 투두 엔티티 목록
     */
    public List<Todo> findByUsername(String username);
}
