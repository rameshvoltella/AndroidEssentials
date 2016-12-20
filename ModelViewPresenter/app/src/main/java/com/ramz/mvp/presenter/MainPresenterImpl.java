package com.ramz.mvp.presenter;

import android.content.Context;
import android.widget.Toast;


import java.io.File;

/**
 * Created by munnaz on 20/12/16.
 * Main presenter class where  operation been taken place
 *  */
public class MainPresenterImpl implements MainPresenter,FilemanagerPresenter.OnFinishedListener{


    private FilemanagerPresenter mFileManagerPresenter;
    private FileView mFileView;
    private Context mContext;

    /**
     * Creating a constructor
     */
    public MainPresenterImpl(FilemanagerPresenter mFileManagerPresenter, Context mContext,FileView mFileView) {
        this.mFileManagerPresenter=mFileManagerPresenter;
        this.mContext=mContext;
        this.mFileView=mFileView;
    }

    public MainPresenterImpl(Context mContext)
    {
        this.mContext=mContext;
    }


    /**
     * Called when file operation retrns the results
     * @param files which gives the list of files in the selected folder(or file)
     */
    @Override
    public void onFinishedFileOperation(File[] files) {
        //Pass the result to the mainView so that we can set the result in the view or do any operation as per the requirement
        mFileView.setView(files);
    }

    /**
     * Called when user click ListFiles button
     * @param files which gives the filename which need to list
     */
    @Override
    public void onButtonClicked(File files) {
        //The getDiretory methord in FilemanagerPresenterImpl is called to perform the file operation
        mFileManagerPresenter.getDiretory(this,files);
    }

    @Override
    public void onItemClicked(String path) {

        Toast.makeText(mContext,"Selected Path "+path,Toast.LENGTH_SHORT).show();
    }
}
