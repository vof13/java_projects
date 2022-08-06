package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<ToDo> todosIterable = toDoRepository.findAll();
        ArrayList<ToDo> toDos = new ArrayList<>();
        for (ToDo todo: todosIterable){
            toDos.add(todo);
        }
        model.addAttribute("todos", toDos);
        model.addAttribute("todosCount", toDos.size());

        return "index";
    }
}
