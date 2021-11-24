package com.example.nestedjsonobject.di.component;


import android.content.SharedPreferences;


import com.example.nestedjsonobject.ui.MainActivity;
import com.example.nestedjsonobject.di.module.RetrofitModule;
import com.example.nestedjsonobject.di.module.SharedPrefModule;
import com.example.nestedjsonobject.di.scope.ApplicationScope;
import com.example.nestedjsonobject.network_service.ApiInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {RetrofitModule.class, SharedPrefModule.class})
public interface ApplicationComponent {

    ApiInterface getNetworkService();

    SharedPreferences sharedPrefences();

    void inject(MainActivity mainActivity);
}

