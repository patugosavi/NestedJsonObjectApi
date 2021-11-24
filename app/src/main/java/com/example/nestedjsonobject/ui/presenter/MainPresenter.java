package com.example.nestedjsonobject.ui.presenter;

import com.example.nestedjsonobject.network_service.ApiInterface;
import com.example.nestedjsonobject.ui.model.MainModel;
import com.example.nestedjsonobject.ui.view.MainView;
import com.example.nestedjsonobject.utils.ErrorUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private static final String TAG = "MainPresenter";
    private MainView mainView;
    private ApiInterface apiInterface;
    private Disposable disposable;

    public MainPresenter(MainView mainView, ApiInterface apiInterface) {
        this.mainView = mainView;
        this.apiInterface = apiInterface;
    }

    public void dispose() {

        if (disposable != null)
            disposable.dispose();
    }


    public void getInfo() {
//        if (mainView!=null)
//            mainView.showProgressBar();
        Observable<MainModel> observable = apiInterface.getInfo();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(MainModel mainModel) {
                        if (mainView != null) {
                            mainView.getInfo(mainModel);
//                            staffView.hideProgressBar();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
//                        staffView.hideProgressBar();
                        mainView.onFailure(ErrorUtil.onError(e));
                    }

                    @Override
                    public void onComplete() {
//                        if (staffView!=null)
//                            staffView.hideProgressBar();
                    }
                });


    }

}
