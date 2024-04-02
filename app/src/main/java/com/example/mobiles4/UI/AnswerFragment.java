package com.example.mobiles4.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.TextView;

import com.example.mobiles4.R;

public class AnswerFragment extends Fragment {
    public AnswerFragment() {
        super(R.layout.fragment_answer);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        TextView tTaskText = view.findViewById(R.id.t_tasktext);
        TextView tAnswer = view.findViewById(R.id.t_taskanswer);
        TaskListViewModel taskListViewModel = new ViewModelProvider(getActivity()).get(TaskListViewModel.class);
        taskListViewModel.getUiState().observe(getViewLifecycleOwner(), uiState -> {
            tTaskText.setText(uiState.getTasks().
                    get(bundle.getInt("getElement")).getText());
            tAnswer.setText(uiState.getTasks().
                    get(bundle.getInt("getElement")).getAnswer());
                });
    }
}