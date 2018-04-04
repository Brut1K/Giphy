package com.example.nikul.gifsearchapplication.injection;


import android.content.Context;
import android.util.Log;

import com.example.data.net.RestApi;
import com.example.data.net.RestService;

import com.example.data.repository.DataRepositoryImpl;
import com.example.domain.executor.PostExecutionThread;

import com.example.domain.repository.DataRepository;
import com.example.nikul.gifsearchapplication.BuildConfig;
import com.example.nikul.gifsearchapplication.executor.UiThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private static String LOG = "AppModule";

    static Context context;

    public AppModule(Context context) {

        this.context = context;
    }

    @Provides
    @Singleton
    public static Context getContext(){
        Log.e(LOG,"getContext");
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread(){
        Log.e("PostExecutionThread","create");
        return new UiThread();

    }

//    @Binds
//    public abstract PostExecutionThread getUiThread(UiThread uiThread);


    @Provides
    @Singleton
    public DataRepository getDataRepository(Context context, RestService restService) {
        return new DataRepositoryImpl(context,restService);
    }



    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit){
        Log.e("AppModule","CREATE RESTAPI");
        return retrofit.create(RestApi.class);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson){
        Log.e("AppModule","CREATE RETROFIT");
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
               .baseUrl("https://api.giphy.com/v1/gifs/")
  //              .baseUrl("https://api.backendless.com/ECB6B4FC-59A4-8B6B-FFC1-347C441D0000/A095639C-21D1-B2AA-FF69-AFBAFCC66200/")
                .build();

//        ссылку сделать для дебага и релиза в градле

    }


    @Provides
    @Singleton
    public OkHttpClient getOkHttp() {
        Log.e("AppModule","CREATE GETOKHTTP");

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
           if(BuildConfig.DEBUG) {
               HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
               httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
               builder.addInterceptor(httpLoggingInterceptor);
           }
          return builder.build();
    }





    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder()
                .create();

    }

}
