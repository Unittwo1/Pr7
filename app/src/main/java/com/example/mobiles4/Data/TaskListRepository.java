package com.example.mobiles4.Data;

import java.util.List;

public interface TaskListRepository {
    public List<Task> getTasks();
    public Task get(int index);
    public void add(Task task);
    public boolean isEmpty();
    public void clearAll();
    public int getSize();
}
