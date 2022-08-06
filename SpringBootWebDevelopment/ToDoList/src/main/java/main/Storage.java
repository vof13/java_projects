package main;

import main.model.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    static private ConcurrentHashMap <Integer, ToDo> toDos = new ConcurrentHashMap<>();
    static private final AtomicInteger currentId = new AtomicInteger(1);

    public static List<ToDo> getAllToDos() {
        return new ArrayList<>(toDos.values());

    }

    public static void setAllToDos (ArrayList<ToDo> toDosList) {
        deleteAll();
        currentId.set(1);
        toDosList.forEach(Storage::setToDo);
    }

    public static void setToDo(ToDo toDo) {
        int id = currentId.getAndIncrement();
        toDo.setId(id);
        toDos.put(id, toDo);
    }

    public static ToDo getToDo (int toDoId) {
        return toDos.getOrDefault(toDoId, null);
    }

    public static void deleteAll() {
        toDos = null;
    }

    public static void refreshToDo (int id, ToDo toDo) {
        toDos.put(id, toDo);
        toDo.setId(id);
    }

    public static void deleteOne(int id) {
        toDos.remove(id);
    }
}
