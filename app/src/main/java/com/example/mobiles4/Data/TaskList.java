package com.example.mobiles4.Data;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements TaskListRepository {
    private List<Task> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
    }
    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public Task get(int index) {
        return tasks.get(index);
    }

    @Override
    public void add(Task task) {
        tasks.add(task);
    }
    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
    @Override
    public void clearAll() {
        tasks.clear();
    }

    @Override
    public int getSize() {
        return tasks.size();
    }
}