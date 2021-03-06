package com.example.nikul.gifsearchapplication.presentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nikul.gifsearchapplication.BR;


public abstract class BaseMVVMActivity<
        Binding extends ViewDataBinding,
        ViewModel extends BaseViewModel>
        extends AppCompatActivity {


    protected Binding binding;
    protected ViewModel viewModel ;


    public abstract int provideLayoutId();
    public abstract ViewModel   provideViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = provideViewModel();
        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        binding.setVariable(BR.viewModel,viewModel);

        Log.e("BaseVMactivity",viewModel.toString());

    }

    @Override
    protected void onStart() {
        super.onStart();
       viewModel.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }
}
