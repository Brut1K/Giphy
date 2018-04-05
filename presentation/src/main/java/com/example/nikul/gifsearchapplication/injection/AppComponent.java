package com.example.nikul.gifsearchapplication.injection;


import com.example.nikul.gifsearchapplication.presentation.screens.main.DataViewModel;


import javax.inject.Singleton;

import dagger.Component;

//связующее звено между классами с Injectom и самим дагером
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(DataViewModel dataViewModel);





}
