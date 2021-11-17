package com.example.shopitaway;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;


public class CheckOutFragment extends Fragment {

    ProgressBar progressBar;
    int count = 0;
    Timer timer;

    public CheckOutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_out, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    progressBar = view.findViewById(R.id.progressbar);
    timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            count++;
            progressBar.setProgress(count);
            if (count == 100)
            {
                timer.cancel();
            }
        }
    };
    timer.schedule(timerTask, 0 , 100);
    }
}