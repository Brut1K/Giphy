package com.example.data.net;


import com.example.data.entity.Data;
import com.example.data.entity.Root;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {


    @GET("trending?api_key=LNUzsQFLm6xuc2aE7h6gUimo9TDf1hyh&limit=10")
    Observable<Root> loadTrends();

    @GET("search?api_key=LNUzsQFLm6xuc2aE7h6gUimo9TDf1hyh&limit=10&q={keys}")
    Observable<Root> search(@Path("keys") String keys);


}
