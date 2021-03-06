package com.example.domain.interactors;


import android.util.Log;

import com.example.domain.executor.PostExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase {

    // поток в котором будем получать результаты в presentation слое
    protected Scheduler postExecutionThread;

    // поток в котором будем выполнять все сложные запросы, другой поток не UI
    protected Scheduler threadExecution;

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        Log.e("super.BaseUseCase","create");
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
        Log.e("super.BaseUseCase","finish");
    }


}
