package com.example.nikul.gifsearchapplication.app;

import android.app.Application;

import com.example.nikul.gifsearchapplication.injection.AppComponent;
import com.example.nikul.gifsearchapplication.injection.AppModule;
import com.example.nikul.gifsearchapplication.injection.DaggerAppComponent;


//запускается при старте приложения, прописан в манифесте

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       appComponent = DaggerAppComponent.builder()
       .appModule(new AppModule(this)).build();

    }
}
