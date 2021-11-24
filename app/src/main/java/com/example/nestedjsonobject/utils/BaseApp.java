package com.example.nestedjsonobject.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


import com.example.nestedjsonobject.di.component.ApplicationComponent;
import com.example.nestedjsonobject.di.component.DaggerApplicationComponent;
import com.example.nestedjsonobject.di.module.ContextModule;
import com.example.nestedjsonobject.network_service.ApiInterface;

import timber.log.Timber;

public class BaseApp extends Application {


    private static ApplicationComponent component;
    ApiInterface networkService;
    SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        networkService = component.getNetworkService();
        sharedPreferences = component.sharedPrefences();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }

    public static BaseApp get(Context context) {

        return (BaseApp) context.getApplicationContext();
    }
}
