package com.example.nikul.gifsearchapplication.presentation.screens;


import android.content.Context;
import android.util.Log;


import com.example.domain.entity.DataEntity;
import com.example.domain.interactors.TrendsUseCase;
import com.example.nikul.gifsearchapplication.app.App;
import com.example.nikul.gifsearchapplication.presentation.base.BaseViewModel;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;


public class DataViewModel extends BaseViewModel {

    private final String LOG = "DataViewModel";

    @Inject
    Context context;


    @Inject
    TrendsUseCase trendsUseCase;


    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public DataViewModel() {
        super();
        Log.e(LOG,"DATAVIEWMODEL CREATE");
        trendsUseCase.loadtrends().doOnNext(new Consumer<List<DataEntity>>() {
            @Override
            public void accept(List<DataEntity> dataEntities) throws Exception {
                for(DataEntity d: dataEntities){
                    Log.e(LOG,d.getId());
                    Log.e(LOG,d.getUrl());
                }
            }
        });

    }
}
