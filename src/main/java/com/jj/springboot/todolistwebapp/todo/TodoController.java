package com.jj.springboot.todolistwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }
    private TodoService todoService;

    // "list-todos" URL 요청을 처리하는 메소드
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("hh");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    /// "add-투두" GET 요청에 대한 핸들러. 새로운 할 일 페이지를 보여줌
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String userName = (String) model.get("name");
        Todo todo = new Todo(0, userName, "기본 설명", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    // "add-투두" POST 요청에 대한 핸들러. 새로운 할 일을 추가
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String userName = (String) model.get("name");
        todoService.addTodo(userName, todo.getDescription(),
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
