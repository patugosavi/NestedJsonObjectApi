package com.example.nestedjsonobject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nestedjsonobject.R;
import com.example.nestedjsonobject.baseclass.BaseActivity;
import com.example.nestedjsonobject.di.component.ApplicationComponent;
import com.example.nestedjsonobject.network_service.ApiInterface;
import com.example.nestedjsonobject.ui.adapter.MainAdapter;
import com.example.nestedjsonobject.ui.model.DataModel;
import com.example.nestedjsonobject.ui.model.MainModel;
import com.example.nestedjsonobject.ui.model.SupportModel;
import com.example.nestedjsonobject.ui.presenter.MainPresenter;
import com.example.nestedjsonobject.ui.view.MainView;
import com.example.nestedjsonobject.utils.BaseApp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.tv_page) TextView tv_page;
    @BindView(R.id.tv_per_page) TextView tv_per_page;
    @BindView(R.id.tv_total) TextView tv_total;
    @BindView(R.id.tv_total_page) TextView tv_total_page;
    @BindView(R.id.tv_url) TextView tv_url;
    @BindView(R.id.tv_text) TextView tv_text;

    @BindView(R.id.rv_datalist)
    RecyclerView rv_datalist;

    @Inject
    ApiInterface apiInterface;

    MainPresenter presenter;

    Context mContext;

    List<DataModel> dataModelList=new ArrayList<>();

    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=getApplicationContext();

        ButterKnife.bind(this);
        presenter = new MainPresenter(this,apiInterface);

        presenter.getInfo();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_datalist.setLayoutManager(layoutManager);
        rv_datalist.setItemAnimator(new DefaultItemAnimator());
        mainAdapter = new MainAdapter(this, dataModelList/*,this*/);
//        rv_datalist.setHasFixedSize(true);
        rv_datalist.setAdapter(mainAdapter);

    }

    @Override
    protected void injectDependencies(BaseApp baseApp, ApplicationComponent component) {
        component.inject(this);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onFailure(String onError) {

    }

    @Override
    public void getInfo(MainModel mainModel) {
        SupportModel supportModel=mainModel.getSupportModel();


        //MainModel
        tv_page.setText(""+mainModel.getPage());
        tv_per_page.setText(""+mainModel.getPerPage());
        tv_total.setText(""+mainModel.getTotal());
        tv_total_page.setText(""+mainModel.getTotalPages());

        //SupportModel
        tv_url.setText(""+supportModel.getUrl());
        tv_text.setText(""+supportModel.getText());

        List<DataModel>  dataModelList=mainModel.getDataModelList();


        if(dataModelList!=null){
            mainAdapter.getinfo(dataModelList);
        }

    }

}