package com.example.domain.interactors;


import android.util.Log;

import com.example.domain.entity.DataEntity;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.repository.DataRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TrendsUseCase extends BaseUseCase{
    private DataRepository dataRepository;

    @Inject
    public TrendsUseCase(PostExecutionThread postExecutionThread,DataRepository dataRepository) {
        super(postExecutionThread);
        this.dataRepository = dataRepository;
    }


    public Observable<List<DataEntity>> loadtrends(){
        Log.e("TrendsUseCase","loadTrends");
        return dataRepository.loadTrends()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }






}
