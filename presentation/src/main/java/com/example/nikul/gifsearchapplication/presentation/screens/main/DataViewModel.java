package com.example.nikul.gifsearchapplication.presentation.screens.main;


import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;


import com.example.domain.entity.DataEntity;
import com.example.domain.interactors.SearchUseCase;
import com.example.domain.interactors.TrendsUseCase;
import com.example.nikul.gifsearchapplication.app.App;
import com.example.nikul.gifsearchapplication.presentation.base.BaseViewModel;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


public class DataViewModel extends BaseViewModel {

    private final String LOG = "DataViewModel";

    public DataAdapter dataAdapter = new DataAdapter();

    @Inject
    Context context;


    @Inject
    TrendsUseCase trendsUseCase;
    @Inject
    SearchUseCase searchUseCase;


    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public ObservableField<String> editText = new ObservableField<>("");
    public ObservableField<String> button = new ObservableField<>("Search");

    public void buttonClick(View view) {
        Log.e(LOG,"buttonClick");
        searchUseCase.search(editText.get()).doOnNext(new Consumer<List<DataEntity>>() {
            @Override
            public void accept(List<DataEntity> dataEntities) throws Exception {
                for (DataEntity d : dataEntities) {
                    Log.e(LOG, d.getId());
                    Log.e(LOG, d.getUrl());
                    dataAdapter.setItems(dataEntities);
                }
            }
        }).subscribe();
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
                    dataAdapter.setItems(dataEntities);
                }
            }
        }).subscribe();
    }


}
