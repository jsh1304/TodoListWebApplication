package com.jj.springboot.todolistwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todoCount, username, description, targetDate, done);
        todos.add(todo);
    }
}
