package com.example.nikul.gifsearchapplication.presentation.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.data.entity.Data;
import com.example.data.entity.Root;
import com.example.data.net.RestApi;
import com.example.data.net.RestService;
import com.example.data.repository.DataRepositoryImpl;
import com.example.domain.interactors.TrendsUseCase;
import com.example.nikul.gifsearchapplication.R;
import com.example.nikul.gifsearchapplication.app.App;
import com.example.nikul.gifsearchapplication.executor.UiThread;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private DataViewModel dataViewModel;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.buttonSearch);

        dataViewModel = new DataViewModel();



    }


}
