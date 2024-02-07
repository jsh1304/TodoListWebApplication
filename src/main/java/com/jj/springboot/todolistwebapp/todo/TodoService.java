package com.jj.springboot.todolistwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service // 서비스 계층
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "hh", "AWS 배우기",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(1, "hh", "DevOps 배우기",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(1, "hh", "Frontend 배우기",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
