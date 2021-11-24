package com.example.nestedjsonobject.ui.view;

import com.example.nestedjsonobject.ui.model.DataModel;
import com.example.nestedjsonobject.ui.model.MainModel;

import java.util.List;

public interface MainView {

    void showProgressBar();

    void hideProgressBar();

    void onFailure(String onError);

    void getInfo(MainModel mainModel);

}
