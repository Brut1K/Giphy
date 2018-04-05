package com.example.nikul.gifsearchapplication.presentation.screens.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import com.example.nikul.gifsearchapplication.R;
import com.example.nikul.gifsearchapplication.databinding.ActivityMainBinding;
import com.example.nikul.gifsearchapplication.presentation.base.BaseMVVMActivity;




public class MainActivity extends BaseMVVMActivity<ActivityMainBinding,DataViewModel> {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public DataViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(DataViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(viewModel.dataAdapter);
    }


}
