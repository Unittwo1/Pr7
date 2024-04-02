package com.example.mobiles4.UI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobiles4.Data.Task;
import com.example.mobiles4.Data.TaskList;
import com.example.mobiles4.Data.TaskListRepository;
import com.example.mobiles4.R;

import java.util.Random;

public class TaskListViewModel extends ViewModel {
    private MutableLiveData<TaskListRepository> uiState =
            new MutableLiveData<>(new TaskList());
    private MutableLiveData<TaskListRepository> uiStateUser =
            new MutableLiveData<>(new TaskList());
    public LiveData<TaskListRepository> getUiState() {
        return uiState;
    }
    public LiveData<TaskListRepository> getUiStateUser() {
        return uiStateUser;
    }
    public Task getTask(int index) {
        return uiState.getValue().get(index);
    }
    public void addToList(Task task) {
        uiState.getValue().add(task);
    }
    public void clearTaskList() {
        uiState.getValue().clearAll();
    }
    public Task createRandomMathematicalTask() {
        Random random = new Random();
        Task task;
        int r = random.nextInt(2);
        if (r == 0) {
            task = setRandomArithmeticTask();
        }
        else {
            task = setRandomUnTask();
        }
        return task;
    }
    public void addUserTask(Task task) {
        uiStateUser.getValue().add(task);
    }
    public Task setRandomUserTask() {
        if (uiStateUser.getValue().isEmpty()) {
            return createRandomMathematicalTask();
        }
        Random random = new Random();
        Task task = uiStateUser.getValue().get(
                random.nextInt(uiStateUser.getValue().getSize())
        );
        return task;
    }
    private Task setRandomArithmeticTask() {
        Random random = new Random();
        int image = R.drawable.arithmetic_task;
        int first = random.nextInt(100);
        int second = random.nextInt(100);
        int coperator = random.nextInt(3);
        Integer answer = 0;
        String operator = null;
        switch (coperator) {
            case 0:
                operator=" + ";
                answer = first + second;
                break;
            case 1:
                operator=" - ";
                answer = first - second;
                break;
            case 2:
                operator=" * ";
                answer = first * second;
                break;
        }
        String text = "Вычислите: " + first + operator + second;
        return new Task(text, image, answer.toString());
    }
    private Task setRandomUnTask() {
        Random random = new Random();
        int image = R.drawable.un_task;
        String text = "Экзамен или зачёт по ";
        int angles = random.nextInt(5);
        String answer = "none";
        switch (angles) {
            case 0:
                text+="иностранному \n языку?";
                answer = "Экзамен";
                break;
            case 1:
                text+="програмированию \n на питоне?";
                answer = "Зачёт";
                break;
            case 2:
                text+="теории \n вероятности?";
                answer = "Экзамен";
                break;
            case 3:
                text+="ПБД?";
                answer = "Зачёт";
                break;
            case 4:
                text+="АКМС?";
                answer = "Зачёт";
                break;
        }
        return new Task(text, image, answer.toString());
    }
}
