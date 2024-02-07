package com.jj.springboot.todolistwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }
    private TodoService todoService;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("hh");
        model.addAttribute("todos", todos);
        return "listTodos";
    }
}
