package com.ramz.mvp.presenter;


import java.io.File;

/**
 * Created by munnaz on 26/10/16.
 * callback which pass data to presenter
 */

public interface FilemanagerPresenter {

    interface OnFinishedListener {

        void onFinishedFileOperation(File[] files);

    }

    void getDiretory(OnFinishedListener onFinishedListener, File path);
}
