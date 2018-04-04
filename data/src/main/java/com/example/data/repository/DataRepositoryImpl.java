package com.example.data.repository;


import android.content.Context;
import android.util.Log;


import com.example.data.entity.Data;
import com.example.data.entity.Root;
import com.example.data.net.RestService;
import com.example.domain.entity.DataEntity;
import com.example.domain.repository.DataRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DataRepositoryImpl implements DataRepository {

    private static String LOG = "DataRepositoryImpl";

    private Context context;
    private RestService restService;

    public DataRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<List<DataEntity>> loadTrends() {
        Log.e("DataRepositoryImpl","loadTrends");
        return restService.loadTrends()
                .map(new Function<Root, List<DataEntity>>() {
                    @Override
                    public List<DataEntity> apply(Root root) throws Exception {
                        List<Data> data = root.getDataList();
                        List<DataEntity> dataEntities = new ArrayList<>();
                        for (Data d : data) {
                            Log.e(LOG, d.getId());
                            Log.e(LOG, d.getImages().getOriginal().getUrl());
                            dataEntities.add(new DataEntity(d.getId(), d.getImages().getOriginal().getUrl()));
                        }
                        return dataEntities;
                    }
                });
    }


}
