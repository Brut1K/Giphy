package com.example.domain.executor;


import io.reactivex.Scheduler;

//этот интерфейс нужно реализовать в presentation слое
public interface PostExecutionThread {
    Scheduler getScheduler();
}
