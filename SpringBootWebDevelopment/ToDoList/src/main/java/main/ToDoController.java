package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;


    @GetMapping("/todos/")
    private List<String> list(Model model) {
        model.addAttribute("todosCount", toDoRepository.count());
        return toDoRepository
                .findAll()
                .stream()
                .map(ToDo::getName)
                .collect(Collectors.toList());
    }

    @PostMapping("/todos/")
    public Map<String, Boolean> add(@RequestBody String todoStr) {
        if (Strings.isEmpty(todoStr)) {
            return Map.of("result", false);
        }
        ToDo todo = new ToDo();
        todo.setName(todoStr);
        toDoRepository.save(todo);
        return Map.of("result", true);
    }

    @DeleteMapping("/todos/")
    public void deleteAll() {
        toDoRepository.deleteAll();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalToDo.get(), HttpStatus.OK);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteToDo(@PathVariable int id) {
        toDoRepository.deleteById(id);
    }
}
