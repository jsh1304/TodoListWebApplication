package com.jj.springboot.todolistwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service // 서비스 계층
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount, "hh", "AWS 배우기",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "hh", "DevOps 배우기",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todoCount, "hh", "Frontend 배우기",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        // 투두 객체의 id가 사용자가 찾는 id와 같은지 확인
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todoCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        // 투두 객체의 id가 사용자가 찾는 id와 같은지 확인
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        // todos 컬렉션에서 해당 투두 객체를 제거
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        // 투두 객체의 id가 사용자가 찾는 id와 같은지 확인
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        // 스트림 API를 사용하여 todos 컬렉션을 필터링. 해당하는 첫 번째 투두 객체 찾기
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
