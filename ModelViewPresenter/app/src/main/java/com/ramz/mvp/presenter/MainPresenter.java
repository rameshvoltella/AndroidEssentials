package com.ramz.mvp.presenter;


import java.io.File;

/**
 * Created by munnaz on 20/10/16.
 * interface holds the MainPresenter controls
 */
public interface MainPresenter {

    void onButtonClicked(File files);

    void onItemClicked(String path);


}
