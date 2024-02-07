package com.jj.springboot.todolistwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    private static List<Todo> todos;

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
