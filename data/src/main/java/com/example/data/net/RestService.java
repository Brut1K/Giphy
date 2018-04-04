package com.example.data.net;




import android.util.Log;

import com.example.data.entity.Data;
import com.example.data.entity.Root;

import java.util.List;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        Log.e("RestService","Constructor");
        this.restApi = restApi;
    }


    public Observable<Root> loadTrends(){
        Log.e("RestService","loadTrends");
        return restApi.loadTrends();

    }




    public Observable<Root> search(String keys){
        return restApi.search(keys);
    }


}
